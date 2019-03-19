package ec.com.jmgorduez.BankOCR.infrastructure.abstractions;

import ec.com.jmgorduez.BankOCR.domain.abstractions.ICharacter;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public interface IMultilineStringReader<CHARACTER_TYPE, TOKEN_TYPE extends Enum> {
    List<ICharacter<CHARACTER_TYPE>> read(BufferedReader bufferedReader,
                                          ILineReader<TOKEN_TYPE> lineReader,
                                          IMultilineCharacterReader<CHARACTER_TYPE, TOKEN_TYPE> charaterReader)
            throws IOException;
}
