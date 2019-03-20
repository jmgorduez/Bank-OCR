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
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class IntegerAccountNumberReaderTest {

    private IntegerAccountNumberReader integerAccountNumberReaderUnderTest;
    @Mock
    private IMultilineStringReader<Integer, DigitToken.TokenType> multilineStringReaderMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        integerAccountNumberReaderUnderTest = new IntegerAccountNumberReader();
        try {
            when(multilineStringReaderMock.read(any(), any(), any()))
                    .thenReturn(generateListSameDigits(ONE));
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
                                        multilineStringReaderMock.read(any(), any(), any())))
                    .isEqualTo(accountNumber111111111());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}