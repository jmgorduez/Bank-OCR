package ec.com.jmgorduez.BankOCR.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Objects;

import static ec.com.jmgorduez.BankOCR.dataGenerator.DataTestGenerator.*;
import static ec.com.jmgorduez.BankOCR.utils.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
class DigitTest {

    private Digit digitUnderTest;

    @BeforeAll
    void setUp() {
        digitUnderTest = new Digit(ONE);
    }

    @Test
    @DisplayName("It should return the Integer that represent the digit value")
    void getValue() {
        digitUnderTest = DIGIT_ONE;
        assertThat(digitUnderTest.getValue()).isEqualTo(ONE);
    }

    @Test
    @DisplayName("It should tell if the digit value is equal to other one")
    void equals() {
        digitUnderTest = DIGIT_ONE;
        assertThat(digitUnderTest.equals(new Digit(ONE)))
                .isTrue();
        assertThat(digitUnderTest.equals(this))
                .isFalse();
        assertThat(digitUnderTest.equals(digitUnderTest))
                .isTrue();
    }

    @Test
    @DisplayName("It should return the digit hash code")
    void hashCodeTest() {
        digitUnderTest = DIGIT_ONE;
        assertThat(digitUnderTest.hashCode()).isEqualTo(Objects.hashCode(ONE));
    }

    @Test
    @DisplayName("It should calculate the binary code for a digit.")
    void getBinaryCode() {
        digitUnderTest = DIGIT_ONE;
        assertThat(digitUnderTest.getBinaryCode()).isEqualTo(BINARY_CODE_ONE);
        digitUnderTest = DIGIT_THREE;
        assertThat(digitUnderTest.getBinaryCode()).isEqualTo(BINARY_CODE_THREE);
    }

    @Test
    @DisplayName("It should generate a binary matrix for each digit")
    void generateBinaryMatrixForDigit() {
        digitUnderTest = DIGIT_FIVE;
        assertThat(digitUnderTest.generateBinaryMatricesForDigits().get(FIVE))
                .isEqualTo(BINARY_MATRIX_FIVE);
        digitUnderTest = DIGIT_ZERO;
        assertThat(digitUnderTest.generateBinaryMatricesForDigits().get(ZERO))
                .isEqualTo(BINARY_MATRIX_ZERO);
    }

    @Test
    @DisplayName("It should generate a binary code from a binary matrix.")
    void binaryMatrixToBinaryCode() {
        assertThat(digitUnderTest.binaryMatrixToBinaryCode(BINARY_MATRIX_ONE))
                .isEqualTo(BINARY_CODE_ONE);
        assertThat(digitUnderTest.binaryMatrixToBinaryCode(BINARY_MATRIX_THREE))
                .isEqualTo(BINARY_CODE_THREE);
    }

    @Test
    @DisplayName("It should instantiate a digit from its binary code.")
    void binaryCodeToDigit() {
        assertThat(digitUnderTest.binaryCodeToDigit(BINARY_CODE_ONE))
                .isEqualTo(DIGIT_ONE);
        assertThat(digitUnderTest.binaryCodeToDigit(BINARY_CODE_TWO))
                .isEqualTo(DIGIT_TWO);
        assertThat(digitUnderTest.binaryCodeToDigit(BINARY_CODE_THREE))
                .isEqualTo(DIGIT_THREE);
        assertThat(digitUnderTest.binaryCodeToDigit(BINARY_CODE_FOUR))
                .isEqualTo(DIGIT_FOUR);
        assertThat(digitUnderTest.binaryCodeToDigit(BINARY_CODE_FIVE))
                .isEqualTo(DIGIT_FIVE);
        assertThat(digitUnderTest.binaryCodeToDigit(BINARY_CODE_SIX))
                .isEqualTo(DIGIT_SIX);
        assertThat(digitUnderTest.binaryCodeToDigit(BINARY_CODE_SEVEN))
                .isEqualTo(DIGIT_SEVEN);
        assertThat(digitUnderTest.binaryCodeToDigit(BINARY_CODE_EIGHT))
                .isEqualTo(DIGIT_EIGHT);
        assertThat(digitUnderTest.binaryCodeToDigit(BINARY_CODE_NINE))
                .isEqualTo(DIGIT_NINE);
        assertThat(digitUnderTest.binaryCodeToDigit(BINARY_CODE_ZERO))
                .isEqualTo(DIGIT_ZERO);
    }

    @Test
    @DisplayName("It should generate a binary code for each digit")
    void generateBinaryCodesForDigits() {
        assertThat(digitUnderTest.generateBinaryCodesForDigits().get(ONE))
                .isEqualTo(BINARY_CODE_ONE);
        assertThat(digitUnderTest.generateBinaryCodesForDigits().get(THREE))
                .isEqualTo(BINARY_CODE_THREE);
        assertThat(digitUnderTest.generateBinaryCodesForDigits().get(ZERO))
                .isEqualTo(BINARY_CODE_ZERO);
    }

    @Test
    @DisplayName("It should calculate the digit successor.")
    void successor() {
        digitUnderTest = DIGIT_ZERO;
        assertThat(digitUnderTest.successor())
                .isEqualTo(DIGIT_ONE);
        digitUnderTest = DIGIT_THREE;
        assertThat(digitUnderTest.successor())
                .isEqualTo(DIGIT_FOUR);
        assertThatThrownBy(() -> {
            digitUnderTest = DIGIT_NINE;
            digitUnderTest.successor();
        }).isInstanceOf(UnsupportedOperationException.class);
    }
}