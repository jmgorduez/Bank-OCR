package ec.com.jmgorduez.BankOCR.domain;

import ec.com.jmgorduez.BankOCR.domain.abstractions.IToken;
import ec.com.jmgorduez.BankOCR.domain.abstractions.ILineReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ec.com.jmgorduez.BankOCR.domain.DigitToken.TokenType.BLANK_SPACE;
import static ec.com.jmgorduez.BankOCR.utils.Constants.*;

public class LineReader implements ILineReader<DigitToken.TokenType> {
    @Override
    public List<IToken<DigitToken.TokenType>> readLine(BufferedReader reader)
            throws IOException {
        String line = reader.readLine();
        List<IToken<DigitToken.TokenType>> lineOfTokens = new ArrayList<>();
        line.chars().mapToObj(character -> (char) character)
                .forEach(character -> {
                    lineOfTokens.add(new DigitToken(Character.toString(character)));
                });
        return lineOfTokens;
    }

    @Override
    public List<IToken<DigitToken.TokenType>> generateBlankSpaceCharactersLineLikeRefillOfEmptyLine() {
        Stream<DigitToken> stream = Stream.generate(
                () -> new DigitToken(BLANK_SPACE)).limit(MATRIX_WIDTH_27);
        return stream.collect(Collectors.toList());
    }

    @Override
    public void passEmptyLine(BufferedReader bufferedReader) throws IOException {
        bufferedReader.readLine();
    }
}
