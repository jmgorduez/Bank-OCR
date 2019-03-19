package ec.com.jmgorduez.BankOCR.infrastructure;

import ec.com.jmgorduez.BankOCR.domain.Digit;
import ec.com.jmgorduez.BankOCR.domain.DigitToken;
import ec.com.jmgorduez.BankOCR.domain.abstractions.IToken;
import ec.com.jmgorduez.BankOCR.infrastructure.abstractions.IMultilineCharacterReader;
import ec.com.jmgorduez.BankOCR.infrastructure.abstractions.ILineReader;
import ec.com.jmgorduez.BankOCR.infrastructure.abstractions.IMultilineString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.BufferedReader;
import java.io.IOException;

import static ec.com.jmgorduez.BankOCR.utils.Constants.ONE;
import static ec.com.jmgorduez.BankOCR.DataTestGenerator.*;
import static ec.com.jmgorduez.BankOCR.DataTestGenerator.generateListNumbersOne;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class MultilineStringReaderTest {

    private MultilineDigitStringReader<Integer, DigitToken.TokenType> multilineStringReaderUnderTest;
    @Mock
    private IMultilineCharacterReader<Integer, DigitToken.TokenType> characterReaderMock;
    @Mock
    private ILineReader<DigitToken.TokenType> lineReaderMock;
    @Mock
    private IMultilineString<IToken<DigitToken.TokenType>> multilineStringMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        multilineStringReaderUnderTest = new MultilineDigitStringReader<>(STRING_LENGTH);
        try {
            when(lineReaderMock.readLine(any()))
                    .thenReturn(generateLineWithNineDigitTokenBlankSpace());
        } catch (IOException e) {
            e.printStackTrace();
        }
        when(characterReaderMock.readCharacter(any()))
                .thenReturn(new Digit(ONE));
        when(multilineStringMock.getCharacterSection(any()))
                .thenReturn(multilineThatRepresentsDigitOne());
    }

    @Test
    @DisplayName("It should reads a multilines string.")
    void read() {
        try {
            assertThat(multilineStringReaderUnderTest.read(any(), lineReaderMock, characterReaderMock))
                    .isEqualTo(generateListNumbersOne());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("It should generate characters string.")
    void generateCharactersString() {
        assertThat(multilineStringReaderUnderTest.generateCharactersString(
                (MultilineString<IToken<DigitToken.TokenType>>) multilineStringMock, characterReaderMock))
                                        .isEqualTo(generateListNumbersOne());
    }

    @Test
    @DisplayName("It should verify that readLine is called")
    void verifyExecutionRead() {
        try {
            multilineStringReaderUnderTest.read(any(), lineReaderMock, characterReaderMock);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            verify(lineReaderMock, atLeast(MATRIX_HEIGHT_3)).readLine(any());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("It should verify that generateCharactersString is called")
    void verifyExecutionGenerateCharactersString() {
        /*multilineStringReaderUnderTest.generateCharactersString(0)
                generateDigitTokenNumberOneMatrix(), characterReaderMock);*/
        verify(characterReaderMock, atLeast(MATRIX_MODULE)).readCharacter(any());
    }
}