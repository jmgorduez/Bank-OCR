package ec.com.jmgorduez.BankOCR.domain;

import ec.com.jmgorduez.BankOCR.domain.abstractions.IToken;
import ec.com.jmgorduez.BankOCR.domain.abstractions.IMultilineCharacterReader;
import ec.com.jmgorduez.BankOCR.domain.abstractions.ILineReader;
import ec.com.jmgorduez.BankOCR.domain.abstractions.IMultilineString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static ec.com.jmgorduez.BankOCR.utils.Constants.ONE;
import static ec.com.jmgorduez.BankOCR.dataGenerator.DataTestGenerator.*;
import static ec.com.jmgorduez.BankOCR.dataGenerator.DataTestGenerator.generateListSameDigits;
import static ec.com.jmgorduez.BankOCR.utils.Constants.STRING_LENGTH;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class MultilineDigitStringReaderTest {

    private MultilineDigitStringReader<Integer, DigitToken.TokenType> multilineDigitStringReaderUnderTest;
    @Mock
    private IMultilineCharacterReader<Integer, DigitToken.TokenType> characterReaderMock;
    @Mock
    private ILineReader<DigitToken.TokenType> lineReaderMock;
    @Mock
    private IMultilineString<IToken<DigitToken.TokenType>> multilineStringMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        multilineDigitStringReaderUnderTest = new MultilineDigitStringReader<>(STRING_LENGTH);
        try {
            when(lineReaderMock.readLine(any()))
                    .thenReturn(generateLineWithTwentySevenBlankSpaceDigitToken());
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
    void readMultilineString() {
        try {
            assertThat(multilineDigitStringReaderUnderTest.readMultilineString(any(), lineReaderMock, characterReaderMock))
                    .isEqualTo(generateListSameDigits(ONE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("It should generate characters string.")
    void generateCharactersString() {
        assertThat(multilineDigitStringReaderUnderTest.generateCharactersString(
                multilineStringMock, characterReaderMock))
                                        .isEqualTo(generateListSameDigits(ONE));
    }

    @Test
    @DisplayName("It should verify that readLine is called")
    void verifyExecutionRead() {
        try {
            multilineDigitStringReaderUnderTest.readMultilineString(any(), lineReaderMock, characterReaderMock);
            verify(lineReaderMock, atLeast(MATRIX_HEIGHT_3)).readLine(any());
            verify(lineReaderMock, times(ONE)).passEmptyLine(any());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("It should verify that generateCharactersString is called")
    void verifyExecutionGenerateCharactersString() {
        multilineDigitStringReaderUnderTest.generateCharactersString(
                multilineStringMock, characterReaderMock);
        verify(characterReaderMock, atLeast(MATRIX_MODULE)).readCharacter(any());
    }
}