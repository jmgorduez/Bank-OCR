package ec.com.jmgorduez.BankOCR.infrastructure;

import ec.com.jmgorduez.BankOCR.domain.abstractions.ICharacter;
import ec.com.jmgorduez.BankOCR.domain.abstractions.IToken;
import ec.com.jmgorduez.BankOCR.infrastructure.abstractions.ICharacterReader;
import ec.com.jmgorduez.BankOCR.infrastructure.abstractions.ILineReader;
import ec.com.jmgorduez.BankOCR.infrastructure.abstractions.IStringReader;

import java.util.ArrayList;
import java.util.List;

public class MultiLinesStringReader<CHARACTER_TYPE, TOKEN_TYPE extends Enum> implements IStringReader<CHARACTER_TYPE, TOKEN_TYPE> {

    private static final int CHARACTER_WIDTH = 3;
    private static final int CHARACTER_HEIGHT = 3;
    private final int stringLength;

    public MultiLinesStringReader(int stringLength) {
        this.stringLength = stringLength;
    }

    @Override
    public List<ICharacter<CHARACTER_TYPE>> read(ILineReader<TOKEN_TYPE> lineReader,
                                                 ICharacterReader<CHARACTER_TYPE, TOKEN_TYPE> characterReader) {
        IToken<TOKEN_TYPE>[][] linesRead = new IToken[stringLength * CHARACTER_WIDTH][CHARACTER_HEIGHT];
        int lineCounter = 0;
        do {
            linesRead[lineCounter] = lineReader.readLine();
            lineCounter++;
        } while (lineCounter < CHARACTER_HEIGHT);
        return this.generateCharactersString(linesRead, characterReader);
    }

    List<ICharacter<CHARACTER_TYPE>> generateCharactersString(IToken<TOKEN_TYPE>[][] linesRead,
                                                                      ICharacterReader<CHARACTER_TYPE,TOKEN_TYPE> characterReader) {
        List<ICharacter<CHARACTER_TYPE>> charactersString = new ArrayList<>();
        int characterCounter = 0;
        for (int rowIt = 0; rowIt < CHARACTER_HEIGHT; rowIt++) {
            IToken<TOKEN_TYPE>[][] characterSection = new IToken[CHARACTER_WIDTH][CHARACTER_HEIGHT];
            for (int colIt = 0; colIt < CHARACTER_WIDTH; colIt++) {
                characterSection[colIt][rowIt] = linesRead[colIt + (characterCounter * CHARACTER_WIDTH)][rowIt];
                charactersString.add(characterReader.readCharacter(characterSection));
            }
            characterCounter++;
        }
        return charactersString;
    }
}
