package ec.com.jmgorduez.BankOCR.domain.tokens;

import ec.com.jmgorduez.BankOCR.domain.abstractions.AbstractToken;
import ec.com.jmgorduez.BankOCR.domain.abstractions.IToken;

import java.util.Objects;

public class BlankSpaceTokenForDigit extends AbstractToken {

    public BlankSpaceTokenForDigit(){
        super(" ");
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
