package ec.com.jmgorduez.BankOCR.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.BufferedReader;
import java.io.IOException;

import static ec.com.jmgorduez.BankOCR.dataGenerator.DataTestGenerator.*;
import static ec.com.jmgorduez.BankOCR.domain.DigitToken.TokenType.*;
import static ec.com.jmgorduez.BankOCR.utils.Constants.MATRIX_WIDTH_27;
import static ec.com.jmgorduez.BankOCR.utils.Constants.ONE;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.*;

class LineReaderTest {

    private LineReader lineReaderUnderTest;
    @Mock
    private BufferedReader bufferedReader27BlankSpaceMock;
    @Mock
    private BufferedReader bufferedReader27PipeMock;
    @Mock
    private BufferedReader bufferedReader27UnderScoreMock;
    @Mock
    private BufferedReader bufferedReaderNullLineMock;
    @Mock
    private BufferedReader bufferedReaderEmptyLineMock;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.initMocks(this);
        lineReaderUnderTest = new LineReader();
        try {
            when(bufferedReader27BlankSpaceMock.readLine())
                    .thenReturn(BLANK_SPACE_STRING_27);
            when(bufferedReader27PipeMock.readLine())
                    .thenReturn(PIPE_STRING_27);
            when(bufferedReader27UnderScoreMock.readLine())
                    .thenReturn(UNDER_SCORE_STRING_27);
            when(bufferedReaderEmptyLineMock.readLine())
                    .thenReturn(EMPTY_STRING);
            when(bufferedReaderNullLineMock.readLine())
                    .thenReturn(NULL_STRING);
        } catch (IOException error) {
        }
    }

    @Test
    @DisplayName("It should take a line and convert it a token list.")
    void readLine() {

        try {
            assertThat(lineReaderUnderTest.readLine(bufferedReader27BlankSpaceMock))
                    .isEqualTo(generateListTokens(BLANK_SPACE, MATRIX_WIDTH_27));
            assertThat(lineReaderUnderTest.readLine(bufferedReader27PipeMock))
                    .isEqualTo(generateListTokens(PIPE, MATRIX_WIDTH_27));
            assertThat(lineReaderUnderTest.readLine(bufferedReader27UnderScoreMock))
                    .isEqualTo(generateListTokens(UNDERSCORE, MATRIX_WIDTH_27));
        } catch (IOException error) {

        }
    }

    @Test
    @DisplayName("It should refill a empty line with blank space characters")
    void generateBlankSpaceCharactersLineLikeRefillOfEmptyLine(){
        assertThat(lineReaderUnderTest.generateBlankSpaceCharactersLineLikeRefillOfEmptyLine())
                .isEqualTo(generateListTokens(BLANK_SPACE, MATRIX_WIDTH_27));
    }

    @Test
    @DisplayName("It should verify that bufferedReader.readLine() is called")
    void verifyThatExecutionReadLineCallReadLine(){
        try {
            lineReaderUnderTest.passEmptyLine(bufferedReaderNullLineMock);
            verify(bufferedReaderNullLineMock, times(ONE)).readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("It should verify that UnsupportedOperationException is thrown for a null line")
    void verifyThatExecutionReadLineThrowUnsupportedOperationException() {
        try {
            try {
                lineReaderUnderTest
                        .readLine(bufferedReaderNullLineMock);
            }catch (UnsupportedOperationException error){
                assertThat(error).isInstanceOf(UnsupportedOperationException.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}