package ec.com.jmgorduez.BankOCR.domain;

import ec.com.jmgorduez.BankOCR.domain.abstractions.AbstractCharacter;
import ec.com.jmgorduez.BankOCR.domain.abstractions.ICharacter;

import java.util.List;

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
}
