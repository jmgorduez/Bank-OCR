package ec.com.jmgorduez.BankOCR.domain.abstractions;

public interface IToken<T extends Enum> {
    T getValue();
    boolean isVisible();
}
