package ec.com.jmgorduez.BankOCR.domain.tokens;

public enum TokenLevel {
    ONE(1),
    TWO(2),
    THREE(3);
    private final Integer value;

    private TokenLevel(Integer value){
        this.value = value;
    }

    public Integer getValue(){
        return this.value;
    }
}
