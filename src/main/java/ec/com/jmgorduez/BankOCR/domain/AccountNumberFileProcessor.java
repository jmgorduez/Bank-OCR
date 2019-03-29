package ec.com.jmgorduez.BankOCR.domain;

import ec.com.jmgorduez.BankOCR.domain.abstractions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static ec.com.jmgorduez.BankOCR.utils.Constants.BLANK_SPACE_STRING;

public class AccountNumberFileProcessor implements IAccountNumberFileProcessor {

    private List<IAccountNumber> accountNumbers = new ArrayList<>();

    @Override
    public void processFile(BufferedReader bufferedReader,
                            ILineReader<DigitToken.TokenType> lineReader,
                            IMultilineStringReader multilineStringReader,
                            IMultilineCharacterReader<DigitToken.TokenType> multilineCharacterReader,
                            IAccountNumberReader<DigitToken.TokenType> accountNumberReader,
                            Consumer<IAccountNumber> writeOutput)
            throws IOException {
        try {
            do {
                IAccountNumber accountNumber = accountNumberReader
                        .readAccountNumber(bufferedReader,
                                lineReader,
                                multilineCharacterReader,
                                multilineStringReader);
                accountNumbers.add(accountNumber);
                writeOutput.accept(accountNumber);
            } while (true);
        } catch (UnsupportedOperationException e) {
        }

    }

    @Override
    public void repairAccountNumbers(IMultilineCharacterReader<DigitToken.TokenType> multilineCharacterReader,
                                     Consumer<IAccountNumber> writeOutput) throws IOException {
        accountNumbers.stream().forEach(accountNumber -> {
            try {
                writeOutput.accept(accountNumber.repairAccountNumber(multilineCharacterReader));
            }catch (UnsupportedOperationException error){
                writeOutput.accept(accountNumber);
            }
        });
    }
}
