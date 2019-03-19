package ec.com.jmgorduez.BankOCR.infrastructure.abstractions;

import ec.com.jmgorduez.BankOCR.domain.abstractions.ICharacter;
import ec.com.jmgorduez.BankOCR.domain.abstractions.IToken;
import ec.com.jmgorduez.BankOCR.infrastructure.MultilineString;

public interface IMultilineCharacterReader<CHARACTER_TYPE, TOKEN_TYPE extends Enum> {
    ICharacter<CHARACTER_TYPE> readCharacter(IMultilineString<IToken<TOKEN_TYPE>> multilineCharacterToRead);
}
