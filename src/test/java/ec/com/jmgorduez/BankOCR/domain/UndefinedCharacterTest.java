package ec.com.jmgorduez.BankOCR.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static ec.com.jmgorduez.BankOCR.dataGenerator.DataTestGenerator.BINARY_MATRIX_UNDEFINED_CHARACTER;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
class UndefinedCharacterTest {

    private final static String UNDEFINED_CHARACTER_VALUE = "?";
    private UndefinedCharacter undefinedCharacterUnderTest;

    @BeforeAll
    void setUp(){
        undefinedCharacterUnderTest
                = new UndefinedCharacter(BINARY_MATRIX_UNDEFINED_CHARACTER);
    }

    @Test
    void getValue() {
        assertThat(undefinedCharacterUnderTest.getValue())
                .isEqualTo(UNDEFINED_CHARACTER_VALUE);
    }

    @Test
    void getBinaryCode() {
    }
}