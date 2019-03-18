package ec.com.jmgorduez.BankOCR.infrastructure.abstractions;

import ec.com.jmgorduez.BankOCR.domain.abstractions.ICharacter;
import ec.com.jmgorduez.BankOCR.domain.abstractions.IToken;

public interface ICharacterReader<CHARACTER_TYPE, TOKEN_TYPE extends Enum> {
    ICharacter<CHARACTER_TYPE> readCharacter(IToken<TOKEN_TYPE>[][] tokenToRead);
}
