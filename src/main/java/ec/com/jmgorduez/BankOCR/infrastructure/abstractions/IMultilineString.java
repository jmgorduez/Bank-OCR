package ec.com.jmgorduez.BankOCR.infrastructure.abstractions;

import ec.com.jmgorduez.BankOCR.domain.abstractions.ICharacter;
import ec.com.jmgorduez.BankOCR.domain.abstractions.IToken;

import java.util.List;

public interface IMultilineString<TOKEN extends IToken> {
    void add(List<TOKEN> line);
    Integer characterWidth();
    IMultilineString<TOKEN> getCharacterSection(Integer index);
    Integer lineCount();
    List<List<TOKEN>> rows();
}
