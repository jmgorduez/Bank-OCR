package ec.com.jmgorduez.BankOCR.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Objects;

import static ec.com.jmgorduez.BankOCR.utils.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
class DigitTokenTest {

    private DigitToken digitTokenUnderTest;

    @Test
    @DisplayName("It should return the digit token value.")
    void getValue() {
        digitTokenUnderTest = new DigitToken(DigitToken.TokenType.BLANK_SPACE.getValue());
        assertThat(digitTokenUnderTest.getValue()).isEqualTo(DigitToken.TokenType.BLANK_SPACE);
        digitTokenUnderTest = new DigitToken(DigitToken.TokenType.PIPE);
        assertThat(digitTokenUnderTest.getValue()).isEqualTo(DigitToken.TokenType.PIPE);
        digitTokenUnderTest = new DigitToken(DigitToken.TokenType.UNDERSCORE);
        assertThat(digitTokenUnderTest.getValue()).isEqualTo(DigitToken.TokenType.UNDERSCORE);
        digitTokenUnderTest = new DigitToken(DigitToken.TokenType.UNDEFINED);
        assertThat(digitTokenUnderTest.getValue()).isEqualTo(DigitToken.TokenType.UNDEFINED);
    }

    @Test
    @DisplayName("It should tell if the digit token is equal to other one")
    void equals() {
        digitTokenUnderTest = new DigitToken(DigitToken.TokenType.PIPE);
        assertThat(digitTokenUnderTest.equals(new DigitToken(DigitToken.TokenType.UNDERSCORE))).isFalse();
        assertThat(digitTokenUnderTest.equals(new DigitToken(DigitToken.TokenType.PIPE))).isTrue();
        assertThat(digitTokenUnderTest.equals(digitTokenUnderTest)).isTrue();
        assertThat(digitTokenUnderTest.equals(DigitToken.TokenType.PIPE)).isFalse();
    }

    @Test
    @DisplayName("It should return the digit token hash code.")
    void hashCodeTest() {
        digitTokenUnderTest = new DigitToken(DigitToken.TokenType.UNDERSCORE);
        assertThat(digitTokenUnderTest.hashCode()).isEqualTo(Objects.hashCode(DigitToken.TokenType.UNDERSCORE));
        assertThat(digitTokenUnderTest.hashCode()).isNotEqualTo(Objects.hashCode(DigitToken.TokenType.BLANK_SPACE));
    }

    @Test
    @DisplayName("It should tell if the digit token is or not a visible token.")
    void isVisible(){
        digitTokenUnderTest = new DigitToken(DigitToken.TokenType.BLANK_SPACE.getValue());
        assertThat(digitTokenUnderTest.isVisible()).isFalse();
        digitTokenUnderTest = new DigitToken(DigitToken.TokenType.PIPE);
        assertThat(digitTokenUnderTest.isVisible()).isTrue();
        digitTokenUnderTest = new DigitToken(DigitToken.TokenType.UNDERSCORE);
        assertThat(digitTokenUnderTest.isVisible()).isTrue();
        digitTokenUnderTest = new DigitToken(DigitToken.TokenType.UNDEFINED);
        assertThat(digitTokenUnderTest.isVisible()).isTrue();
    }

    @Test
    @DisplayName("It should parse a string to TokenType")
    void parse(){
        assertThat(DigitToken.TokenType.parse(PIPE_STRING))
        .isEqualTo(DigitToken.TokenType.PIPE);
        assertThat(DigitToken.TokenType.parse(UNDEFINED_STRING))
                .isEqualTo(DigitToken.TokenType.UNDEFINED);
        assertThat(DigitToken.TokenType.parse(UNDERSCORE_STRING))
                .isEqualTo(DigitToken.TokenType.UNDERSCORE);
    }
}