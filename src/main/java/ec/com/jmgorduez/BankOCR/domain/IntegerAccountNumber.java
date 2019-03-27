package ec.com.jmgorduez.BankOCR.domain;

import ec.com.jmgorduez.BankOCR.domain.abstractions.IAccountNumber;
import ec.com.jmgorduez.BankOCR.domain.abstractions.ICharacter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ec.com.jmgorduez.BankOCR.domain.IntegerAccountNumber.IntegerAccountNumberClassification.*;
import static ec.com.jmgorduez.BankOCR.utils.Constants.*;

public class IntegerAccountNumber implements IAccountNumber {

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

    public IntegerAccountNumber(List<ICharacter<Integer>> digits) {
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
        return calculateCheckSum() % ELEVEN == ZERO;
    }

    @Override
    public Boolean isIllegibleAccountNumber() {
        Integer quantityOfIllegibleCharactes = digits.stream().mapToInt(digit -> {
            return digit.getValue().equals(UNDEFINED_CHARACTER_VALUE) ? ONE : ZERO;
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
    public IAccountNumber repairAccountNumber() {
        if (isRightAccountNumber()) {
            throw new UnsupportedOperationException();
        }
        return repairAuxiliary(new IntegerAccountNumber(digits), ZERO);
    }

    private IntegerAccountNumber repairAuxiliary(IntegerAccountNumber accountNumber, final Integer index) {
        if (accountNumber.isRightAccountNumber()) {
            return accountNumber;
        }
        if (index == accountNumber.digits.size()) {
            throw new IllegalArgumentException();
        }
        List<ICharacter<Integer>> similarCharacters
                = digits.get(index).getSimilarCharacters();
        List<IntegerAccountNumber> repairedAccountNumbers =
                similarCharacters.stream().map(similarCharacter -> {
                    List<ICharacter<Integer>> digits = new ArrayList<>(accountNumber.digits);
                    digits.set(index, similarCharacter);
                    try {
                        Integer newIndex = index + ONE;
                        return repairAuxiliary(new IntegerAccountNumber(digits), newIndex);
                    }catch (IllegalArgumentException error){
                        return null;
                    }
                }).filter(accountNumberRepaired -> accountNumberRepaired != null)
                .collect(Collectors.toList());
        if(repairedAccountNumbers.isEmpty()){
            throw new IllegalArgumentException();
        }
        return repairedAccountNumbers.get(ZERO);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IntegerAccountNumber)) {
            return false;
        }
        return ((IntegerAccountNumber) other).value.equals(this.value)
                && ((IntegerAccountNumber) other).digits.equals(this.digits);
    }
}
