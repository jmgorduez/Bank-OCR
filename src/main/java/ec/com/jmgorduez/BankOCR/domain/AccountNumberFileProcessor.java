package ec.com.jmgorduez.BankOCR.domain;

import ec.com.jmgorduez.BankOCR.domain.abstractions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static ec.com.jmgorduez.BankOCR.utils.Constants.BLANK_SPACE_STRING;

public class AccountNumberFileProcessor implements IAccountNumberFileProcessor {

    @Override
    public void processFile(BufferedReader bufferedReader,
                            ILineReader<DigitToken.TokenType> lineReader,
                            IMultilineStringReader multilineStringReader,
                            IMultilineCharacterReader<DigitToken.TokenType> multilineCharacterReader,
                            IAccountNumberReader<DigitToken.TokenType> accountNumberReader,
                            Consumer<IAccountNumber> writeOutput)
            throws IOException, UnsupportedOperationException {
        do {
            IAccountNumber accountNumber = accountNumberReader
                    .readAccountNumber(bufferedReader,
                            lineReader,
                            multilineCharacterReader,
                            multilineStringReader);
            StringBuilder stringBuilder
                    = new StringBuilder(accountNumber.getValue());
            stringBuilder.append(BLANK_SPACE_STRING)
                    .append(((AccountNumber.IntegerAccountNumberClassification)
                            accountNumber.getAccountNumberClassification(multilineCharacterReader)).getValue());
            System.out.println(stringBuilder.toString());
        } while (true);
    }
}
