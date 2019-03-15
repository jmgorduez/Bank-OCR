package ec.com.jmgorduez.BankOCR.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.*;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class DigitTest {

    private Digit digitUnderTest;

    @BeforeAll
    public void setUp() throws Exception {
        digitUnderTest = new Digit(0);
    }

    @Test
    public void getValue() {
        assertThat(digitUnderTest.getValue()).isEqualTo(new Integer(0));
    }
}