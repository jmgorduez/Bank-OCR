package ec.com.jmgorduez.BankOCR.domain.abstractions;

import ec.com.jmgorduez.BankOCR.domain.DigitToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

public interface IAccountNumberFileProcessor<CHARACTER_TYPE extends Enum, TYPE_CLASSIFICATION extends Enum> {
    List<IAccountNumber<TYPE_CLASSIFICATION>> processFile(BufferedReader bufferedReaderSupplier,
                     ILineReader<DigitToken.TokenType> lineReader,
                     IMultilineStringReader multilineStringReader,
                     IMultilineCharacterReader<CHARACTER_TYPE> multilineCharacterReader,
                     IAccountNumberReader<DigitToken.TokenType> accountNumberReader,
                     Consumer<IAccountNumber<TYPE_CLASSIFICATION>> writeOutput)
            throws IOException, StringIndexOutOfBoundsException;
    List<IAccountNumber<TYPE_CLASSIFICATION>> repairAccountNumbers(List<IAccountNumber<TYPE_CLASSIFICATION>> accountNumbersToRepair,
                                                                   IMultilineCharacterReader<CHARACTER_TYPE> multilineCharacterReader,
                                                                   Consumer<IAccountNumber<TYPE_CLASSIFICATION>> writeOutput);
}
