package ec.com.jmgorduez.BankOCR.domain;

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

class IntegerAccountNumberReaderTest {

    private IntegerAccountNumberReader integerAccountNumberReaderUnderTest;
    @Mock
    private IMultilineStringReader<Integer, DigitToken.TokenType> multilineString111111111ReaderMock;
    @Mock
    private IMultilineStringReader<Integer, DigitToken.TokenType> multilineString000000000ReaderMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        integerAccountNumberReaderUnderTest = new IntegerAccountNumberReader();
        try {
            when(multilineString111111111ReaderMock.read(any(), any(), any()))
                    .thenReturn(generateListSameDigits(ONE));
            when(multilineString000000000ReaderMock.read(any(), any(), any()))
                    .thenReturn(generateListSameDigits(ZERO));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("It should read a account number from a characters list.")
    void readAccountNumber() {
        try {
            assertThat(integerAccountNumberReaderUnderTest
                    .readAccountNumber(
                            multilineString111111111ReaderMock.read(any(), any(), any())))
                    .isEqualTo(ACCOUNT_NUMBER_111111111);
            assertThat(integerAccountNumberReaderUnderTest
                    .readAccountNumber(
                            multilineString000000000ReaderMock.read(any(), any(), any())))
                    .isEqualTo(ACCOUNT_NUMBER_000000000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}