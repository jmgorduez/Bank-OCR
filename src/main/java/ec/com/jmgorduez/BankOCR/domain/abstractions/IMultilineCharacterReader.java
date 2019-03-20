package ec.com.jmgorduez.BankOCR.domain.abstractions;

public interface IMultilineCharacterReader<CHARACTER_TYPE, TOKEN_TYPE extends Enum> {
    ICharacter<CHARACTER_TYPE> readCharacter(IMultilineString<IToken<TOKEN_TYPE>> multilineCharacterToRead);
}
