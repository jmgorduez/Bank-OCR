package ec.com.jmgorduez.BankOCR.domain.abstractions;

import ec.com.jmgorduez.BankOCR.domain.tokens.TokenLevel;

import java.util.Objects;

public abstract class AbstractToken implements IToken {

    private TokenLevel level;
    private final String VALUE;

    public AbstractToken(String value){
        this.VALUE = value;
    }

    @Override
    public TokenLevel getLevel() {
        return this.level;
    }

    public String getValue(){
        return this.VALUE;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof AbstractToken)) {
            return false;
        }
        return ((AbstractToken) other).VALUE == this.VALUE;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.VALUE);
    }
}
