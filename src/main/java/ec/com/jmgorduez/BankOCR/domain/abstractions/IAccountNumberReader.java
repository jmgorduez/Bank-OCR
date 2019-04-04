package ec.com.jmgorduez.BankOCR.domain.abstractions;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public interface IAccountNumberReader<TOKEN_TYPE extends Enum> {
    IAccountNumber readAccountNumber(BufferedReader bufferedReader,
                                     ILineReader<TOKEN_TYPE> readLine,
                                     IMultilineCharacterReader< TOKEN_TYPE> charaterReader,
                                     IMultilineStringReader<TOKEN_TYPE> multilineStringReader)
            throws IOException, StringIndexOutOfBoundsException;
}
