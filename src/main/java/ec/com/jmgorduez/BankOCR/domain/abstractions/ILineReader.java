package ec.com.jmgorduez.BankOCR.domain.abstractions;

import ec.com.jmgorduez.BankOCR.domain.abstractions.IToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public interface ILineReader<T extends Enum> {
    List<IToken<T>> readLine(BufferedReader reader) throws IOException;
    void passEmptyLine(BufferedReader bufferedReader) throws IOException;
}
