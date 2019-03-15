package ec.com.jmgorduez.BankOCR.domain.parsers;

import ec.com.jmgorduez.BankOCR.domain.Digit;
import ec.com.jmgorduez.BankOCR.domain.abstractions.ICharacter;
import ec.com.jmgorduez.BankOCR.domain.abstractions.ICharacterParser;
import ec.com.jmgorduez.BankOCR.domain.abstractions.ICharacterReader;
import ec.com.jmgorduez.BankOCR.domain.abstractions.IToken;

import java.util.List;

public class DigitParser implements ICharacterParser<Integer> {
    @Override
    public ICharacter<Integer> parse(ICharacterReader characterReader) {
        List<IToken> tokensReadList = characterReader.read();
        return new Digit(1);
    }
}
