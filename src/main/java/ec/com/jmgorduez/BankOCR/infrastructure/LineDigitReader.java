package ec.com.jmgorduez.BankOCR.infrastructure;

import ec.com.jmgorduez.BankOCR.domain.abstractions.IToken;
import ec.com.jmgorduez.BankOCR.domain.DigitToken;
import ec.com.jmgorduez.BankOCR.infrastructure.abstractions.ILineReader;

public class LineDigitReader implements ILineReader<DigitToken.TokenType> {
    @Override
    public IToken<DigitToken.TokenType>[] readLine() {
        return new IToken[0];
    }
}
