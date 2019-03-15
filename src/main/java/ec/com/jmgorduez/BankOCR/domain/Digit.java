package ec.com.jmgorduez.BankOCR.domain;

import ec.com.jmgorduez.BankOCR.domain.abstractions.ICharacter;

import java.util.Objects;

public class Digit implements ICharacter<Integer> {
    private Integer value;

    public Digit(Integer value){
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Digit)) {
            return false;
        }
        return ((Digit) other).value == this.value;
    }

    public int hashCode() {
        return Objects.hashCode(this.value);
    }

}
