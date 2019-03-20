package ec.com.jmgorduez.BankOCR.domain.abstractions;

import java.util.List;

public interface IMultilineString<TOKEN extends IToken> {
    void add(List<TOKEN> line);
    Integer characterWidth();
    IMultilineString<TOKEN> getCharacterSection(Integer index);
    List<List<TOKEN>> rows();
}
