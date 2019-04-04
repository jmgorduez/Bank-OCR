package ec.com.jmgorduez.BankOCR.domain;

import ec.com.jmgorduez.BankOCR.domain.abstractions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class AccountNumberFileProcessor implements IAccountNumberFileProcessor<DigitToken.TokenType, AccountNumber.IntegerAccountNumberClassification> {

    @Override
    public List<IAccountNumber<AccountNumber.IntegerAccountNumberClassification>> processFile(BufferedReader bufferedReader,
                                                                                              ILineReader<DigitToken.TokenType> lineReader,
                                                                                              IMultilineStringReader multilineStringReader,
                                                                                              IMultilineCharacterReader<DigitToken.TokenType> multilineCharacterReader,
                                                                                              IAccountNumberReader<DigitToken.TokenType> accountNumberReader,
                                                                                              Consumer<IAccountNumber<AccountNumber.IntegerAccountNumberClassification>> writeOutput)
            throws IOException, StringIndexOutOfBoundsException {
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
    public List<IAccountNumber<AccountNumber.IntegerAccountNumberClassification>> repairAccountNumbers(
            List<IAccountNumber<AccountNumber.IntegerAccountNumberClassification>> accountNumbersToRepair,
            IMultilineCharacterReader<DigitToken.TokenType> multilineCharacterReader,
            Consumer<IAccountNumber<AccountNumber.IntegerAccountNumberClassification>> writeOutput) {
        return accountNumbersToRepair.stream()
                .map(accountNumber ->
                        repairAccountNumber(multilineCharacterReader, writeOutput, accountNumber))
                .filter(accountNumber -> accountNumber.isPresent())
                .map(accountNumber -> accountNumber.get())
                .collect(Collectors.toList());
    }

    Optional<IAccountNumber<AccountNumber.IntegerAccountNumberClassification>> repairAccountNumber(IMultilineCharacterReader<DigitToken.TokenType> multilineCharacterReader,
                                                                                                   Consumer<IAccountNumber<AccountNumber.IntegerAccountNumberClassification>> writeOutput,
                                                                                                   IAccountNumber<AccountNumber.IntegerAccountNumberClassification> accountNumber) {
        try {
            IAccountNumber<AccountNumber.IntegerAccountNumberClassification> repairedAccountNumber
                    = accountNumber.repairAccountNumber(multilineCharacterReader);
            writeOutput.accept(repairedAccountNumber);
            return Optional.of(repairedAccountNumber);
        } catch (UnsupportedOperationException error) {
            writeOutput.accept(accountNumber);
            return Optional.empty();
        }
    }
}
