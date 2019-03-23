package ec.com.jmgorduez.BankOCR.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static ec.com.jmgorduez.BankOCR.dataGenerator.DataTestGenerator.WRONG_BINARY_CODE;
import static ec.com.jmgorduez.BankOCR.dataGenerator.DataTestGenerator.WRONG_BINARY_MATRIX;
import static ec.com.jmgorduez.BankOCR.utils.Constants.UNDEFINED_CHARACTER_VALUE;
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
    void getValue() {
        assertThat(undefinedCharacterUnderTest.getValue())
                .isEqualTo(UNDEFINED_CHARACTER_VALUE);
    }

    @Test
    void getBinaryCode() {
        assertThat(undefinedCharacterUnderTest.getBinaryCode())
                .isEqualTo(WRONG_BINARY_CODE);
    }
}