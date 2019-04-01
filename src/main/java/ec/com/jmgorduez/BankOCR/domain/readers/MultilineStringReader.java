package ec.com.jmgorduez.BankOCR.domain.readers;

import ec.com.jmgorduez.BankOCR.domain.MultilineString;
import ec.com.jmgorduez.BankOCR.domain.abstractions.ICharacter;
import ec.com.jmgorduez.BankOCR.domain.abstractions.IToken;
import ec.com.jmgorduez.BankOCR.domain.abstractions.IMultilineCharacterReader;
import ec.com.jmgorduez.BankOCR.domain.abstractions.ILineReader;
import ec.com.jmgorduez.BankOCR.domain.abstractions.IMultilineString;
import ec.com.jmgorduez.BankOCR.domain.abstractions.IMultilineStringReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ec.com.jmgorduez.BankOCR.utils.Constants.*;

public class MultilineStringReader<TOKEN_TYPE extends Enum> implements IMultilineStringReader<TOKEN_TYPE> {

    private static final int CHARACTER_WIDTH = 3;
    private static final int CHARACTER_HEIGHT = 3;
    private final int stringLength;

    public MultilineStringReader(int stringLength) {
        this.stringLength = stringLength;
    }

    @Override
    public List<ICharacter> readMultilineString(BufferedReader bufferedReader,
                                                ILineReader<TOKEN_TYPE> lineReader,
                                                IMultilineCharacterReader<TOKEN_TYPE> characterReader)
            throws IOException {
        IMultilineString<IToken<TOKEN_TYPE>> multilineString = new MultilineString<>(CHARACTER_WIDTH);
        int lineCounter = 0;
        do {
            List<IToken<TOKEN_TYPE>> tokensRead = lineReader.readLine(bufferedReader);
            if (tokensRead.isEmpty()) {
                tokensRead = lineReader.generateBlankSpaceCharactersLineLikeRefillOfEmptyLine();
            }
            multilineString.add(tokensRead);
            lineCounter++;
        } while (lineCounter < CHARACTER_HEIGHT);
        lineReader.passEmptyLine(bufferedReader);
        return this.generateCharactersString(multilineString, characterReader);
    }

    List<ICharacter> generateCharactersString(IMultilineString<IToken<TOKEN_TYPE>> multilineString,
                                              IMultilineCharacterReader<TOKEN_TYPE> characterReader) {
        List<ICharacter> charactersString =
                Stream.iterate(ZERO, index -> index + ONE).limit(stringLength)
                        .map(index -> characterReader.readCharacter(multilineString
                                .getCharacterSection(index)))
                        .collect(Collectors.toList());
        return charactersString;
    }
}
