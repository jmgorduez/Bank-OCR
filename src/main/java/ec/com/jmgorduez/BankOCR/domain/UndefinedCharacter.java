package ec.com.jmgorduez.BankOCR.domain;

import ec.com.jmgorduez.BankOCR.domain.abstractions.ICharacter;

public class UndefinedCharacter implements ICharacter<String> {

    public UndefinedCharacter(Integer[][] binaryMatrix){

    }

    @Override
    public String getValue() {
        return null;
    }

    @Override
    public int getBinaryCode() {
        return 0;
    }
}
