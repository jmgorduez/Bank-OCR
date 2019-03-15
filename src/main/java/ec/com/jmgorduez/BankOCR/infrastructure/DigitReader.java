package ec.com.jmgorduez.BankOCR.infrastructure;

import ec.com.jmgorduez.BankOCR.domain.abstractions.ICharacterReader;
import ec.com.jmgorduez.BankOCR.domain.abstractions.IToken;
import ec.com.jmgorduez.BankOCR.domain.abstractions.ITokenParser;

import java.util.ArrayList;
import java.util.List;

public class DigitReader implements ICharacterReader {

    private String[] tokensStringForRead;
    private ITokenParser tokenParser;

    public DigitReader(ITokenParser tokenParser, String[] tokensStringForRead) {
        this.tokenParser = tokenParser;
        this.tokensStringForRead = tokensStringForRead;
    }

    @Override
    public List<IToken> read() {
        List<IToken> tokens = new ArrayList<>();
        for (String token : tokensStringForRead) {
            tokens.add(tokenParser.parse(token));
        }
        return tokens;
    }
}
