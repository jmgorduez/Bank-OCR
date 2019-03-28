package ec.com.jmgorduez.BankOCR.domain.abstractions;

import java.util.List;

public interface ICharacter {
    Integer getIntegerValue();
    int getBinaryCode();
    String getStringValue();
    List<ICharacter> getSimilarCharacters(IMultilineCharacterReader multilineCharacterReader);
    Integer calculateCheckSumValue(Integer characterIndex);
}
