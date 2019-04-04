package ec.com.jmgorduez.BankOCR.domain;

import ec.com.jmgorduez.BankOCR.domain.abstractions.IMultilineString;
import ec.com.jmgorduez.BankOCR.domain.abstractions.IToken;

import java.util.ArrayList;
import java.util.List;

import static ec.com.jmgorduez.BankOCR.utils.Constants.MATRIX_WIDTH_3;

public class MultilineString<TOKEN extends IToken> implements IMultilineString<TOKEN> {

    private List<List<TOKEN>> multilineString;
    private Integer characterWidth;

    public MultilineString(Integer characterWidth) {
        multilineString = new ArrayList<>();
        this.characterWidth = characterWidth;
    }

    @Override
    public void add(List<TOKEN> line) {
        multilineString.add(line);
    }

    @Override
    public Integer characterWidth() {
        return characterWidth;
    }

    @Override
    public IMultilineString<TOKEN> getCharacterSection(Integer index)
            throws StringIndexOutOfBoundsException {
        IMultilineString<TOKEN> character = new MultilineString<>(MATRIX_WIDTH_3);
        int indexFrom = index * characterWidth();
        int indexTo = indexFrom + characterWidth();
        try {
            multilineString.stream()
                    .forEach(line -> character.add(line.subList(indexFrom, indexTo)));
        }catch (IndexOutOfBoundsException error){
            throw new StringIndexOutOfBoundsException();
        }
        return character;
    }

    @Override
    public List<List<TOKEN>> rows() {
        return multilineString;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof MultilineString)) {
            return false;
        }
        return ((MultilineString) other).multilineString.equals(this.multilineString);
    }
}
