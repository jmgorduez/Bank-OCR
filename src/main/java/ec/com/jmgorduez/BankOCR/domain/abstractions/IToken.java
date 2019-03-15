package ec.com.jmgorduez.BankOCR.domain.abstractions;

import ec.com.jmgorduez.BankOCR.domain.tokens.TokenLevel;

public interface IToken {
    boolean isMyLevelValid();
    TokenLevel getLevel();
    boolean isTokenValidForNextLevel();
}
