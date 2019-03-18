package ec.com.jmgorduez.BankOCR.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ec.com.jmgorduez.BankOCR.DataTestGenerator.*;
import static ec.com.jmgorduez.BankOCR.utils.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class MathOperationsTest {

    @Test
    @DisplayName("It should convert int[] that represent a binary number to a decimal number")
    void binaryToDecimal() {
        assertThat(MathOperations.binaryToDecimal(ONE_BASE_TWO_ARRAY))
                .isEqualTo(ONE);
        assertThat(MathOperations.binaryToDecimal(THREE_BASE_TWO_ARRAY))
                .isEqualTo(THREE);
        assertThat(MathOperations.binaryToDecimal(FIVE_BASE_TWO_ARRAY))
                .isEqualTo(FIVE);
        assertThat(MathOperations.binaryToDecimal(ONE_BASE_TWO_ARRAY))
                .isNotEqualTo(TWO);
    }

    @Test
    @DisplayName("It should convert int[] that represent a decimal number to a decimal number")
    void intArrayToDecimal(){
        assertThat(MathOperations.intArrayToDecimal(BINARY_CODE_ONE_ARRAY))
                .isEqualTo(BINARY_CODE_ONE);
    }
}