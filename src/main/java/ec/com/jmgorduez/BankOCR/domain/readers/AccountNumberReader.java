package ec.com.jmgorduez.BankOCR.domain.readers;

import ec.com.jmgorduez.BankOCR.domain.DigitToken;
import ec.com.jmgorduez.BankOCR.domain.AccountNumber;
import ec.com.jmgorduez.BankOCR.domain.abstractions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class AccountNumberReader implements IAccountNumberReader<DigitToken.TokenType> {

    @Override
    public IAccountNumber readAccountNumber(BufferedReader bufferedReader,
                                            ILineReader<DigitToken.TokenType> readLine,
                                            IMultilineCharacterReader< DigitToken.TokenType> charaterReader,
                                            IMultilineStringReader< DigitToken.TokenType> multilineStringReader) throws IOException {
        List<ICharacter> characters =
                multilineStringReader.readMultilineString(bufferedReader, readLine, charaterReader);
        return new AccountNumber(characters);
    }
}
