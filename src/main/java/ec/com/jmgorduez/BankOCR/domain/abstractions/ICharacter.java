package ec.com.jmgorduez.BankOCR.domain.abstractions;

import java.util.List;

public interface ICharacter<T> {
    T getValue();
    int getBinaryCode();
    String getStringValue();
    List<ICharacter<T>> getSimilarCharacters(IMultilineCharacterReader multilineCharacterReader);
}
