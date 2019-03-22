package ec.com.jmgorduez.BankOCR.domain.abstractions;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public interface IAccountNumberReader<TOKEN_TYPE extends Enum, CHARACTER_TYPE> {
    IAccountNumber readAccountNumber(BufferedReader bufferedReader,
                                     ILineReader<TOKEN_TYPE> lineReader,
                                     IMultilineCharacterReader<CHARACTER_TYPE, TOKEN_TYPE> charaterReader,
                                     IMultilineStringReader<CHARACTER_TYPE, TOKEN_TYPE> multilineStringReader)
            throws IOException;
}
