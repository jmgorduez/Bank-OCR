package ec.com.jmgorduez.BankOCR.utils;

import ec.com.jmgorduez.BankOCR.domain.tokens.BlankSpaceTokenForDigit;
import ec.com.jmgorduez.BankOCR.domain.parsers.TokenDigitParser;
import ec.com.jmgorduez.BankOCR.domain.tokens.VerticalBarTokenForDigit;
import ec.com.jmgorduez.BankOCR.domain.abstractions.IToken;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DataTestGenerator {

    public static List<IToken> generateTokensListForNumberOne(){
        List<IToken> digitTokenList = new ArrayList<>();
        digitTokenList.add(new BlankSpaceTokenForDigit());
        digitTokenList.add(new VerticalBarTokenForDigit());
        digitTokenList.add(new VerticalBarTokenForDigit());
        return digitTokenList;
    }

    public static String[] generateTokensStringForNumberOne(){
        return new String[]{" ", "|", "|"};
    }

    public static TokenDigitParser createTokenDigitParserMock(){
        TokenDigitParser tokenDigitParser = mock(TokenDigitParser.class);
        when(tokenDigitParser.parse(" ")).thenReturn(new BlankSpaceTokenForDigit());
        when(tokenDigitParser.parse("|")).thenReturn(new VerticalBarTokenForDigit());
        return tokenDigitParser;
    }
}
