package ec.com.jmgorduez.BankOCR.infrastructure;

import ec.com.jmgorduez.BankOCR.domain.parsers.TokenDigitParser;
import ec.com.jmgorduez.BankOCR.utils.DataTestGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DigitReaderTest {

    private DigitReader digitReaderUnderTest;

    @Test
    void read() {
        TokenDigitParser tokenDigitParser = DataTestGenerator.createTokenDigitParserMock();
        digitReaderUnderTest = new DigitReader(tokenDigitParser, DataTestGenerator.generateTokensStringForNumberOne());
        assertThat(digitReaderUnderTest.read()).isEqualTo(DataTestGenerator.generateTokensListForNumberOne());
    }
}