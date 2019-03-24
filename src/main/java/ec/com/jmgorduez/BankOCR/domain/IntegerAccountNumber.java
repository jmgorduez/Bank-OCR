package ec.com.jmgorduez.BankOCR.domain;

import ec.com.jmgorduez.BankOCR.domain.abstractions.IAccountNumber;

import java.util.Arrays;
import java.util.stream.Stream;

import static ec.com.jmgorduez.BankOCR.utils.Constants.*;

public class IntegerAccountNumber implements IAccountNumber {

    private String value;
    private Integer[] characters;

    public IntegerAccountNumber(String value, Integer[] characters) {
        this.value = value;
        this.characters = characters;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public Integer calculateCheckSum() {
        Integer checkSum = Stream.iterate(ONE, index -> index + ONE).limit(characters.length)
                .mapToInt(index -> {
                    Integer digit = characters[characters.length - index];
                    return index * digit;
                })
                .sum();
        return checkSum;
    }

    @Override
    public Integer[] getCharacters() {
        return this.characters;
    }

    @Override
    public Boolean isRightAccountNumber() {
        return calculateCheckSum() % ELEVEN == ZERO;
    }

    @Override
    public Boolean isIllegibleAccountNumber() {
        Integer quantityOfIllegibleCharactes = Arrays.stream(characters).mapToInt(integer -> {
            return integer.equals(UNDEFINED_CHARACTER_VALUE) ? ONE : ZERO;
        }).sum();
        return quantityOfIllegibleCharactes > 0;
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
                && Arrays.equals(((IntegerAccountNumber) other).getCharacters(),
                this.getCharacters());
    }
}
