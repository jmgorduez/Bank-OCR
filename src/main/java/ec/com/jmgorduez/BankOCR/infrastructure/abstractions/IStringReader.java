package ec.com.jmgorduez.BankOCR.infrastructure.abstractions;

import ec.com.jmgorduez.BankOCR.domain.abstractions.ICharacter;

import java.util.List;

public interface IStringReader<CHARACTER_TYPE, TOKEN_TYPE extends Enum> {
    List<ICharacter<CHARACTER_TYPE>> read(ILineReader<TOKEN_TYPE> lineReader, ICharacterReader<CHARACTER_TYPE, TOKEN_TYPE> charaterReader);
}
