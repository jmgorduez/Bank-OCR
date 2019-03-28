package ec.com.jmgorduez.BankOCR.domain;

import ec.com.jmgorduez.BankOCR.domain.abstractions.IAccountNumber;
import ec.com.jmgorduez.BankOCR.domain.abstractions.ICharacter;
import ec.com.jmgorduez.BankOCR.domain.abstractions.IMultilineCharacterReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ec.com.jmgorduez.BankOCR.domain.AccountNumber.IntegerAccountNumberClassification.*;
import static ec.com.jmgorduez.BankOCR.utils.Constants.*;

public class AccountNumber implements IAccountNumber {

    public enum IntegerAccountNumberClassification {
        RIG(EMPTY_STRING),
        ERR(STRING_ERR),
        ILL(STRING_ILL);

        private final String value;

        private IntegerAccountNumberClassification(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    private String value;
    private List<ICharacter> digits;

    public AccountNumber(List<ICharacter> digits) {
        this.value = digits.stream().map(digit -> digit.getStringValue())
                .collect(Collectors.joining());
        this.digits = digits;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public Integer calculateCheckSum() {
        return Stream.iterate(ONE, index -> index + ONE).limit(digits.size())
                .mapToInt(index -> getDigit(index).calculateCheckSumValue(index))
                .sum();
    }

    @Override
    public ICharacter getDigit(Integer index) {
        return digits.get(digits.size() - index);
    }

    @Override
    public Boolean isRightAccountNumber(IMultilineCharacterReader multilineCharacterReader) {
        if (isIllegibleAccountNumber(multilineCharacterReader)) {
            return false;
        }
        Integer restOfDivision = calculateCheckSum() % ELEVEN;
        return restOfDivision.equals(ZERO);
    }

    @Override
    public Boolean isIllegibleAccountNumber(IMultilineCharacterReader multilineCharacterReader) {
        Integer quantityOfIllegibleCharactes = digits.stream()
                .mapToInt(digit -> multilineCharacterReader.isUndefinedDigit(digit) ? ONE : ZERO)
                .sum();
        return quantityOfIllegibleCharactes > 0;
    }

    @Override
    public IntegerAccountNumberClassification getAccountNumberClassification(IMultilineCharacterReader multilineCharacterReader) {
        if (isIllegibleAccountNumber(multilineCharacterReader)) {
            return ILL;
        }
        if (!isRightAccountNumber(multilineCharacterReader)) {
            return ERR;
        }
        return RIG;
    }

    @Override
    public IAccountNumber repairAccountNumber(IMultilineCharacterReader multilineCharacterReader) {
        if (isRightAccountNumber(multilineCharacterReader)) {
            throw new UnsupportedOperationException();
        }
        List<AccountNumber> numbersResulting
                = calculatePosibleRightNumbers(ONE, multilineCharacterReader);
        Optional<AccountNumber> result = numbersResulting.stream()
                .reduce((accountNumber1, accountNumber2) ->
                        getMoreSimilarAccountNumber(accountNumber1, accountNumber2));
        return result.map(accountNumber -> accountNumber)
                .orElseThrow(UnsupportedOperationException::new);
    }

    AccountNumber getMoreSimilarAccountNumber(AccountNumber accountNumber1, AccountNumber accountNumber2) {
        return this.howManyDigitsAreEquals(accountNumber1) > this.howManyDigitsAreEquals(accountNumber2)
                ? accountNumber1 : accountNumber2;
    }

    List<AccountNumber> calculatePosibleRightNumbers(
            Integer index,
            IMultilineCharacterReader multilineCharacterReader) {
        List<AccountNumber> numbersResulting = new ArrayList<>();
        if (isRightAccountNumber(multilineCharacterReader)) {
            numbersResulting.add(this);
            return numbersResulting;
        }
        if (index > digits.size()) {
            return new ArrayList<>();
        }
        Integer newIndex = index + ONE;
        getDigit(index).getSimilarCharacters(multilineCharacterReader).stream()
                .map(similarCharacter -> copyAccountNumberChargingCharacterAt(index, similarCharacter))
                .forEach(newAccountNumber -> {
                    numbersResulting.addAll(
                            newAccountNumber
                                    .calculatePosibleRightNumbers(newIndex, multilineCharacterReader));
                });
        numbersResulting.addAll(
                calculatePosibleRightNumbers(newIndex, multilineCharacterReader));
        return numbersResulting;
    }

    AccountNumber copyAccountNumberChargingCharacterAt(Integer index, ICharacter character) {
        List<ICharacter> digits = new ArrayList<>(this.digits);
        digits.set(digits.size() - index, character);
        return new AccountNumber(digits);
    }

    Integer howManyDigitsAreEquals(AccountNumber accountNumber) {
        return Stream.iterate(ONE, index -> index + ONE).limit(digits.size())
                .mapToInt(index -> {
                    return getDigit(index).equals(accountNumber.getDigit(index)) ? ONE : ZERO;
                }).sum();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AccountNumber)) {
            return false;
        }
        return ((AccountNumber) other).value.equals(this.value)
                && ((AccountNumber) other).digits.equals(this.digits);
    }
}
