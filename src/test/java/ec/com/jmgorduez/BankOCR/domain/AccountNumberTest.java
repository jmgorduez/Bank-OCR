package ec.com.jmgorduez.BankOCR.domain;

import ec.com.jmgorduez.BankOCR.domain.abstractions.IAccountNumber;
import ec.com.jmgorduez.BankOCR.domain.readers.MultilineDigitReader;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static ec.com.jmgorduez.BankOCR.dataGenerator.DataTestGenerator.*;
import static ec.com.jmgorduez.BankOCR.domain.AccountNumber.IntegerAccountNumberClassification.*;
import static ec.com.jmgorduez.BankOCR.utils.Constants.*;
import static org.assertj.core.api.AssertionsForClassTypes.*;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
class AccountNumberTest {

    private AccountNumber accountNumberUnderTest;

    @BeforeEach
    void setUp() {
        accountNumberUnderTest = ACCOUNT_NUMBER_111111111;
    }

    @Test
    void getValue() {
        assertThat(accountNumberUnderTest.getValue())
                .isEqualTo(STRING_ACCOUNT_NUMBER_111111111);
    }

    @Test
    @DisplayName("It should if a account number is equal to other")
    void equals() {
        assertThat(accountNumberUnderTest.equals(this))
                .isFalse();
        assertThat(accountNumberUnderTest.equals(ACCOUNT_NUMBER_111111111))
                .isTrue();
        assertThat(accountNumberUnderTest.equals(accountNumberUnderTest))
                .isTrue();
    }

    @Test
    @DisplayName("It should calculate the checksum of account number.")
    void calculateCheckSum() {
        assertThat(accountNumberUnderTest.calculateCheckSum())
                .isEqualTo(CHECK_SUM_111111111);
        accountNumberUnderTest = ACCOUNT_NUMBER_123456789;
        assertThat(accountNumberUnderTest.calculateCheckSum())
                .isEqualTo(CHECK_SUM_123456789);
        accountNumberUnderTest = ACCOUNT_NUMBER_345882865;
        assertThat(accountNumberUnderTest.calculateCheckSum())
                .isEqualTo(CHECK_SUM_345882865);
    }

    @Test
    @DisplayName("It should return true if is a right account number.")
    void isRightAccountNumber() {
        assertThat(accountNumberUnderTest.isRightAccountNumber())
                .isFalse();
        accountNumberUnderTest = ACCOUNT_NUMBER_123456789;
        assertThat(accountNumberUnderTest.isRightAccountNumber())
                .isTrue();
        accountNumberUnderTest = ACCOUNT_NUMBER_000000000;
        assertThat(accountNumberUnderTest.isRightAccountNumber())
                .isTrue();
        accountNumberUnderTest = ACCOUNT_NUMBER_49006771_;
        assertThat(accountNumberUnderTest.isRightAccountNumber())
                .isFalse();
        accountNumberUnderTest = ACCOUNT_NUMBER_490067719;
        assertThat(accountNumberUnderTest.isRightAccountNumber())
                .isTrue();
        accountNumberUnderTest = ACCOUNT_NUMBER_111111111;
        assertThat(accountNumberUnderTest.isRightAccountNumber())
                .isFalse();
    }

    @Test
    @DisplayName("It should return true if is an illegible account number.")
    void isIllegibleAccountNumber() {
        assertThat(accountNumberUnderTest.isIllegibleAccountNumber())
                .isFalse();
        accountNumberUnderTest = ACCOUNT_NUMBER_49006771_;
        assertThat(accountNumberUnderTest.isIllegibleAccountNumber())
                .isTrue();
    }

    @Test
    @DisplayName("It should classify a account number in ILL o ERR.")
    void getAccountNumberClassification() {
        assertThat(accountNumberUnderTest.getAccountNumberClassification())
                .isEqualTo(ERR);
        accountNumberUnderTest = ACCOUNT_NUMBER_49006771_;
        assertThat(accountNumberUnderTest.getAccountNumberClassification())
                .isEqualTo(ILL);
        accountNumberUnderTest = ACCOUNT_NUMBER_123456789;
        assertThat(accountNumberUnderTest.getAccountNumberClassification())
                .isEqualTo(RIG);
    }

    @Test
    @DisplayName("It should return a new account number repaired")
    void repairAccountNumber() {
        assertThatThrownBy(() -> {
            accountNumberUnderTest = ACCOUNT_NUMBER_123456789;
            accountNumberUnderTest.repairAccountNumber(new MultilineDigitReader());
        }).isInstanceOf(UnsupportedOperationException.class);
        accountNumberUnderTest = ACCOUNT_NUMBER_49006771_;
        IAccountNumber accountNumber = accountNumberUnderTest.repairAccountNumber(new MultilineDigitReader());
        assertThat(accountNumber)
                .isEqualTo(ACCOUNT_NUMBER_490067719);
    }

    @Test
    @DisplayName("It should return how many digit are equals between two account numbers.")
    void howManyDigitsAreEquals() {
        assertThat(accountNumberUnderTest.howManyDigitsAreEquals(ACCOUNT_NUMBER_123456789))
                .isEqualTo(ONE);
        accountNumberUnderTest = ACCOUNT_NUMBER_000000000;
        assertThat(accountNumberUnderTest.howManyDigitsAreEquals(ACCOUNT_NUMBER_123456789))
                .isEqualTo(ZERO);
        accountNumberUnderTest = ACCOUNT_NUMBER_111111111;
        assertThat(accountNumberUnderTest.howManyDigitsAreEquals(ACCOUNT_NUMBER_111111111))
                .isEqualTo(NINE);
    }

    @Test
    @DisplayName("It should return a list with the posible numbers to repair actual account number.")
    void calculatePosibleRightNumbers() {
        accountNumberUnderTest = ACCOUNT_NUMBER_123456789;
        List<AccountNumber> expected = new ArrayList<>();
        expected.add(ACCOUNT_NUMBER_123456789);
        assertThat(accountNumberUnderTest
                .calculatePosibleRightNumbers(accountNumberUnderTest,
                        ZERO,
                        new MultilineDigitReader()))
                .isEqualTo(expected);
        accountNumberUnderTest = ACCOUNT_NUMBER_49006771_;
        List<AccountNumber> actual = accountNumberUnderTest
                .calculatePosibleRightNumbers(accountNumberUnderTest,
                        ZERO,
                        new MultilineDigitReader());
        assertThat(actual.contains(ACCOUNT_NUMBER_490067719))
                .isTrue();
    }

    @Test
    @DisplayName("It should return a copy of account number changing a character.")
    void copyAccountNumberChangingACharacter() {
        accountNumberUnderTest = ACCOUNT_NUMBER_49006771_;
        assertThat(accountNumberUnderTest
                .copyAccountNumberChangingACharacter(accountNumberUnderTest, EIGHT, DIGIT_NINE))
                .isEqualTo(ACCOUNT_NUMBER_490067719);
    }
}