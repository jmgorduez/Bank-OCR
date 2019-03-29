package ec.com.jmgorduez.BankOCR.domain;

import ec.com.jmgorduez.BankOCR.domain.readers.MultilineDigitReader;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Objects;

import static ec.com.jmgorduez.BankOCR.dataGenerator.DataTestGenerator.*;
import static ec.com.jmgorduez.BankOCR.utils.Constants.*;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
class UndefinedDigitTest {

    private UndefinedDigit undefinedDigitUnderTest;

    @BeforeEach
    void setUp() {
        undefinedDigitUnderTest
                = new UndefinedDigit(WRONG_BINARY_MATRIX);
    }

    @Test
    @DisplayName("It should return the value ?.")
    void getValue() {
        assertThat(undefinedDigitUnderTest.getIntegerValue())
                .isEqualTo(UNDEFINED_DIGIT_VALUE);
    }

    @Test
    @DisplayName("It should calculate the binary code.")
    void getBinaryCode() {
        assertThat(undefinedDigitUnderTest.getBinaryCode())
                .isEqualTo(WRONG_BINARY_CODE);
    }

    @Test
    @DisplayName("It should return ? like string value of a undefined char.")
    void getStringValue() {
        assertThat(undefinedDigitUnderTest.getStringValue())
                .isEqualTo(UNDEFINED_DIGIT_STRING_VALUE);
    }

    @Test
    @DisplayName("It should tell if the undefined character value is equal to other one")
    void equals() {
        assertThat(undefinedDigitUnderTest
                .equals(new UndefinedDigit(WRONG_BINARY_MATRIX)))
                .isTrue();
        assertThat(undefinedDigitUnderTest.equals(this))
                .isFalse();
        assertThat(undefinedDigitUnderTest.equals(undefinedDigitUnderTest))
                .isTrue();
    }

    @Test
    @DisplayName("It should return the undefined character hash code")
    void hashCodeTest() {
        assertThat(undefinedDigitUnderTest.hashCode())
                .isEqualTo(Objects.hashCode(UNDEFINED_CHARACTER));
    }

    @Test
    @DisplayName("It should return the list of similar chars.")
    void getSimilarCharacters() {
        assertThat(undefinedDigitUnderTest.getSimilarCharacters(new MultilineDigitReader()))
                .isEqualTo(new ArrayList<>());
        undefinedDigitUnderTest = (UndefinedDigit) generateUndefinedCharacterSimilarDigitNine();
        assertThat(undefinedDigitUnderTest.getSimilarCharacters(new MultilineDigitReader()))
                .isEqualTo(generateListUndefinedCharacterSimilarDigitNineSimilarCharacters());

    }
}