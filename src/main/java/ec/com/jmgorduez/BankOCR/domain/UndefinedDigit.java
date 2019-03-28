package ec.com.jmgorduez.BankOCR.domain;

import ec.com.jmgorduez.BankOCR.domain.abstractions.AbstractCharacter;
import ec.com.jmgorduez.BankOCR.domain.abstractions.ICharacter;

import java.util.Objects;

import static ec.com.jmgorduez.BankOCR.utils.Constants.UNDEFINED_DIGIT_STRING_VALUE;
import static ec.com.jmgorduez.BankOCR.utils.Constants.UNDEFINED_DIGIT_VALUE;

public class UndefinedDigit extends AbstractCharacter {

    public UndefinedDigit(Integer[][] binaryMatrix) {
        super(UNDEFINED_DIGIT_VALUE, binaryMatrix);
    }

    @Override
    public String getStringValue() {
        return UNDEFINED_DIGIT_STRING_VALUE;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof UndefinedDigit)) {
            return false;
        }
        return ((UndefinedDigit) other).value.equals(this.value);
    }

    public int hashCode() {
        return Objects.hashCode(this.value);
    }
}
