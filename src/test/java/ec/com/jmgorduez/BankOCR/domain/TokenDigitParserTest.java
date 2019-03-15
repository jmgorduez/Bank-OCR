package ec.com.jmgorduez.BankOCR.domain;


import static org.assertj.core.api.Assertions.*;

import ec.com.jmgorduez.BankOCR.domain.parsers.TokenDigitParser;
import ec.com.jmgorduez.BankOCR.domain.tokens.BlankSpaceTokenForDigit;
import ec.com.jmgorduez.BankOCR.domain.tokens.VerticalBarTokenForDigit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TokenDigitParserTest {

    private TokenDigitParser tokenDigitParserUnderTest;

    @BeforeEach
    void setUp() {
        this.tokenDigitParserUnderTest = new TokenDigitParser();
    }

    @Test
    void parse() {
        assertThat(tokenDigitParserUnderTest.parse(" ")).isEqualTo(new BlankSpaceTokenForDigit());
        assertThat(tokenDigitParserUnderTest.parse("|")).isEqualTo(new VerticalBarTokenForDigit());
    }
}