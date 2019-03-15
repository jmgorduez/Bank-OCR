package ec.com.jmgorduez.BankOCR.domain;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

import ec.com.jmgorduez.BankOCR.domain.abstractions.IToken;
import ec.com.jmgorduez.BankOCR.domain.parsers.DigitParser;
import ec.com.jmgorduez.BankOCR.domain.parsers.TokenDigitParser;
import ec.com.jmgorduez.BankOCR.infrastructure.DigitReader;
import ec.com.jmgorduez.BankOCR.utils.DataTestGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
class DigitParserTest {

    private DigitParser digitParserUnderTest;

    @BeforeAll
    void setUp() throws Exception {
        digitParserUnderTest = new DigitParser();
    }

    @Test
    void parse() {
        TokenDigitParser tokenDigitParser = DataTestGenerator.createTokenDigitParserMock();
        String[] tokensStringForNumberOne = DataTestGenerator.generateTokensStringForNumberOne();
        DigitReader digitReader = new DigitReader(tokenDigitParser, tokensStringForNumberOne);
        assertThat(digitParserUnderTest.parse(digitReader)).isEqualTo(new Digit(1));
    }
}