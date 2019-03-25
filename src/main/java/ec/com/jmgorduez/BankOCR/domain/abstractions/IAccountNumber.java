package ec.com.jmgorduez.BankOCR.domain.abstractions;

public interface IAccountNumber {
    String getValue();
    Integer calculateCheckSum();
    Integer[] getCharacters();
    Boolean isRightAccountNumber();
    Boolean isIllegibleAccountNumber();
    Enum getAccountNumberClassification();
}
