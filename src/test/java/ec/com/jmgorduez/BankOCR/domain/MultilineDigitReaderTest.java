package ec.com.jmgorduez.BankOCR.domain;

import ec.com.jmgorduez.BankOCR.domain.MultilineDigitReader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static ec.com.jmgorduez.BankOCR.dataGenerator.DataTestGenerator.*;
import static ec.com.jmgorduez.BankOCR.utils.Constants.*;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
class MultilineDigitReaderTest {

    private MultilineDigitReader multilineDigitReaderUnderTest;

    @BeforeAll
    void setUp(){
        multilineDigitReaderUnderTest = new MultilineDigitReader();
    }

    @Test
    @DisplayName("It should read a character from a section of a multiline string")
    void readCharacter() {
        assertThat(multilineDigitReaderUnderTest.readCharacter(
                generateDigitTokenNumberOneMatrix()))
                .isEqualTo(DIGIT_ONE);
    }

    @Test
    @DisplayName("It should convert a matrix of digit tokens to a binary matrix.")
    void digitTokenMatrixToBinaryMatrix() {
        assertThat(multilineDigitReaderUnderTest.digitTokenMatrixToBinaryMatrix(
                generateDigitTokenNumberFiveMatrix()))
                .isEqualTo(BINARY_MATRIX_FIVE);
        assertThat(multilineDigitReaderUnderTest.digitTokenMatrixToBinaryMatrix(
                generateDigitTokenNumberSixMatrix()))
                .isEqualTo(BINARY_MATRIX_SIX);
        assertThat(multilineDigitReaderUnderTest.digitTokenMatrixToBinaryMatrix(
                generateDigitTokenNumberNineMatrix()))
        .isEqualTo(BINARY_MATRIX_NINE);

    }
}