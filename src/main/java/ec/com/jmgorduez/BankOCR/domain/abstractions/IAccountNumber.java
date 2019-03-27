package ec.com.jmgorduez.BankOCR.domain.abstractions;

public interface IAccountNumber {
    String getValue();
    Integer calculateCheckSum();
    Boolean isRightAccountNumber();
    Boolean isIllegibleAccountNumber();
    Enum getAccountNumberClassification();
    IAccountNumber repairAccountNumber(IMultilineCharacterReader multilineCharacterReader);
}
