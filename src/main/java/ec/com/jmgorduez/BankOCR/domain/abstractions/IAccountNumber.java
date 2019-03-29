package ec.com.jmgorduez.BankOCR.domain.abstractions;

public interface IAccountNumber<TYPE_CLASSIFICATION extends Enum> {
    String getValue();
    Integer calculateCheckSum();
    Boolean isRightAccountNumber(IMultilineCharacterReader multilineCharacterReader);
    Boolean isIllegibleAccountNumber(IMultilineCharacterReader multilineCharacterReader);
    TYPE_CLASSIFICATION getAccountNumberClassification(IMultilineCharacterReader multilineCharacterReader);
    IAccountNumber repairAccountNumber(IMultilineCharacterReader multilineCharacterReader);
    ICharacter getDigit(Integer index);
}
