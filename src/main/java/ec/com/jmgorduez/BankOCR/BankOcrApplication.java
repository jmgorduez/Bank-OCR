package ec.com.jmgorduez.BankOCR;

import ec.com.jmgorduez.BankOCR.domain.*;
import ec.com.jmgorduez.BankOCR.domain.abstractions.*;
import ec.com.jmgorduez.BankOCR.domain.readers.IntegerAccountNumberReader;
import ec.com.jmgorduez.BankOCR.domain.readers.LineReader;
import ec.com.jmgorduez.BankOCR.domain.readers.MultilineDigitReader;
import ec.com.jmgorduez.BankOCR.domain.readers.MultilineDigitStringReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static ec.com.jmgorduez.BankOCR.utils.Constants.*;

public class BankOcrApplication {

    private static final String FILE_PATH_NAME = FILE_PATH + "input.txt";

    private static IMultilineStringReader multilineStringReader =
            new MultilineDigitStringReader(STRING_LENGTH);
    private static ILineReader<DigitToken.TokenType> lineReader
            = new LineReader();
    private static IMultilineCharacterReader<Integer, DigitToken.TokenType> multilineCharacterReader =
            new MultilineDigitReader();
    private static IAccountNumberReader<DigitToken.TokenType, Integer> accountNumberReader =
            new IntegerAccountNumberReader();

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader =
                    new BufferedReader(new FileReader(FILE_PATH_NAME));
            do {
                IAccountNumber accountNumber = accountNumberReader
                        .readAccountNumber(bufferedReader,
                                lineReader,
                                multilineCharacterReader,
                                multilineStringReader);
                StringBuilder stringBuilder
                        = new StringBuilder(accountNumber.getValue());
                stringBuilder.append(BLANK_SPACE_STRING)
                        .append(((IntegerAccountNumber.IntegerAccountNumberClassification)
                                accountNumber.getAccountNumberClassification()).getValue());
                System.out.println(stringBuilder.toString());
            } while (true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (UnsupportedOperationException e) {
            System.out.println("----------------THE END OF THE FILE-----------------");
        }
    }
}
