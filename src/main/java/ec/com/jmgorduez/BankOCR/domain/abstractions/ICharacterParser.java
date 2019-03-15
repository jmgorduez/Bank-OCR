package ec.com.jmgorduez.BankOCR.domain.abstractions;

import java.util.List;

public interface ICharacterParser<T> {
    ICharacter<T> parse(ICharacterReader characterReader);
}
