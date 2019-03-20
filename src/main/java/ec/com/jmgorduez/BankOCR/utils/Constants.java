package ec.com.jmgorduez.BankOCR.utils;

public class Constants {

    public static final int MATRIX_WIDTH_3 = 3;

    public static final Integer ONE = 1;
    public static final Integer TWO = 2;
    public static final Integer THREE = 3;
    public static final Integer FOUR = 4;
    public static final Integer FIVE = 5;
    public static final Integer SIX = 6;
    public static final Integer SEVEN = 7;
    public static final Integer EIGHT = 8;
    public static final Integer NINE = 9;
    public static final Integer ZERO = 0;

    public static final Integer[][] BINARY_MATRIX_ONE = new Integer[][]{
            new Integer[]{ZERO, ZERO, ZERO},
            new Integer[]{ZERO, ZERO, ONE},
            new Integer[]{ZERO, ZERO, ONE}
    };
    public static final Integer[][] BINARY_MATRIX_TWO = new Integer[][]{
            new Integer[]{ZERO, ONE, ZERO},
            new Integer[]{ZERO, ONE, ONE},
            new Integer[]{ONE, ONE, ZERO}
    };
    public static final Integer[][] BINARY_MATRIX_THREE = new Integer[][]{
            new Integer[]{ZERO, ONE, ZERO},
            new Integer[]{ZERO, ONE, ONE},
            new Integer[]{ZERO, ONE, ONE}
    };
    public static final Integer[][] BINARY_MATRIX_FOUR = new Integer[][]{
            new Integer[]{ZERO, ZERO, ZERO},
            new Integer[]{ONE, ONE, ONE},
            new Integer[]{ZERO, ZERO, ONE}
    };
    public static final Integer[][] BINARY_MATRIX_FIVE = new Integer[][]{
            new Integer[]{ZERO, ONE, ZERO},
            new Integer[]{ONE, ONE, ZERO},
            new Integer[]{ZERO, ONE, ONE}
    };
    public static final Integer[][] BINARY_MATRIX_SIX = new Integer[][]{
            new Integer[]{ZERO, ONE, ZERO},
            new Integer[]{ONE, ONE, ZERO},
            new Integer[]{ONE, ONE, ONE}
    };
    public static final Integer[][] BINARY_MATRIX_SEVEN = new Integer[][]{
            new Integer[]{ZERO, ONE, ZERO},
            new Integer[]{ZERO, ZERO, ONE},
            new Integer[]{ZERO, ZERO, ONE}
    };
    public static final Integer[][] BINARY_MATRIX_EIGHT = new Integer[][]{
            new Integer[]{ZERO, ONE, ZERO},
            new Integer[]{ONE, ONE, ONE},
            new Integer[]{ONE, ONE, ONE}
    };
    public static final Integer[][] BINARY_MATRIX_NINE = new Integer[][]{
            new Integer[]{ZERO, ONE, ZERO},
            new Integer[]{ONE, ONE, ONE},
            new Integer[]{ZERO, ZERO, ONE}
    };
    public static final Integer[][] BINARY_MATRIX_ZERO = new Integer[][]{
            new Integer[]{ZERO, ONE, ZERO},
            new Integer[]{ONE, ZERO, ONE},
            new Integer[]{ONE, ONE, ONE}
    };

    public static final int BINARY_CODE_ONE = 11;
    public static final int BINARY_CODE_TWO = 236;
    public static final int BINARY_CODE_THREE = 233;
    public static final int BINARY_CODE_FOUR = 17;
    public static final int BINARY_CODE_FIVE = 263;
    public static final int BINARY_CODE_SIX = 267;
    public static final int BINARY_CODE_SEVEN = 211;
    public static final int BINARY_CODE_EIGHT = 277;
    public static final int BINARY_CODE_NINE = 274;
    public static final int BINARY_CODE_ZERO = 257;

    public static final String BLANK_SPACE_STRING = " ";
    public static final String UNDERSCORE_STRING = "_";
    public static final String PIPE_STRING = "|";
    public static final String UNDEFINED_STRING = "UNDEFINED";
}
