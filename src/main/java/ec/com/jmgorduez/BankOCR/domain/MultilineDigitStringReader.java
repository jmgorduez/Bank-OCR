package ec.com.jmgorduez.BankOCR.domain;

import ec.com.jmgorduez.BankOCR.domain.abstractions.ICharacter;
import ec.com.jmgorduez.BankOCR.domain.abstractions.IToken;
import ec.com.jmgorduez.BankOCR.domain.abstractions.IMultilineCharacterReader;
import ec.com.jmgorduez.BankOCR.domain.abstractions.ILineReader;
import ec.com.jmgorduez.BankOCR.domain.abstractions.IMultilineString;
import ec.com.jmgorduez.BankOCR.domain.abstractions.IMultilineStringReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

import static ec.com.jmgorduez.BankOCR.utils.Constants.*;

public class MultilineDigitStringReader<CHARACTER_TYPE, TOKEN_TYPE extends Enum> implements IMultilineStringReader<CHARACTER_TYPE, TOKEN_TYPE> {

    private static final int CHARACTER_WIDTH = 3;
    private static final int CHARACTER_HEIGHT = 3;
    private final int stringLength;

    public MultilineDigitStringReader(int stringLength) {
        this.stringLength = stringLength;
    }

    @Override
    public List<ICharacter<CHARACTER_TYPE>> read(BufferedReader bufferedReader,
                                                 ILineReader<TOKEN_TYPE> lineReader,
                                                 IMultilineCharacterReader<CHARACTER_TYPE, TOKEN_TYPE> characterReader)
    throws IOException {
        IMultilineString<IToken<TOKEN_TYPE>> multilineString = new MultilineString<>(MATRIX_WIDTH_3);
        int lineCounter = 0;
        do {
            multilineString.add(lineReader.readLine(bufferedReader));
            lineCounter++;
        } while (lineCounter < CHARACTER_HEIGHT);
        lineReader.passEmptyLine(bufferedReader);
        return this.generateCharactersString(multilineString, characterReader);
    }

    List<ICharacter<CHARACTER_TYPE>> generateCharactersString(IMultilineString<IToken<TOKEN_TYPE>> multilineString,
                                                                      IMultilineCharacterReader<CHARACTER_TYPE,TOKEN_TYPE> characterReader) {
        List<ICharacter<CHARACTER_TYPE>> charactersString = new ArrayList<>();
        for (int i = ZERO; i < stringLength; i++) {
            IMultilineString<IToken<TOKEN_TYPE>> multilineCharacter = multilineString.getCharacterSection(i);
            charactersString.add(characterReader.readCharacter(multilineCharacter));
        }
        return charactersString;
    }
}
