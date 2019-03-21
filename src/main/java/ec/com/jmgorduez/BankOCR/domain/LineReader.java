package ec.com.jmgorduez.BankOCR.domain;

import ec.com.jmgorduez.BankOCR.domain.abstractions.IToken;
import ec.com.jmgorduez.BankOCR.domain.DigitToken;
import ec.com.jmgorduez.BankOCR.domain.abstractions.ILineReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    List<IToken<DigitToken.TokenType>> refillEmptyLineWithBlankSpaceCharacters(){
        return null;
    }

    @Override
    public void passEmptyLine(BufferedReader bufferedReader) throws IOException {
        bufferedReader.readLine();
    }
}
