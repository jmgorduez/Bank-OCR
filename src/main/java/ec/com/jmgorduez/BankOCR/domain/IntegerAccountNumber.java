package ec.com.jmgorduez.BankOCR.domain;

import ec.com.jmgorduez.BankOCR.domain.abstractions.IAccountNumber;

public class IntegerAccountNumber implements IAccountNumber<Integer> {

    private Integer value;

    public IntegerAccountNumber(Integer value){
        this.value = value;
    }
    
    @Override
    public Integer getValue() {
        return this.value;
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
