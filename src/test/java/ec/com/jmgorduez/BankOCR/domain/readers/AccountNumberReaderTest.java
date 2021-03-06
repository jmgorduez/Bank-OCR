package ec.com.jmgorduez.BankOCR.domain.readers;

import ec.com.jmgorduez.BankOCR.domain.DigitToken;
import ec.com.jmgorduez.BankOCR.domain.abstractions.IMultilineStringReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static ec.com.jmgorduez.BankOCR.dataGenerator.DataTestGenerator.*;
import static ec.com.jmgorduez.BankOCR.utils.Constants.ONE;
import static ec.com.jmgorduez.BankOCR.utils.Constants.ZERO;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class AccountNumberReaderTest {

    private AccountNumberReader accountNumberReaderUnderTest;
    @Mock
    private IMultilineStringReader<DigitToken.TokenType> multilineString111111111ReaderMock;
    @Mock
    private IMultilineStringReader<DigitToken.TokenType> multilineString000000000ReaderMock;
    @Mock
    private IMultilineStringReader<DigitToken.TokenType> multilineString49006771_ReaderMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        accountNumberReaderUnderTest = new AccountNumberReader();
        try {
            when(multilineString111111111ReaderMock.readMultilineString(any(), any(), any()))
                    .thenReturn(generateListSameDigits(ONE));
            when(multilineString000000000ReaderMock.readMultilineString(any(), any(), any()))
                    .thenReturn(generateListSameDigits(ZERO));
            when(multilineString49006771_ReaderMock.readMultilineString(any(), any(), any()))
                    .thenReturn(CHARACTERS_ACCOUNT_NUMBER_49006771_);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("It should readMultilineString a account number from a characters list.")
    void readAccountNumber() {
        try {
            assertThat(accountNumberReaderUnderTest
                    .readAccountNumber(any(), any(), any(),
                            multilineString111111111ReaderMock))
                    .isEqualTo(ACCOUNT_NUMBER_111111111);
            assertThat(accountNumberReaderUnderTest
                    .readAccountNumber(any(), any(), any(),
                            multilineString000000000ReaderMock))
                    .isEqualTo(ACCOUNT_NUMBER_000000000);
            assertThat(accountNumberReaderUnderTest
                    .readAccountNumber(any(), any(), any(),
                            multilineString49006771_ReaderMock))
                    .isEqualTo(ACCOUNT_NUMBER_49006771_);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}