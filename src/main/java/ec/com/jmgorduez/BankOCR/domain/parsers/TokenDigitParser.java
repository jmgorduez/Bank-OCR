package ec.com.jmgorduez.BankOCR.domain.parsers;

import ec.com.jmgorduez.BankOCR.domain.abstractions.IToken;
import ec.com.jmgorduez.BankOCR.domain.abstractions.ITokenParser;
import ec.com.jmgorduez.BankOCR.domain.tokens.BlankSpaceTokenForDigit;
import ec.com.jmgorduez.BankOCR.domain.tokens.UndefinedToken;
import ec.com.jmgorduez.BankOCR.domain.tokens.VerticalBarTokenForDigit;

public class TokenDigitParser implements ITokenParser {
    @Override
    public IToken parse(String tokenString) {
        switch (tokenString) {
            case " ":
                return new BlankSpaceTokenForDigit();
            case "|":
                return new VerticalBarTokenForDigit();
            default:
                return new UndefinedToken();
        }
    }
}
