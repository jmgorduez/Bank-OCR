package ec.com.jmgorduez.BankOCR.domain.abstractions;

import java.util.List;

public interface IAccountNumberReader<TOKEN_TYPE extends Enum, NUMBER_TYPE> {
    IAccountNumber<NUMBER_TYPE> readAccountNumber(List<ICharacter<NUMBER_TYPE>> iCharacters);
}
