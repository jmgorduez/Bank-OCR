package ec.com.jmgorduez.BankOCR;

import ec.com.jmgorduez.BankOCR.domain.*;
import ec.com.jmgorduez.BankOCR.domain.abstractions.*;
import ec.com.jmgorduez.BankOCR.domain.readers.AccountNumberReader;
import ec.com.jmgorduez.BankOCR.domain.readers.LineReader;
import ec.com.jmgorduez.BankOCR.domain.readers.MultilineDigitReader;
import ec.com.jmgorduez.BankOCR.domain.readers.MultilineStringReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Supplier;

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
    private static IAccountNumberFileProcessor accountNumberFileProcessor =
            new AccountNumberFileProcessor();

    public static void main(String[] args) {
        try {
            accountNumberFileProcessor.processFile(
                    new BufferedReader(new FileReader(FILE_PATH_NAME)),
                    lineReader,
                    multilineStringReader,
                    multilineCharacterReader,
                    accountNumberReader,
                    BankOcrApplication::writeOutput);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedOperationException e) {
            System.out.println("----------------THE END OF THE FILE-----------------");
        }
    }

    static void writeOutput(IAccountNumber<AccountNumber.IntegerAccountNumberClassification> accountNumber) {
        StringBuilder stringBuilder = new StringBuilder(accountNumber.getValue());
        stringBuilder.append(BLANK_SPACE_STRING)
                .append(accountNumber.getAccountNumberClassification(multilineCharacterReader).getValue());
        System.out.println(stringBuilder.toString());
    }
}
