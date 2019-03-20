package ec.com.jmgorduez.BankOCR.infrastructure;

import ec.com.jmgorduez.BankOCR.dataGenerator.DataTestGenerator;
import ec.com.jmgorduez.BankOCR.domain.LineReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.BufferedReader;
import java.io.IOException;

import static ec.com.jmgorduez.BankOCR.dataGenerator.DataTestGenerator.BLANK_SPACE_STRING_27;
import static ec.com.jmgorduez.BankOCR.dataGenerator.DataTestGenerator.generateListTokensBlankSpace;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;

class LineReaderTest {

    private LineReader lineConsoleReaderUnderTest;
    @Mock
    private BufferedReader bufferedReaderMock;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.initMocks(this);
        lineConsoleReaderUnderTest = new LineReader();
        try {
            when(bufferedReaderMock.readLine())
                    .thenReturn(BLANK_SPACE_STRING_27);
        } catch (IOException error) {
        }
    }

    @Test
    @DisplayName("It should take a line and convert it a token list.")
    void readLine() {

        try {
            assertThat(lineConsoleReaderUnderTest.readLine(bufferedReaderMock))
                    .isEqualTo(generateListTokensBlankSpace(DataTestGenerator.MATRIX_WIDTH_27));
        } catch (IOException error) {

        }
    }
}