package ec.com.jmgorduez.BankOCR;

import ec.com.jmgorduez.BankOCR.domain.*;
import ec.com.jmgorduez.BankOCR.domain.abstractions.*;
import ec.com.jmgorduez.BankOCR.domain.readers.IntegerAccountNumberReader;
import ec.com.jmgorduez.BankOCR.domain.readers.LineReader;
import ec.com.jmgorduez.BankOCR.domain.readers.MultilineDigitReader;
import ec.com.jmgorduez.BankOCR.domain.readers.MultilineDigitStringReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static ec.com.jmgorduez.BankOCR.dataGenerator.DataTestGenerator.*;
import static ec.com.jmgorduez.BankOCR.utils.Constants.*;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class BankOcrApplicationTests {

    //private static final String FILE_PATH = "C:\\Users\\JuanMa\\projects\\java\\Bank-OCR\\inputFiles\\input.txt";
    private static final String FILE_PATH_111111111 = "/home/jm/projects/java/Bank-OCR/inputFiles/input111111111.txt";
    private static final String FILE_PATH_123456789 = "/home/jm/projects/java/Bank-OCR/inputFiles/input123456789.txt";
    private static final String FILE_PATH_49006771_ = "/home/jm/projects/java/Bank-OCR/inputFiles/input49006771_.txt";
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
            assertThat(readAccountNumber(FILE_PATH_111111111).getValue())
                    .isEqualTo(STRING_ACCOUNT_NUMBER_111111111);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("It should read 123456789")
    void readAccountNumber123456789() {
        try {
            assertThat(readAccountNumber(FILE_PATH_123456789).getValue())
                    .isEqualTo(STRING_ACCOUNT_NUMBER_123456789);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("It should read 49006771?")
    void readAccountNumber49006771_() {
        try {
            assertThat(readAccountNumber(FILE_PATH_49006771_).getValue())
                    .isEqualTo(STRING_ACCOUNT_NUMBER_49006771_);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private IAccountNumber readAccountNumber(String filePath) throws IOException {

        BufferedReader bufferedReader =
                new BufferedReader(new FileReader(filePath));

        return accountNumberReader
                .readAccountNumber(bufferedReader,
                        lineReader,
                        multilineCharacterReader,
                        multilineStringReader);

    }

    @Test
    @DisplayName("It should verify check sum of 1111111111")
    void verifyCheckSumAccountNumber111111111() {
        try {
            assertThat(readAccountNumber(FILE_PATH_111111111).calculateCheckSum())
                    .isEqualTo(CHECK_SUM_111111111);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("It should verify check sum of 123456789")
    void verifyCheckSumAccountNumber123456789() {
        try {
            assertThat(readAccountNumber(FILE_PATH_123456789).calculateCheckSum())
                    .isEqualTo(CHECK_SUM_123456789);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("It should classify a account number in ILL o ERR.")
    void classifyAccountNumber(){
        IAccountNumber accountNumber = new IntegerAccountNumber(STRING_ACCOUNT_NUMBER_49006771_,
                CHARACTERS_ACCOUNT_NUMBER_49006771_);
        StringBuilder stringBuilder = classifyAccountNumber(accountNumber);
        assertThat(BankOcrApplication.classifyAccountNumber(accountNumber))
                .isEqualTo(stringBuilder.toString());
        accountNumber = new IntegerAccountNumber(STRING_ACCOUNT_NUMBER_111111111,
                CHARACTERS_ACCOUNT_NUMBER_111111111);
        stringBuilder = classifyAccountNumber(accountNumber);
        assertThat(BankOcrApplication.classifyAccountNumber(accountNumber))
                .isEqualTo(stringBuilder.toString());
        accountNumber = new IntegerAccountNumber(STRING_ACCOUNT_NUMBER_123456789,
                CHARACTERS_ACCOUNT_NUMBER_123456789);
        stringBuilder = classifyAccountNumber(accountNumber);
        assertThat(BankOcrApplication.classifyAccountNumber(accountNumber))
                .isEqualTo(stringBuilder.toString());
    }

    private StringBuilder classifyAccountNumber(IAccountNumber accountNumber){
        StringBuilder stringBuilder
                = new StringBuilder(accountNumber.getValue());
        stringBuilder.append(BLANK_SPACE_STRING);
        if (accountNumber.isIllegibleAccountNumber()){
            stringBuilder.append(STRING_ILL);
        } else if(!accountNumber.isRightAccountNumber()){
            stringBuilder.append(STRING_ERR);
        }
        return stringBuilder;
    }

}
