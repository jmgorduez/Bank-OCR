package ec.com.jmgorduez.BankOCR.domain;

import ec.com.jmgorduez.BankOCR.domain.abstractions.IAccountNumber;
import ec.com.jmgorduez.BankOCR.domain.abstractions.IAccountNumberReader;
import ec.com.jmgorduez.BankOCR.domain.abstractions.ICharacter;

import java.util.List;
import java.util.stream.Collectors;

import static ec.com.jmgorduez.BankOCR.utils.MathOperations.digitsArrayToNumberBaseTen;

public class IntegerAccountNumberReader implements IAccountNumberReader<DigitToken.TokenType, Integer> {

    @Override
    public IAccountNumber<Integer> readAccountNumber(List<ICharacter<Integer>> iCharacters) {
        List<Integer> digitsOfAccountNumber =
                iCharacters.stream().map(character -> {
                    return character.getValue();
                }).collect(Collectors.toList());
        Integer accountNumber = digitsArrayToNumberBaseTen(
                digitsOfAccountNumber.toArray(new Integer[]{}));
        return new IntegerAccountNumber(accountNumber);
    }
}
