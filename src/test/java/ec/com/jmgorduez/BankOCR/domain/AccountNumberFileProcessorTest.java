package ec.com.jmgorduez.BankOCR.domain;

import ec.com.jmgorduez.BankOCR.domain.abstractions.IAccountNumber;
import ec.com.jmgorduez.BankOCR.domain.readers.AccountNumberReader;
import ec.com.jmgorduez.BankOCR.domain.readers.LineReader;
import ec.com.jmgorduez.BankOCR.domain.readers.MultilineDigitReader;
import ec.com.jmgorduez.BankOCR.domain.readers.MultilineStringReader;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

import static ec.com.jmgorduez.BankOCR.dataGenerator.DataTestGenerator.*;
import static ec.com.jmgorduez.BankOCR.dataGenerator.DataTestGenerator.accountNumberReader;
import static ec.com.jmgorduez.BankOCR.utils.Constants.BLANK_SPACE_STRING;
import static ec.com.jmgorduez.BankOCR.utils.Constants.STRING_LENGTH;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class AccountNumberFileProcessorTest {

    private AccountNumberFileProcessor accountNumberFileProcessorUnderTest;

    @BeforeEach
    void setUp() {
        accountNumberFileProcessorUnderTest = new AccountNumberFileProcessor();
        multilineStringReader = new MultilineStringReader(STRING_LENGTH);
        lineReader = new LineReader();
        multilineCharacterReader = new MultilineDigitReader();
        accountNumberReader = new AccountNumberReader();
    }

    @Test
    @DisplayName("It should return a list of account numbers read.")
    void processFile() {
        try {
            List<IAccountNumber<AccountNumber.IntegerAccountNumberClassification>> accountNumbers
                    = accountNumberFileProcessorUnderTest
                    .processFile(new BufferedReader(new FileReader(FILE_PATH_MAIN)),
                            lineReader,
                            multilineStringReader,
                            multilineCharacterReader,
                            accountNumberReader,
                            this::writeOutput);
            assertThat(accountNumbers.contains(ACCOUNT_NUMBER_111111111))
                    .isTrue();
            assertThat(accountNumbers.contains(ACCOUNT_NUMBER_123456789))
                    .isTrue();
            assertThat(accountNumbers.contains(ACCOUNT_NUMBER_49006771_))
                    .isTrue();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("It should return a list of account numbers repaired")
    void repairAccountNumbers() {
        List<IAccountNumber<AccountNumber.IntegerAccountNumberClassification>> accountNumbers
                = accountNumberFileProcessorUnderTest
                .repairAccountNumbers(generateWrongAccountNumber49006771_(),
                        multilineCharacterReader,
                        this::writeOutput);
        assertThat(accountNumbers.contains(ACCOUNT_NUMBER_490067719))
                .isTrue();
        assertThat(accountNumbers.contains(ACCOUNT_NUMBER_49006771_))
                .isFalse();
    }

    void writeOutput(IAccountNumber<AccountNumber.IntegerAccountNumberClassification> accountNumber) {

    }
}