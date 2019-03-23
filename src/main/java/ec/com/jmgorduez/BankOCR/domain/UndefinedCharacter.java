package ec.com.jmgorduez.BankOCR.domain;

import ec.com.jmgorduez.BankOCR.domain.abstractions.ICharacter;
import ec.com.jmgorduez.BankOCR.utils.Constants;

import static ec.com.jmgorduez.BankOCR.utils.Constants.UNDEFINED_CHARACTER_VALUE;

public class UndefinedCharacter implements ICharacter<String> {

    public UndefinedCharacter(Integer[][] binaryMatrix){

    }

    @Override
    public String getValue() {
        return UNDEFINED_CHARACTER_VALUE;
    }

    @Override
    public int getBinaryCode() {
        return 0;
    }
}
