package ec.com.jmgorduez.BankOCR.domain;

import ec.com.jmgorduez.BankOCR.dataGenerator.DataTestGenerator;
import ec.com.jmgorduez.BankOCR.domain.abstractions.IAccountNumber;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static ec.com.jmgorduez.BankOCR.dataGenerator.DataTestGenerator.INTEGER_ACCOUNT_NUMBER_111111111;
import static ec.com.jmgorduez.BankOCR.dataGenerator.DataTestGenerator.accountNumber111111111;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
class IntegerAccountNumberTest {

    private IAccountNumber<Integer> integerAccountNumberUnderTest;

    @BeforeAll
    void setUp() {
        integerAccountNumberUnderTest = new IntegerAccountNumber(INTEGER_ACCOUNT_NUMBER_111111111);
    }

    @Test
    void getValue() {
        assertThat(integerAccountNumberUnderTest.getValue())
                .isEqualTo(INTEGER_ACCOUNT_NUMBER_111111111);
    }

    @Test
    @DisplayName("It should if a account number is equal to other")
    void equals() {
        assertThat(integerAccountNumberUnderTest.equals(this))
                .isFalse();
        assertThat(integerAccountNumberUnderTest.equals(accountNumber111111111()))
                .isTrue();
        assertThat(integerAccountNumberUnderTest.equals(integerAccountNumberUnderTest))
                .isTrue();
    }
}