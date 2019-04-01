package ec.com.jmgorduez.BankOCR.domain.abstractions;

import ec.com.jmgorduez.BankOCR.domain.DigitToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public interface IAccountNumberFileProcessor<TYPE_CLASSIFICATION extends Enum> {
    List<IAccountNumber<TYPE_CLASSIFICATION>> processFile(BufferedReader bufferedReaderSupplier,
                     ILineReader<DigitToken.TokenType> lineReader,
                     IMultilineStringReader multilineStringReader,
                     IMultilineCharacterReader<DigitToken.TokenType> multilineCharacterReader,
                     IAccountNumberReader<DigitToken.TokenType> accountNumberReader,
                     Consumer<IAccountNumber<TYPE_CLASSIFICATION>> writeOutput) throws IOException;
    List<IAccountNumber<TYPE_CLASSIFICATION>> repairAccountNumbers(IMultilineCharacterReader<DigitToken.TokenType> multilineCharacterReader,
                     Consumer<IAccountNumber<TYPE_CLASSIFICATION>> writeOutput) throws IOException;
}
