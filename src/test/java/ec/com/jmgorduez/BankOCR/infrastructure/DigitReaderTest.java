package ec.com.jmgorduez.BankOCR.infrastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ec.com.jmgorduez.BankOCR.utils.Constants.BINARY_MATRIX_ONE;
import static ec.com.jmgorduez.BankOCR.utils.Constants.BINARY_MATRIX_TWO;
import static ec.com.jmgorduez.BankOCR.DataTestGenerator.*;
import static org.assertj.core.api.Assertions.assertThat;

class DigitReaderTest {

    private DigitReader digitReaderUnderTest;

    @BeforeEach
    void setUp() {
        digitReaderUnderTest = new DigitReader();
    }

    @Test
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
    void toBinaryMatrix() {
        assertThat(digitReaderUnderTest.toBinaryMatrix(generateDigitTokenNumberOneMatrix()))
                .isEqualTo(BINARY_MATRIX_ONE);
        assertThat(digitReaderUnderTest.toBinaryMatrix(generateDigitTokenNumberTwoMatrix()))
                .isNotEqualTo(BINARY_MATRIX_ONE);
        assertThat(digitReaderUnderTest.toBinaryMatrix(generateDigitTokenNumberTwoMatrix()))
                .isEqualTo(BINARY_MATRIX_TWO);
    }
}