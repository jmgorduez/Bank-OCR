package ec.com.jmgorduez.BankOCR.domain;

import ec.com.jmgorduez.BankOCR.domain.abstractions.IAccountNumber;

public class IntegerAccountNumber implements IAccountNumber {

    private String value;

    public IntegerAccountNumber(String value){
        this.value = value;
    }
    
    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public Integer calculateCheckSum() {
        return null;
    }

    @Override
    public boolean equals(Object other){
        if (this == other){
            return true;
        }
        if(!(other instanceof IntegerAccountNumber)){
            return false;
        }
        return ((IntegerAccountNumber)other).value.equals(this.value);
    }
}
