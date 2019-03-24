package ec.com.jmgorduez.BankOCR.domain;

import ec.com.jmgorduez.BankOCR.domain.abstractions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IntegerAccountNumberReader implements IAccountNumberReader<DigitToken.TokenType, Integer> {

    @Override
    public IAccountNumber readAccountNumber(BufferedReader bufferedReader,
                                            ILineReader<DigitToken.TokenType> lineReader,
                                            IMultilineCharacterReader<Integer, DigitToken.TokenType> charaterReader,
                                            IMultilineStringReader<Integer, DigitToken.TokenType> multilineStringReader) throws IOException {
        List<ICharacter<Integer>> characters =
                multilineStringReader.readMultilineString(bufferedReader, lineReader, charaterReader);
        List<Integer> integerCharacters = new ArrayList<>();
        String accountNumber =
                characters.stream().map(character -> {
                    integerCharacters.add(character.getValue());
                    return String.valueOf(character.getValue());
                }).collect(Collectors.joining());

        return new IntegerAccountNumber(accountNumber,
                integerCharacters.toArray(new Integer[]{}));
    }
}
