package ec.com.jmgorduez.BankOCR.domain.abstractions;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public interface ILineReader<TOKEN_TYPE extends Enum> {
    List<IToken<TOKEN_TYPE>> readLine(BufferedReader reader) throws IOException;
    void passEmptyLine(BufferedReader bufferedReader) throws IOException;
    List<IToken<TOKEN_TYPE>> generateBlankSpaceCharactersLineLikeRefillOfEmptyLine();
}
