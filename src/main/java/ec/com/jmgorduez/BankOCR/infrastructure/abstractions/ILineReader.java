package ec.com.jmgorduez.BankOCR.infrastructure.abstractions;

import ec.com.jmgorduez.BankOCR.domain.abstractions.IToken;

import java.util.List;

public interface ILineReader<T extends Enum> {
    List<IToken<T>> readLine();
}
