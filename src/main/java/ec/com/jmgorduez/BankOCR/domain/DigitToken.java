package ec.com.jmgorduez.BankOCR.domain;

import ec.com.jmgorduez.BankOCR.domain.abstractions.IToken;

import java.util.Objects;

import static ec.com.jmgorduez.BankOCR.utils.Constants.*;

public class DigitToken implements IToken<DigitToken.TokenType> {

    public enum TokenType{
        BLANK_SPACE(BLANK_SPACE_STRING, Boolean.FALSE),
        UNDERSCORE(UNDERSCORE_STRING, Boolean.TRUE),
        PIPE(PIPE_STRING, Boolean.TRUE),
        UNDEFINED(UNDEFINED_STRING, Boolean.TRUE);

        private final String value;
        private final boolean isVisible;

        private TokenType(String value, boolean isVisible){
            this.value = value;
            this.isVisible = isVisible;
        }

        public static TokenType parse(String value){
            switch (value) {
                case " ":
                    return BLANK_SPACE;
                case "|":
                    return PIPE;
                case "_":
                    return UNDERSCORE;
                default:
                    return UNDEFINED;
            }
        }

        public String getValue(){
            return value;
        }

        public boolean isVisible(){
            return this.isVisible;
        }
    }

    private final TokenType value;

    public DigitToken(String value) {
        this.value = TokenType.parse(value);
    }

    public DigitToken(TokenType value) {
        this.value = value;
    }

    @Override
    public TokenType getValue() {
        return this.value;
    }

    @Override
    public boolean isVisible() {
        return value.isVisible();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof DigitToken)) {
            return false;
        }
        return ((DigitToken) other).value.getValue().equals(this.value.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.value);
    }
}
