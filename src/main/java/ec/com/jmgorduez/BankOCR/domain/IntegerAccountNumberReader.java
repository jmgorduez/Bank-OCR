package ec.com.jmgorduez.BankOCR.domain;

import ec.com.jmgorduez.BankOCR.domain.abstractions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static ec.com.jmgorduez.BankOCR.utils.MathOperations.digitsArrayToNumberBaseTen;

public class IntegerAccountNumberReader implements IAccountNumberReader<DigitToken.TokenType, Integer> {

    @Override
    public IAccountNumber readAccountNumber(BufferedReader bufferedReader,
                                            ILineReader<DigitToken.TokenType> lineReader,
                                            IMultilineCharacterReader<Integer, DigitToken.TokenType> charaterReader,
                                            IMultilineStringReader<Integer, DigitToken.TokenType> multilineStringReader) throws IOException {
        List<ICharacter<Integer>> iCharacters =
                multilineStringReader.read(bufferedReader, lineReader, charaterReader);
        String accountNumber =
                iCharacters.stream().map(character -> {
                    return String.valueOf(character.getValue());
                }).collect(Collectors.joining());
        return new IntegerAccountNumber(accountNumber);
    }
}
