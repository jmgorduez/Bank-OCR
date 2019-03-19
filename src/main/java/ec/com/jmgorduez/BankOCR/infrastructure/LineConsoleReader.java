package ec.com.jmgorduez.BankOCR.infrastructure;

import com.sun.deploy.util.ArrayUtil;
import ec.com.jmgorduez.BankOCR.domain.abstractions.IToken;
import ec.com.jmgorduez.BankOCR.domain.DigitToken;
import ec.com.jmgorduez.BankOCR.infrastructure.abstractions.ILineReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LineConsoleReader implements ILineReader<DigitToken.TokenType> {
    @Override
    public List<IToken<DigitToken.TokenType>> readLine(BufferedReader reader)
            throws IOException {
        List<IToken<DigitToken.TokenType>> lineOfTokens = new ArrayList<>();
        return lineOfTokens;
    }
}
