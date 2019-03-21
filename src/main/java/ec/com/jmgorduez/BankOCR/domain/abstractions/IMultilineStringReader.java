package ec.com.jmgorduez.BankOCR.domain.abstractions;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public interface IMultilineStringReader<CHARACTER_TYPE, TOKEN_TYPE extends Enum> {
    List<ICharacter<CHARACTER_TYPE>> readMultilineString(BufferedReader bufferedReader,
                                                         ILineReader<TOKEN_TYPE> lineReader,
                                                         IMultilineCharacterReader<CHARACTER_TYPE, TOKEN_TYPE> charaterReader)
            throws IOException;
}
