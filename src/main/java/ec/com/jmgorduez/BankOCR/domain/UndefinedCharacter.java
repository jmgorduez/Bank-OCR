package ec.com.jmgorduez.BankOCR.domain;

import ec.com.jmgorduez.BankOCR.domain.abstractions.AbstractCharacter;
import ec.com.jmgorduez.BankOCR.domain.abstractions.ICharacter;

import java.util.List;
import java.util.Objects;

import static ec.com.jmgorduez.BankOCR.utils.Constants.UNDEFINED_CHARACTER_STRING_VALUE;
import static ec.com.jmgorduez.BankOCR.utils.Constants.UNDEFINED_CHARACTER_VALUE;

public class UndefinedCharacter extends AbstractCharacter<Integer> {

    public UndefinedCharacter(Integer[][] binaryMatrix) {
        super(UNDEFINED_CHARACTER_VALUE, binaryMatrix);
    }

    @Override
    public String getStringValue() {
        return UNDEFINED_CHARACTER_STRING_VALUE;
    }

    @Override
    protected ICharacter<Integer> getInstance(Integer[][] binaryMatrix) throws IllegalArgumentException {
        return new UndefinedCharacter(binaryMatrix);
    }

    public boolean equals(Object other) {

        if (other == this) {
            return true;
        }
        if (!(other instanceof UndefinedCharacter)) {
            return false;
        }
        return ((UndefinedCharacter) other).value.equals(this.value);
    }

    public int hashCode() {

        return Objects.hashCode(this.value);
    }
}
