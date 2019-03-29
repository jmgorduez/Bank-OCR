package ec.com.jmgorduez.BankOCR.domain.abstractions;

import ec.com.jmgorduez.BankOCR.domain.DigitToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.function.Consumer;
import java.util.function.Supplier;

public interface IAccountNumberFileProcessor {
    void processFile(BufferedReader bufferedReaderSupplier,
                     ILineReader<DigitToken.TokenType> lineReader,
                     IMultilineStringReader multilineStringReader,
                     IMultilineCharacterReader<DigitToken.TokenType> multilineCharacterReader,
                     IAccountNumberReader<DigitToken.TokenType> accountNumberReader,
                     Consumer<IAccountNumber> writeOutput) throws IOException;
}
