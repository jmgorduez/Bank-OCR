package ec.com.jmgorduez.BankOCR.domain.readers;

import ec.com.jmgorduez.BankOCR.domain.DigitToken;
import ec.com.jmgorduez.BankOCR.domain.AccountNumber;
import ec.com.jmgorduez.BankOCR.domain.abstractions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class AccountNumberReader implements IAccountNumberReader<DigitToken.TokenType, Integer> {

    @Override
    public IAccountNumber readAccountNumber(BufferedReader bufferedReader,
                                            ILineReader<DigitToken.TokenType> lineReader,
                                            IMultilineCharacterReader<Integer, DigitToken.TokenType> charaterReader,
                                            IMultilineStringReader<Integer, DigitToken.TokenType> multilineStringReader) throws IOException {
        List<ICharacter<Integer>> characters =
                multilineStringReader.readMultilineString(bufferedReader, lineReader, charaterReader);
        return new AccountNumber(characters);
    }
}
