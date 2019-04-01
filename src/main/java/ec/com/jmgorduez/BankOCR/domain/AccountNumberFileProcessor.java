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

public class AccountNumberFileProcessor implements IAccountNumberFileProcessor<AccountNumber.IntegerAccountNumberClassification> {

    @Override
    public List<IAccountNumber<AccountNumber.IntegerAccountNumberClassification>> processFile(BufferedReader bufferedReader,
                            ILineReader<DigitToken.TokenType> lineReader,
                            IMultilineStringReader multilineStringReader,
                            IMultilineCharacterReader<DigitToken.TokenType> multilineCharacterReader,
                            IAccountNumberReader<DigitToken.TokenType> accountNumberReader,
                            Consumer<IAccountNumber<AccountNumber.IntegerAccountNumberClassification>> writeOutput)
            throws IOException {
        List<IAccountNumber<AccountNumber.IntegerAccountNumberClassification>> accountNumbers
                = new ArrayList<>();
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
        return accountNumbers;
    }

    @Override
    public List<IAccountNumber<AccountNumber.IntegerAccountNumberClassification>> repairAccountNumbers(IMultilineCharacterReader<DigitToken.TokenType> multilineCharacterReader,
                                     Consumer<IAccountNumber<AccountNumber.IntegerAccountNumberClassification>> writeOutput) throws IOException {
        List<IAccountNumber<AccountNumber.IntegerAccountNumberClassification>> accountNumbers
                = new ArrayList<>();
        accountNumbers.stream().forEach(accountNumber -> {
            try {
                IAccountNumber<AccountNumber.IntegerAccountNumberClassification> repairedAccountNumber
                        = accountNumber.repairAccountNumber(multilineCharacterReader);
                writeOutput.accept(repairedAccountNumber);
                accountNumbers.add(repairedAccountNumber);
            }catch (UnsupportedOperationException error){
                writeOutput.accept(accountNumber);
            }
        });
        return accountNumbers;
    }
}
