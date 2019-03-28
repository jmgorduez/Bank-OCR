package ec.com.jmgorduez.BankOCR.domain;

import ec.com.jmgorduez.BankOCR.domain.abstractions.IAccountNumber;
import ec.com.jmgorduez.BankOCR.domain.abstractions.ICharacter;
import ec.com.jmgorduez.BankOCR.domain.abstractions.IMultilineCharacterReader;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
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
    private List<ICharacter<Integer>> digits;

    public AccountNumber(List<ICharacter<Integer>> digits) {
        this.value = digits.stream().map(digit -> {
            return digit.getStringValue();
        }).collect(Collectors.joining());
        this.digits = digits;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public Integer calculateCheckSum() {
        Integer checkSum = Stream.iterate(ONE, index -> index + ONE).limit(digits.size())
                .mapToInt(index -> {
                    Integer digit = digits.get(digits.size() - index).getValue();
                    return index * digit;
                })
                .sum();
        return checkSum;
    }

    @Override
    public Boolean isRightAccountNumber() {
        if (isIllegibleAccountNumber()) {
            return false;
        }
        Integer restOfDivision = calculateCheckSum() % ELEVEN;
        return restOfDivision.equals(ZERO);
    }

    @Override
    public Boolean isIllegibleAccountNumber() {
        Integer quantityOfIllegibleCharactes = digits.stream().mapToInt(digit -> {
            return digit.getValue().equals(UNDEFINED_DIGIT_VALUE) ? ONE : ZERO;
        }).sum();
        return quantityOfIllegibleCharactes > 0;
    }

    @Override
    public IntegerAccountNumberClassification getAccountNumberClassification() {
        if (isIllegibleAccountNumber()) {
            return ILL;
        }
        if (!isRightAccountNumber()) {
            return ERR;
        }
        return RIG;
    }

    @Override
    public IAccountNumber repairAccountNumber(IMultilineCharacterReader multilineCharacterReader) {
        if (isRightAccountNumber()) {
            throw new UnsupportedOperationException();
        }
        List<AccountNumber> numbersResulting
                = calculatePosibleRightNumbers(new AccountNumber(digits), ZERO, multilineCharacterReader);
        Optional<AccountNumber> result = numbersResulting.stream()
                .reduce((accountNumber1, accountNumber2) -> {
                    return howManyDigitsAreEquals(accountNumber1) > howManyDigitsAreEquals(accountNumber2)
                            ? accountNumber1 : accountNumber2;
                });
        return result.map(accountNumber -> accountNumber)
                .orElseThrow(UnsupportedOperationException::new);
    }

    List<AccountNumber> calculatePosibleRightNumbers(AccountNumber accountNumber,
                                                     Integer index,
                                                     IMultilineCharacterReader multilineCharacterReader) {
        List<AccountNumber> numbersResulting = new ArrayList<>();
        if (accountNumber.isRightAccountNumber()) {
            numbersResulting.add(accountNumber);
            return numbersResulting;
        }
        if (index == accountNumber.digits.size()) {
            return new ArrayList<>();
        }
        Integer newIndex = index + ONE;
        digits.get(index).getSimilarCharacters(multilineCharacterReader).stream()
                .forEach(similarCharacter -> {
                    numbersResulting.addAll(
                            calculatePosibleRightNumbers(
                                    copyAccountNumberChangingACharacter(accountNumber, index, similarCharacter),
                                    newIndex,
                                    multilineCharacterReader));
                });
        numbersResulting.addAll(
                calculatePosibleRightNumbers(accountNumber, newIndex, multilineCharacterReader));
        return numbersResulting;
    }

    AccountNumber copyAccountNumberChangingACharacter(AccountNumber accountNumber,
                                                      Integer index,
                                                      ICharacter<Integer> character) {
        List<ICharacter<Integer>> digits = new ArrayList<>(accountNumber.digits);
        digits.set(index, character);
        return new AccountNumber(digits);
    }

    Integer howManyDigitsAreEquals(AccountNumber accountNumber) {
        return Stream.iterate(ZERO, index -> index + ONE).limit(digits.size())
                .mapToInt(index -> {
                    return this.digits.get(index).equals(accountNumber.digits.get(index)) ? ONE : ZERO;
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
