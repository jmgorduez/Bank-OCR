package ec.com.jmgorduez.BankOCR.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.BufferedReader;
import java.io.IOException;

import static ec.com.jmgorduez.BankOCR.dataGenerator.DataTestGenerator.*;
import static ec.com.jmgorduez.BankOCR.utils.Constants.MATRIX_WIDTH_27;
import static ec.com.jmgorduez.BankOCR.utils.Constants.ONE;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.*;

class LineReaderTest {

    private LineReader lineReaderUnderTest;
    @Mock
    private BufferedReader bufferedReaderMock;
    @Mock
    private BufferedReader bufferedReaderEmptyLineMock;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.initMocks(this);
        lineReaderUnderTest = new LineReader();
        try {
            when(bufferedReaderMock.readLine())
                    .thenReturn(BLANK_SPACE_STRING_27);
            when(bufferedReaderEmptyLineMock.readLine())
                    .thenReturn(EMPTY_STRING);
        } catch (IOException error) {
        }
    }

    @Test
    @DisplayName("It should take a line and convert it a token list.")
    void readLine() {

        try {
            assertThat(lineReaderUnderTest.readLine(bufferedReaderMock))
                    .isEqualTo(generateListTokensBlankSpace(MATRIX_WIDTH_27));
        } catch (IOException error) {

        }
    }

    @Test
    @DisplayName("It should refill a empty line with blank space characters")
    void generateBlankSpaceCharactersLineLikeRefillOfEmptyLine(){
        assertThat(lineReaderUnderTest.generateBlankSpaceCharactersLineLikeRefillOfEmptyLine())
                .isEqualTo(generateListTokensBlankSpace(MATRIX_WIDTH_27));
    }

    @Test
    @DisplayName("It should pass a empty line.")
    void passEmptyLine(){
        try {
            lineReaderUnderTest.passEmptyLine(bufferedReaderEmptyLineMock);
            verify(bufferedReaderEmptyLineMock, times(ONE)).readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}