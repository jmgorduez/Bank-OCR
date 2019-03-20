package ec.com.jmgorduez.BankOCR.domain;

import ec.com.jmgorduez.BankOCR.domain.MultilineDigitReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ec.com.jmgorduez.BankOCR.dataGenerator.DataTestGenerator.*;
import static ec.com.jmgorduez.BankOCR.utils.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;

class DigitReaderTest {

    private MultilineDigitReader digitReaderUnderTest;

    @BeforeEach
    void setUp() {
        digitReaderUnderTest = new MultilineDigitReader();
    }

    @Test
    @DisplayName("It should read a digit token from a digit token matrix.")
    void readCharacter() {
        assertThat(digitReaderUnderTest.readCharacter(generateDigitTokenNumberOneMatrix()))
                .isEqualTo(DIGIT_ONE);
        assertThat(digitReaderUnderTest.readCharacter(generateDigitTokenNumberTwoMatrix()))
                .isEqualTo(DIGIT_TWO);
        assertThat(digitReaderUnderTest.readCharacter(generateDigitTokenNumberThreeMatrix()))
                .isEqualTo(DIGIT_THREE);
        assertThat(digitReaderUnderTest.readCharacter(generateDigitTokenNumberFourMatrix()))
                .isEqualTo(DIGIT_FOUR);
        assertThat(digitReaderUnderTest.readCharacter(generateDigitTokenNumberFiveMatrix()))
                .isEqualTo(DIGIT_FIVE);
        assertThat(digitReaderUnderTest.readCharacter(generateDigitTokenNumberSixMatrix()))
                .isEqualTo(DIGIT_SIX);
        assertThat(digitReaderUnderTest.readCharacter(generateDigitTokenNumberSevenMatrix()))
                .isEqualTo(DIGIT_SEVEN);
        assertThat(digitReaderUnderTest.readCharacter(generateDigitTokenNumberEightMatrix()))
                .isEqualTo(DIGIT_EIGHT);
        assertThat(digitReaderUnderTest.readCharacter(generateDigitTokenNumberNineMatrix()))
                .isEqualTo(DIGIT_NINE);
        assertThat(digitReaderUnderTest.readCharacter(generateDigitTokenNumberZeroMatrix()))
                .isEqualTo(DIGIT_ZERO);
    }

    @Test
    @DisplayName("It should convert from a digit token matrix to a binary matrix.")
    void digitTokenMatrixToBinaryMatrix() {
        assertThat(digitReaderUnderTest.digitTokenMatrixToBinaryMatrix(generateDigitTokenNumberOneMatrix()))
                .isEqualTo(BINARY_MATRIX_ONE);
        assertThat(digitReaderUnderTest.digitTokenMatrixToBinaryMatrix(generateDigitTokenNumberTwoMatrix()))
                .isNotEqualTo(BINARY_MATRIX_ONE);
        assertThat(digitReaderUnderTest.digitTokenMatrixToBinaryMatrix(generateDigitTokenNumberTwoMatrix()))
                .isEqualTo(BINARY_MATRIX_TWO);
        assertThat(digitReaderUnderTest.digitTokenMatrixToBinaryMatrix(generateDigitTokenNumberThreeMatrix()))
                .isEqualTo(BINARY_MATRIX_THREE);
        assertThat(digitReaderUnderTest.digitTokenMatrixToBinaryMatrix(generateDigitTokenNumberFourMatrix()))
                .isEqualTo(BINARY_MATRIX_FOUR);
        assertThat(digitReaderUnderTest.digitTokenMatrixToBinaryMatrix(generateDigitTokenNumberFiveMatrix()))
                .isEqualTo(BINARY_MATRIX_FIVE);
        assertThat(digitReaderUnderTest.digitTokenMatrixToBinaryMatrix(generateDigitTokenNumberSixMatrix()))
                .isEqualTo(BINARY_MATRIX_SIX);
        assertThat(digitReaderUnderTest.digitTokenMatrixToBinaryMatrix(generateDigitTokenNumberSevenMatrix()))
                .isEqualTo(BINARY_MATRIX_SEVEN);
        assertThat(digitReaderUnderTest.digitTokenMatrixToBinaryMatrix(generateDigitTokenNumberEightMatrix()))
                .isEqualTo(BINARY_MATRIX_EIGHT);
        assertThat(digitReaderUnderTest.digitTokenMatrixToBinaryMatrix(generateDigitTokenNumberNineMatrix()))
                .isEqualTo(BINARY_MATRIX_NINE);
        assertThat(digitReaderUnderTest.digitTokenMatrixToBinaryMatrix(generateDigitTokenNumberZeroMatrix()))
                .isEqualTo(BINARY_MATRIX_ZERO);
    }
}