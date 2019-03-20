package ec.com.jmgorduez.BankOCR.domain.abstractions;

import java.util.List;

public interface IAccountNumberReader<TOKEN_TYPE extends Enum, CHARACTER_TYPE> {
    IAccountNumber readAccountNumber(List<ICharacter<CHARACTER_TYPE>> iCharacters);
}
