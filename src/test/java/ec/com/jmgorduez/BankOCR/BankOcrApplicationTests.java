package ec.com.jmgorduez.BankOCR;

import ec.com.jmgorduez.BankOCR.domain.*;
import ec.com.jmgorduez.BankOCR.domain.abstractions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static ec.com.jmgorduez.BankOCR.dataGenerator.DataTestGenerator.STRING_ACCOUNT_NUMBER_111111111;
import static ec.com.jmgorduez.BankOCR.dataGenerator.DataTestGenerator.STRING_ACCOUNT_NUMBER_123456789;
import static ec.com.jmgorduez.BankOCR.utils.Constants.STRING_LENGTH;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class BankOcrApplicationTests {

    //private static final String FILE_PATH = "C:\\Users\\JuanMa\\projects\\java\\Bank-OCR\\inputFiles\\input.txt";
    private static final String FILE_PATH_111111111 = "/home/jm/projects/java/Bank-OCR/inputFiles/input111111111.txt";
    private static final String FILE_PATH_123456789 = "/home/jm/projects/java/Bank-OCR/inputFiles/input123456789.txt";
    private IMultilineStringReader multilineStringReader;
    private ILineReader<DigitToken.TokenType> lineReader;
    private IMultilineCharacterReader<Integer, DigitToken.TokenType> multilineCharacterReader;
    private IAccountNumberReader<DigitToken.TokenType, Integer> accountNumberReader;

    @BeforeEach
    void setUp() {
        multilineStringReader = new MultilineDigitStringReader(STRING_LENGTH);
        lineReader = new LineReader();
        multilineCharacterReader = new MultilineDigitReader();
        accountNumberReader = new IntegerAccountNumberReader();
    }

    @Test
    @DisplayName("It should read 1111111111")
    void readAccountNumber111111111() {
        try {
            assertThat(readAccountNumber(FILE_PATH_111111111))
                    .isEqualTo(STRING_ACCOUNT_NUMBER_111111111);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("It should read 123456789")
    void readAccountNumber123456789() {
        try {
            assertThat(readAccountNumber(FILE_PATH_123456789))
                    .isEqualTo(STRING_ACCOUNT_NUMBER_123456789);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readAccountNumber(String filePath) throws IOException {

        BufferedReader bufferedReader =
                new BufferedReader(new FileReader(filePath));

        IAccountNumber accountNumber = accountNumberReader
                .readAccountNumber(bufferedReader,
                        lineReader,
                        multilineCharacterReader,
                        multilineStringReader);
        return accountNumber.getValue();

    }

}
