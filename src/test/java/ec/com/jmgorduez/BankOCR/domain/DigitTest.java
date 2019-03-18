package ec.com.jmgorduez.BankOCR.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.MockitoAnnotations;

import java.util.Objects;

import static ec.com.jmgorduez.BankOCR.DataTestGenerator.BINARY_CODE_ONE;
import static ec.com.jmgorduez.BankOCR.DataTestGenerator.BINARY_CODE_THREE;
import static ec.com.jmgorduez.BankOCR.utils.Constants.THREE;
import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
class DigitTest {

    private Digit digitUnderTest;
    private static final int ONE = 1;

    @BeforeAll
    void setUp(){
        MockitoAnnotations.initMocks(this);
        digitUnderTest = new Digit(ONE);
    }

    @Test
    void getValue() {
        assertThat(digitUnderTest.getValue()).isEqualTo(ONE);
    }

    @Test
    void equals() {
        assertThat(digitUnderTest.equals(new Digit(ONE))).isTrue();
    }

    @Test
    void hashCodeTest() {
        assertThat(digitUnderTest.hashCode()).isEqualTo(Objects.hashCode(ONE));
    }

    @Test
    @DisplayName("It should calculate the binary code for a digit.")
    void getBinaryCode(){
        digitUnderTest = new Digit(ONE);
        assertThat(digitUnderTest.getBinaryCode()).isEqualTo(BINARY_CODE_ONE);
        digitUnderTest = new Digit(THREE);
        assertThat(digitUnderTest.getBinaryCode()).isEqualTo(BINARY_CODE_THREE);
    }
}