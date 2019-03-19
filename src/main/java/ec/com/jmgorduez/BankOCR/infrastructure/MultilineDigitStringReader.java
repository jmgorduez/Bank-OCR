package ec.com.jmgorduez.BankOCR.infrastructure;

import ec.com.jmgorduez.BankOCR.domain.abstractions.ICharacter;
import ec.com.jmgorduez.BankOCR.domain.abstractions.IToken;
import ec.com.jmgorduez.BankOCR.infrastructure.abstractions.IMultilineCharacterReader;
import ec.com.jmgorduez.BankOCR.infrastructure.abstractions.ILineReader;
import ec.com.jmgorduez.BankOCR.infrastructure.abstractions.IMultilineString;
import ec.com.jmgorduez.BankOCR.infrastructure.abstractions.IMultilineStringReader;
import ec.com.jmgorduez.BankOCR.utils.Constants;

import java.util.*;

import static ec.com.jmgorduez.BankOCR.utils.Constants.ONE;

public class MultilineDigitStringReader<CHARACTER_TYPE, TOKEN_TYPE extends Enum> implements IMultilineStringReader<CHARACTER_TYPE, TOKEN_TYPE> {

    private static final int CHARACTER_WIDTH = 3;
    private static final int CHARACTER_HEIGHT = 3;
    private final int stringLength;

    public MultilineDigitStringReader(int stringLength) {
        this.stringLength = stringLength;
    }

    @Override
    public List<ICharacter<CHARACTER_TYPE>> read(ILineReader<TOKEN_TYPE> lineReader,
                                                 IMultilineCharacterReader<CHARACTER_TYPE, TOKEN_TYPE> characterReader) {
        MultilineString<IToken<TOKEN_TYPE>> multilineString = new MultilineString<>(Constants.MATRIX_WIDTH_3);
        int lineCounter = 0;
        do {
            multilineString.add(lineReader.readLine());
            lineCounter++;
        } while (lineCounter < CHARACTER_HEIGHT);
        return this.generateCharactersString(multilineString, characterReader);
    }

    List<ICharacter<CHARACTER_TYPE>> generateCharactersString(MultilineString<IToken<TOKEN_TYPE>> multilineString,
                                                                      IMultilineCharacterReader<CHARACTER_TYPE,TOKEN_TYPE> characterReader) {
        List<ICharacter<CHARACTER_TYPE>> charactersString = new ArrayList<>();
        for (int i = ONE; i <= stringLength; i++) {
            IMultilineString<IToken<TOKEN_TYPE>> multilineCharacter = multilineString.getCharacterSection(CHARACTER_WIDTH);
            charactersString.add(characterReader.readCharacter(multilineCharacter));
        }
        return charactersString;
    }
}
