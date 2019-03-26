package ec.com.jmgorduez.BankOCR.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static ec.com.jmgorduez.BankOCR.dataGenerator.DataTestGenerator.WRONG_BINARY_CODE;
import static ec.com.jmgorduez.BankOCR.utils.Constants.*;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
class UndefinedCharacterTest {

    private UndefinedCharacter undefinedCharacterUnderTest;

    @BeforeAll
    void setUp(){
        undefinedCharacterUnderTest
                = new UndefinedCharacter(WRONG_BINARY_MATRIX);
    }

    @Test
    @DisplayName("It should return the value ?.")
    void getValue() {
        assertThat(undefinedCharacterUnderTest.getValue())
                .isEqualTo(UNDEFINED_CHARACTER_VALUE);
    }

    @Test
    @DisplayName("It should calculate the binary code.")
    void getBinaryCode() {
        assertThat(undefinedCharacterUnderTest.getBinaryCode())
                .isEqualTo(WRONG_BINARY_CODE);
    }

    @Test
    @DisplayName("It should return ? like string value of a undefined char.")
    void getStringValue(){
        assertThat(undefinedCharacterUnderTest.getStringValue())
                .isEqualTo(UNDEFINED_CHARACTER_STRING_VALUE);
    }
}