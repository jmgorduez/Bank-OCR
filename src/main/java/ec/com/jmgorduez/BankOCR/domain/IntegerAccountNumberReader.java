package ec.com.jmgorduez.BankOCR.domain;

import ec.com.jmgorduez.BankOCR.domain.abstractions.IAccountNumber;
import ec.com.jmgorduez.BankOCR.domain.abstractions.IAccountNumberReader;
import ec.com.jmgorduez.BankOCR.domain.abstractions.ICharacter;

import java.util.List;
import java.util.stream.Collectors;

import static ec.com.jmgorduez.BankOCR.utils.MathOperations.digitsArrayToNumberBaseTen;

public class IntegerAccountNumberReader implements IAccountNumberReader<DigitToken.TokenType, Integer> {

    @Override
    public IAccountNumber readAccountNumber(List<ICharacter<Integer>> iCharacters) {
        String accountNumber =
                iCharacters.stream().map(character -> {
                    return String.valueOf(character.getValue());
                }).collect(Collectors.joining());
        return new IntegerAccountNumber(accountNumber);
    }
}
