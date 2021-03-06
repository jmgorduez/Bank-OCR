package ec.com.jmgorduez.BankOCR.domain.readers;

import ec.com.jmgorduez.BankOCR.domain.Digit;
import ec.com.jmgorduez.BankOCR.domain.DigitToken;
import ec.com.jmgorduez.BankOCR.domain.MultilineString;
import ec.com.jmgorduez.BankOCR.domain.abstractions.ILineReader;
import ec.com.jmgorduez.BankOCR.domain.abstractions.IMultilineCharacterReader;
import ec.com.jmgorduez.BankOCR.domain.abstractions.IMultilineString;
import ec.com.jmgorduez.BankOCR.domain.abstractions.IToken;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static ec.com.jmgorduez.BankOCR.dataGenerator.DataTestGenerator.*;
import static ec.com.jmgorduez.BankOCR.domain.DigitToken.TokenType.BLANK_SPACE;
import static ec.com.jmgorduez.BankOCR.utils.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

class MultilineStringReaderTest {

    private MultilineStringReader< DigitToken.TokenType> multilineStringReaderUnderTest;
    @Mock
    private IMultilineCharacterReader< DigitToken.TokenType> characterReaderMock;
    @Mock
    private IMultilineCharacterReader< DigitToken.TokenType> characterReaderThrowUnsopportedOperationMock;
    @Mock
    private ILineReader<DigitToken.TokenType> lineReaderMock;
    @Mock
    private ILineReader<DigitToken.TokenType> emptyLineReaderMock;
    @Mock
    private IMultilineString<IToken<DigitToken.TokenType>> multilineStringMock;
    @Mock
    private IMultilineString<IToken<DigitToken.TokenType>> multilineStringThrowUnsopportedOperationMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        multilineStringReaderUnderTest = new MultilineStringReader<>(STRING_LENGTH);
        try {
            when(lineReaderMock.readLine(any()))
                    .thenReturn(generateListTokens(BLANK_SPACE, MATRIX_WIDTH_27));
            List<IToken<DigitToken.TokenType>> emptyLine = new ArrayList<>();
            when(emptyLineReaderMock.readLine(any()))
                    .thenReturn(emptyLine);
            when(emptyLineReaderMock.generateBlankSpaceCharactersLineLikeRefillOfEmptyLine())
                    .thenReturn(generateListTokens(BLANK_SPACE,MATRIX_WIDTH_27));
        } catch (IOException e) {
            e.printStackTrace();
        }
        when(characterReaderMock.readCharacter(any(MultilineString.class)))
                .thenReturn(new Digit(ONE));
        when(characterReaderThrowUnsopportedOperationMock.readCharacter(any(IMultilineString.class)))
                .thenThrow(UnsupportedOperationException.class);
        when(multilineStringMock.getCharacterSection(any()))
                .thenReturn(multilineThatRepresentsDigitOne());
        when(multilineStringThrowUnsopportedOperationMock.getCharacterSection(any()))
                .thenThrow(UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("It should reads a multilines string.")
    void readMultilineString() {
        try {
            assertThat(multilineStringReaderUnderTest.readMultilineString(any(), lineReaderMock, characterReaderMock))
                    .isEqualTo(generateListSameDigits(ONE));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThatThrownBy(() -> {
            multilineStringReaderUnderTest.readMultilineString(any(), lineReaderMock,
                    characterReaderThrowUnsopportedOperationMock);
        }).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("It should generate characters string.")
    void generateCharactersString() {
        assertThat(multilineStringReaderUnderTest.generateCharactersString(
                multilineStringMock, characterReaderMock))
                                        .isEqualTo(generateListSameDigits(ONE));
        assertThatThrownBy(() -> {
            multilineStringReaderUnderTest.generateCharactersString(
                    multilineStringThrowUnsopportedOperationMock,
                    characterReaderMock);
        }).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("It should verify that readLine and passEmptyLine are called")
    void verifyExecutionReadMultilineString() {
        try {
            multilineStringReaderUnderTest
                    .readMultilineString(any(), lineReaderMock, characterReaderMock);
            verify(lineReaderMock, atLeast(MATRIX_HEIGHT_3)).readLine(any());
            verify(lineReaderMock, times(ONE)).passEmptyLine(any());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("It should verify that generateBlankSpaceCharactersLineLikeRefillOfEmptyLine is called for a empty line")
    void verifyThatExecutionReadMultilineStringSupportReadEmptyLine() {
        try {
            multilineStringReaderUnderTest
                    .readMultilineString(any(), emptyLineReaderMock, characterReaderMock);
        } catch (IOException e) {
            e.printStackTrace();
        }
        verify(emptyLineReaderMock, atLeast(ONE)).generateBlankSpaceCharactersLineLikeRefillOfEmptyLine();
    }

    @Test
    @DisplayName("It should verify that generateCharactersString is called")
    void verifyExecutionGenerateCharactersString() {
        multilineStringReaderUnderTest
                .generateCharactersString(multilineStringMock, characterReaderMock);
        verify(characterReaderMock, atLeast(MATRIX_MODULE)).readCharacter(any(MultilineString.class));
    }
}