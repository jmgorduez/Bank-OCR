package ec.com.jmgorduez.BankOCR.domain.abstractions;

public interface IMultilineCharacterReader<TOKEN_TYPE extends Enum> {
    ICharacter readCharacter(IMultilineString<IToken<TOKEN_TYPE>> multilineCharacterToRead);
    ICharacter readCharacter(Integer[][] binaryMatrix);
    boolean isUndefinedDigit(ICharacter digit);
}
