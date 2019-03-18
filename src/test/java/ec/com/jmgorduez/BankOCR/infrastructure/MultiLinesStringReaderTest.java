package ec.com.jmgorduez.BankOCR.infrastructure;

import ec.com.jmgorduez.BankOCR.domain.Digit;
import ec.com.jmgorduez.BankOCR.domain.DigitToken;
import ec.com.jmgorduez.BankOCR.infrastructure.abstractions.ICharacterReader;
import ec.com.jmgorduez.BankOCR.infrastructure.abstractions.ILineReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static ec.com.jmgorduez.BankOCR.utils.Constants.ONE;
import static ec.com.jmgorduez.BankOCR.DataTestGenerator.*;
import static ec.com.jmgorduez.BankOCR.DataTestGenerator.generateListNumbersOne;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class MultiLinesStringReaderTest {

    private MultiLinesStringReader<Integer, DigitToken.TokenType> multiLinesStringReaderUnderTest;
    @Mock
    private ICharacterReader<Integer, DigitToken.TokenType> characterReaderMock;
    @Mock
    private ILineReader<DigitToken.TokenType> lineReaderMock;
    private DigitToken[][] digitTokenMatrix;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        multiLinesStringReaderUnderTest = new MultiLinesStringReader<>(STRING_LENGTH);
        when(lineReaderMock.readLine())
                .thenReturn(generateDigitTokenBlankSpaceArray());
        digitTokenMatrix = generateDigitTokenNumberOneMatrix();
        when(characterReaderMock.readCharacter(any()))
                .thenReturn(new Digit(ONE));
    }

    @Test
    @DisplayName("It should reads a multilines string.")
    void read() {
        assertThat(multiLinesStringReaderUnderTest.read(lineReaderMock, characterReaderMock))
                .isEqualTo(generateListNumbersOne());
    }

    @Test
    @DisplayName("It should generate characters string.")
    void generateCharactersString() {
        assertThat(multiLinesStringReaderUnderTest.generateCharactersString(
                                          generateDigitTokenNumberOneStringMatrix(MATRIX_WIDTH_27, MATRIX_HEIGHT_3), characterReaderMock))
                                        .isEqualTo(generateListNumbersOne());
    }

    @Test
    @DisplayName("It should verify that readLine is called")
    void verifyExecutionRead() {
        multiLinesStringReaderUnderTest.read(lineReaderMock, characterReaderMock);
        verify(lineReaderMock, atLeast(MATRIX_HEIGHT_3)).readLine();
    }

    @Test
    @DisplayName("It should verify that generateCharactersString is called")
    void verifyExecutionGenerateCharactersString() {
        multiLinesStringReaderUnderTest.generateCharactersString(
                generateDigitTokenNumberOneMatrix(), characterReaderMock);
        verify(characterReaderMock, atLeast(MATRIX_MODULE)).readCharacter(any());
    }
}