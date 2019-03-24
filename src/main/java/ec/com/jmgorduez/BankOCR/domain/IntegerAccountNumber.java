package ec.com.jmgorduez.BankOCR.domain;

import ec.com.jmgorduez.BankOCR.domain.abstractions.IAccountNumber;

import java.util.stream.Stream;

import static ec.com.jmgorduez.BankOCR.utils.Constants.NINE;
import static ec.com.jmgorduez.BankOCR.utils.Constants.ONE;

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
        Stream.iterate(ONE, index -> index + ONE).limit(NINE)
                .mapToInt(index -> {
                    return value.toCharArray()[index - 1];
                });
        return null;
    }

    @Override
    public Integer[] getCharacters() {
        return this.characters;
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
                && ((IntegerAccountNumber) other).getCharacters().equals(this.getCharacters());
    }
}
