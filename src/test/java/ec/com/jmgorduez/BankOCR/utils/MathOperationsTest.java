package ec.com.jmgorduez.BankOCR.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ec.com.jmgorduez.BankOCR.dataGenerator.DataTestGenerator.*;
import static ec.com.jmgorduez.BankOCR.utils.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;

class MathOperationsTest {

    @Test
    @DisplayName("It should convert int[] that represent a binary number to a decimal number")
    void binaryToDecimal() {
        assertThat(MathOperations.bitsArrayToNumberBaseTen(ONE_BASE_TWO_ARRAY))
                .isEqualTo(ONE);
        assertThat(MathOperations.bitsArrayToNumberBaseTen(THREE_BASE_TWO_ARRAY))
                .isEqualTo(THREE);
        assertThat(MathOperations.bitsArrayToNumberBaseTen(FIVE_BASE_TWO_ARRAY))
                .isEqualTo(FIVE);
        assertThat(MathOperations.bitsArrayToNumberBaseTen(ONE_BASE_TWO_ARRAY))
                .isNotEqualTo(TWO);
    }

    @Test
    @DisplayName("It should convert int[] that represent a decimal number to a decimal number")
    void intArrayToDecimal(){
        assertThat(MathOperations.digitsArrayToNumberBaseTen(BINARY_CODE_ONE_ARRAY))
                .isEqualTo(BINARY_CODE_ONE);
    }
}