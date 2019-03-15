package ec.com.jmgorduez.BankOCR.domain.abstractions;

import java.util.List;

public interface ICharacterReader {
    List<IToken> read();
}
