package ec.com.jmgorduez.BankOCR.domain.abstractions;

public interface IAccountNumber {
    String getValue();
    Integer calculateCheckSum();
    Boolean isRightAccountNumber(IMultilineCharacterReader multilineCharacterReader);
    Boolean isIllegibleAccountNumber(IMultilineCharacterReader multilineCharacterReader);
    Enum getAccountNumberClassification(IMultilineCharacterReader multilineCharacterReader);
    IAccountNumber repairAccountNumber(IMultilineCharacterReader multilineCharacterReader);
    ICharacter getDigit(Integer index);
}
