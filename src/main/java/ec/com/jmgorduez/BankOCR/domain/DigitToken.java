package ec.com.jmgorduez.BankOCR.domain;

import ec.com.jmgorduez.BankOCR.domain.abstractions.IToken;

import java.util.Objects;

public class DigitToken implements IToken<DigitToken.TokenType> {

    public static final String BLANK_SPACE = " ";
    public static final String UNDERSCORE = "_";
    public static final String PIPE = "|";
    public static final String UNDEFINED = null;

    public enum TokenType{
        BLANK_SPACE(DigitToken.BLANK_SPACE, Boolean.FALSE),
        UNDERSCORE(DigitToken.UNDERSCORE, Boolean.TRUE),
        PIPE(DigitToken.PIPE, Boolean.TRUE),
        UNDEFINED(DigitToken.UNDEFINED, Boolean.TRUE);

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
