package ec.com.jmgorduez.BankOCR.domain;

import ec.com.jmgorduez.BankOCR.domain.abstractions.IAccountNumber;
import ec.com.jmgorduez.BankOCR.utils.Constants;
import org.junit.jupiter.api.*;

import static ec.com.jmgorduez.BankOCR.dataGenerator.DataTestGenerator.*;
import static ec.com.jmgorduez.BankOCR.utils.Constants.ONE;
import static ec.com.jmgorduez.BankOCR.utils.Constants.TEN;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
class IntegerAccountNumberTest {

    private IntegerAccountNumber integerAccountNumberUnderTest;

    @BeforeEach
    void setUp() {
        integerAccountNumberUnderTest = new IntegerAccountNumber(STRING_ACCOUNT_NUMBER_111111111,
                CHARACTERS_ACCOUNT_NUMBER_111111111);
    }

    @Test
    void getValue() {
        assertThat(integerAccountNumberUnderTest.getValue())
                .isEqualTo(STRING_ACCOUNT_NUMBER_111111111);
    }

    @Test
    @DisplayName("It should if a account number is equal to other")
    void equals() {
        assertThat(integerAccountNumberUnderTest.equals(this))
                .isFalse();
        assertThat(integerAccountNumberUnderTest.equals(ACCOUNT_NUMBER_111111111))
                .isTrue();
        assertThat(integerAccountNumberUnderTest.equals(integerAccountNumberUnderTest))
                .isTrue();
    }

    @Test
    @DisplayName("It should calculate the checksum of account number.")
    void calculateCheckSum() {
        assertThat(integerAccountNumberUnderTest.calculateCheckSum())
                .isEqualTo(CHECK_SUM_111111111);
        integerAccountNumberUnderTest = new IntegerAccountNumber(STRING_ACCOUNT_NUMBER_123456789,
                CHARACTERS_ACCOUNT_NUMBER_123456789);
        assertThat(integerAccountNumberUnderTest.calculateCheckSum())
                .isEqualTo(CHECK_SUM_123456789);
    }

    @Test
    @DisplayName("It should return the characters of a account number.")
    void getCharacters(){
        assertThat(integerAccountNumberUnderTest.getCharacters())
                .isEqualTo(CHARACTERS_ACCOUNT_NUMBER_111111111);
        assertThat(integerAccountNumberUnderTest.getCharacters())
                .isNotEqualTo(CHARACTERS_ACCOUNT_NUMBER_000000000);
    }
}