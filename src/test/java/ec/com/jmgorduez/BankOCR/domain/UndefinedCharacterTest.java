package ec.com.jmgorduez.BankOCR.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import java.util.Objects;

import static ec.com.jmgorduez.BankOCR.dataGenerator.DataTestGenerator.*;
import static ec.com.jmgorduez.BankOCR.utils.Constants.*;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
class UndefinedCharacterTest {

    private UndefinedCharacter undefinedCharacterUnderTest;

    @BeforeEach
    void setUp() {
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
    void getStringValue() {
        assertThat(undefinedCharacterUnderTest.getStringValue())
                .isEqualTo(UNDEFINED_CHARACTER_STRING_VALUE);
    }

    @Test
    @DisplayName("It should return a undefinedCharacter instance.")
    void getInstance() {
        assertThat(undefinedCharacterUnderTest.getInstance(WRONG_BINARY_MATRIX))
                .isEqualTo(undefinedCharacterUnderTest);
    }

    @Test
    @DisplayName("It should tell if the undefined character value is equal to other one")
    void equals() {
        assertThat(undefinedCharacterUnderTest
                .equals(new UndefinedCharacter(WRONG_BINARY_MATRIX)))
                .isTrue();
        assertThat(undefinedCharacterUnderTest.equals(this))
                .isFalse();
        assertThat(undefinedCharacterUnderTest.equals(undefinedCharacterUnderTest))
                .isTrue();
    }

    @Test
    @DisplayName("It should return the undefined character hash code")
    void hashCodeTest() {
        assertThat(undefinedCharacterUnderTest.hashCode())
                .isEqualTo(Objects.hashCode(UNDEFINED_CHARACTER));
    }
}