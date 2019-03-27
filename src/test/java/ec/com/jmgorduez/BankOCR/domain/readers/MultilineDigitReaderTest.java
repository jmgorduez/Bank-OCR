package ec.com.jmgorduez.BankOCR.domain.readers;

import ec.com.jmgorduez.BankOCR.domain.UndefinedDigit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ec.com.jmgorduez.BankOCR.dataGenerator.DataTestGenerator.*;
import static ec.com.jmgorduez.BankOCR.utils.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MultilineDigitReaderTest {

    private MultilineDigitReader multilineDigitReaderUnderTest;

    @BeforeEach
    void setUp() {
        multilineDigitReaderUnderTest = new MultilineDigitReader();
    }

    @Test
    @DisplayName("It should readMultilineString a digit token from a digit token matrix.")
    void readCharacterFromDigitTokenMatrix() {
        assertThat(multilineDigitReaderUnderTest.readCharacter(generateDigitTokenNumberOneMatrix()))
                .isEqualTo(DIGIT_ONE);
        assertThat(multilineDigitReaderUnderTest.readCharacter(generateDigitTokenNumberTwoMatrix()))
                .isEqualTo(DIGIT_TWO);
        assertThat(multilineDigitReaderUnderTest.readCharacter(generateDigitTokenNumberThreeMatrix()))
                .isEqualTo(DIGIT_THREE);
        assertThat(multilineDigitReaderUnderTest.readCharacter(generateDigitTokenNumberFourMatrix()))
                .isEqualTo(DIGIT_FOUR);
        assertThat(multilineDigitReaderUnderTest.readCharacter(generateDigitTokenNumberFiveMatrix()))
                .isEqualTo(DIGIT_FIVE);
        assertThat(multilineDigitReaderUnderTest.readCharacter(generateDigitTokenNumberSixMatrix()))
                .isEqualTo(DIGIT_SIX);
        assertThat(multilineDigitReaderUnderTest.readCharacter(generateDigitTokenNumberSevenMatrix()))
                .isEqualTo(DIGIT_SEVEN);
        assertThat(multilineDigitReaderUnderTest.readCharacter(generateDigitTokenNumberEightMatrix()))
                .isEqualTo(DIGIT_EIGHT);
        assertThat(multilineDigitReaderUnderTest.readCharacter(generateDigitTokenNumberNineMatrix()))
                .isEqualTo(DIGIT_NINE);
        assertThat(multilineDigitReaderUnderTest.readCharacter(generateDigitTokenNumberZeroMatrix()))
                .isEqualTo(DIGIT_ZERO);
    }

    @Test
    @DisplayName("It should convert from a digit token matrix to a binary matrix.")
    void digitTokenMatrixToBinaryMatrix() {
        assertThat(multilineDigitReaderUnderTest.digitTokenMatrixToBinaryMatrix(generateDigitTokenNumberOneMatrix()))
                .isEqualTo(BINARY_MATRIX_ONE);
        assertThat(multilineDigitReaderUnderTest.digitTokenMatrixToBinaryMatrix(generateDigitTokenNumberTwoMatrix()))
                .isNotEqualTo(BINARY_MATRIX_ONE);
        assertThat(multilineDigitReaderUnderTest.digitTokenMatrixToBinaryMatrix(generateDigitTokenNumberTwoMatrix()))
                .isEqualTo(BINARY_MATRIX_TWO);
        assertThat(multilineDigitReaderUnderTest.digitTokenMatrixToBinaryMatrix(generateDigitTokenNumberThreeMatrix()))
                .isEqualTo(BINARY_MATRIX_THREE);
        assertThat(multilineDigitReaderUnderTest.digitTokenMatrixToBinaryMatrix(generateDigitTokenNumberFourMatrix()))
                .isEqualTo(BINARY_MATRIX_FOUR);
        assertThat(multilineDigitReaderUnderTest.digitTokenMatrixToBinaryMatrix(generateDigitTokenNumberFiveMatrix()))
                .isEqualTo(BINARY_MATRIX_FIVE);
        assertThat(multilineDigitReaderUnderTest.digitTokenMatrixToBinaryMatrix(generateDigitTokenNumberSixMatrix()))
                .isEqualTo(BINARY_MATRIX_SIX);
        assertThat(multilineDigitReaderUnderTest.digitTokenMatrixToBinaryMatrix(generateDigitTokenNumberSevenMatrix()))
                .isEqualTo(BINARY_MATRIX_SEVEN);
        assertThat(multilineDigitReaderUnderTest.digitTokenMatrixToBinaryMatrix(generateDigitTokenNumberEightMatrix()))
                .isEqualTo(BINARY_MATRIX_EIGHT);
        assertThat(multilineDigitReaderUnderTest.digitTokenMatrixToBinaryMatrix(generateDigitTokenNumberNineMatrix()))
                .isEqualTo(BINARY_MATRIX_NINE);
        assertThat(multilineDigitReaderUnderTest.digitTokenMatrixToBinaryMatrix(generateDigitTokenNumberZeroMatrix()))
                .isEqualTo(BINARY_MATRIX_ZERO);
    }

    @Test
    @DisplayName("It should return a digit instance from a binary matrix.")
    void readCharacterFromBinaryMatrix() {
        assertThat(multilineDigitReaderUnderTest.readCharacter(BINARY_MATRIX_ONE))
                .isEqualTo(DIGIT_ONE);
        assertThat(multilineDigitReaderUnderTest.readCharacter(BINARY_MATRIX_TWO))
                .isEqualTo(DIGIT_TWO);
        assertThat(multilineDigitReaderUnderTest.readCharacter(BINARY_MATRIX_THREE))
                .isEqualTo(DIGIT_THREE);
        assertThat(multilineDigitReaderUnderTest.readCharacter(BINARY_MATRIX_FOUR))
                .isEqualTo(DIGIT_FOUR);
        assertThat(multilineDigitReaderUnderTest.readCharacter(BINARY_MATRIX_FIVE))
                .isEqualTo(DIGIT_FIVE);
        assertThat(multilineDigitReaderUnderTest.readCharacter(BINARY_MATRIX_SIX))
                .isEqualTo(DIGIT_SIX);
        assertThat(multilineDigitReaderUnderTest.readCharacter(BINARY_MATRIX_SEVEN))
                .isEqualTo(DIGIT_SEVEN);
        assertThat(multilineDigitReaderUnderTest.readCharacter(BINARY_MATRIX_EIGHT))
                .isEqualTo(DIGIT_EIGHT);
        assertThat(multilineDigitReaderUnderTest.readCharacter(BINARY_MATRIX_NINE))
                .isEqualTo(DIGIT_NINE);
        assertThat(multilineDigitReaderUnderTest.readCharacter(BINARY_MATRIX_ZERO))
                .isEqualTo(DIGIT_ZERO);
        assertThat(multilineDigitReaderUnderTest.readCharacter(WRONG_BINARY_MATRIX))
                .isInstanceOf(UndefinedDigit.class);
    }
}