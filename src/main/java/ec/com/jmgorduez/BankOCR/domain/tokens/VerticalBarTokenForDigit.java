package ec.com.jmgorduez.BankOCR.domain.tokens;

import ec.com.jmgorduez.BankOCR.domain.abstractions.AbstractToken;

public class VerticalBarTokenForDigit extends AbstractToken {

    public VerticalBarTokenForDigit(){
        super("|");
    }

    @Override
    public boolean isMyLevelValid() {
        return false;
    }

    @Override
    public boolean isTokenValidForNextLevel() {
        return false;
    }
}
