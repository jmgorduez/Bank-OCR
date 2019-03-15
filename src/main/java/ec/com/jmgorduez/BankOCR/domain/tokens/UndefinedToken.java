package ec.com.jmgorduez.BankOCR.domain.tokens;

import ec.com.jmgorduez.BankOCR.domain.abstractions.AbstractToken;
import ec.com.jmgorduez.BankOCR.domain.abstractions.IToken;

public class UndefinedToken extends AbstractToken {

    public UndefinedToken(){
        super("?");
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
