package ec.com.jmgorduez.BankOCR.domain;

import ec.com.jmgorduez.BankOCR.domain.abstractions.AbstractCharacter;

import static ec.com.jmgorduez.BankOCR.utils.Constants.UNDEFINED_CHARACTER_VALUE;

public class UndefinedCharacter extends AbstractCharacter<String> {

    public UndefinedCharacter(Integer[][] binaryMatrix){
        super(binaryMatrix);
    }

    @Override
    public String getValue() {
        return UNDEFINED_CHARACTER_VALUE;
    }
}
