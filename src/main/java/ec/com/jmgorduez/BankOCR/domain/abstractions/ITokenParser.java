package ec.com.jmgorduez.BankOCR.domain.abstractions;

public interface ITokenParser {
    IToken parse(String tokenString);
}
