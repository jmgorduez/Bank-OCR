package ec.com.jmgorduez.BankOCR.domain.abstractions;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public interface IMultilineStringReader<TOKEN_TYPE extends Enum> {
    List<ICharacter> readMultilineString(BufferedReader bufferedReader,
                                                         ILineReader<TOKEN_TYPE> lineReader,
                                                         IMultilineCharacterReader< TOKEN_TYPE> charaterReader)
            throws IOException;
}
