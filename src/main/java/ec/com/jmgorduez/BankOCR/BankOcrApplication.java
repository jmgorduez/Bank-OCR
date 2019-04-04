package ec.com.jmgorduez.BankOCR;

import ec.com.jmgorduez.BankOCR.domain.AccountNumber;
import ec.com.jmgorduez.BankOCR.domain.AccountNumberFileProcessor;
import ec.com.jmgorduez.BankOCR.domain.DigitToken;
import ec.com.jmgorduez.BankOCR.domain.abstractions.*;
import ec.com.jmgorduez.BankOCR.domain.readers.AccountNumberReader;
import ec.com.jmgorduez.BankOCR.domain.readers.LineReader;
import ec.com.jmgorduez.BankOCR.domain.readers.MultilineDigitReader;
import ec.com.jmgorduez.BankOCR.domain.readers.MultilineStringReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static ec.com.jmgorduez.BankOCR.utils.Constants.*;

public class BankOcrApplication {

    private static final String FILE_PATH_NAME = FILE_PATH + "input.txt";

    private static IMultilineStringReader multilineStringReader =
            new MultilineStringReader(STRING_LENGTH);
    private static ILineReader<DigitToken.TokenType> lineReader
            = new LineReader();
    private static IMultilineCharacterReader<DigitToken.TokenType> multilineCharacterReader =
            new MultilineDigitReader();
    private static IAccountNumberReader<DigitToken.TokenType> accountNumberReader =
            new AccountNumberReader();
    private static IAccountNumberFileProcessor<DigitToken.TokenType, AccountNumber.IntegerAccountNumberClassification> accountNumberFileProcessor =
            new AccountNumberFileProcessor();

    public static void main(String[] args) {
        try {
            List<IAccountNumber<AccountNumber.IntegerAccountNumberClassification>> accountNumbersRead =
                    processFile();
            writeSeparator();
            repairAccountNumbers(accountNumbersRead);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (StringIndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }

    static void repairAccountNumbers(List<IAccountNumber<AccountNumber.IntegerAccountNumberClassification>> accountNumbersToRepair) throws IOException {
        accountNumberFileProcessor.repairAccountNumbers(accountNumbersToRepair,
                multilineCharacterReader,
                BankOcrApplication::writeOutput);
    }

    static void writeSeparator() {
        System.out.println("-------------------------------------------------------------");
    }

    static List<IAccountNumber<AccountNumber.IntegerAccountNumberClassification>> processFile()
            throws IOException, StringIndexOutOfBoundsException {
        return accountNumberFileProcessor.processFile(
                new BufferedReader(new FileReader(FILE_PATH_NAME)),
                lineReader,
                multilineStringReader,
                multilineCharacterReader,
                accountNumberReader,
                BankOcrApplication::writeOutput);
    }

    static void writeOutput(IAccountNumber<AccountNumber.IntegerAccountNumberClassification> accountNumber) {
        StringBuilder stringBuilder = new StringBuilder(accountNumber.getValue());
        stringBuilder.append(BLANK_SPACE_STRING)
                .append(accountNumber.getAccountNumberClassification(multilineCharacterReader).getValue());
        System.out.println(stringBuilder.toString());
    }
}
