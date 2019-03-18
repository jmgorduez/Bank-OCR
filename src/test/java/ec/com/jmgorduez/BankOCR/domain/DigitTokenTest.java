package ec.com.jmgorduez.BankOCR.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
class DigitTokenTest {

    private DigitToken digitTokenUnderTest;

    @Test
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
    void equals() {
        digitTokenUnderTest = new DigitToken(DigitToken.TokenType.PIPE);
        assertThat(digitTokenUnderTest.equals(new DigitToken(DigitToken.TokenType.UNDERSCORE))).isFalse();
        assertThat(digitTokenUnderTest.equals(new DigitToken(DigitToken.TokenType.PIPE))).isTrue();
        assertThat(digitTokenUnderTest.equals(digitTokenUnderTest)).isTrue();
        assertThat(digitTokenUnderTest.equals(DigitToken.TokenType.PIPE)).isFalse();
    }

    @Test
    void hashCodeTest() {
        digitTokenUnderTest = new DigitToken(DigitToken.TokenType.UNDERSCORE);
        assertThat(digitTokenUnderTest.hashCode()).isEqualTo(Objects.hashCode(DigitToken.TokenType.UNDERSCORE));
        assertThat(digitTokenUnderTest.hashCode()).isNotEqualTo(Objects.hashCode(DigitToken.TokenType.BLANK_SPACE));
    }

    @Test
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
}