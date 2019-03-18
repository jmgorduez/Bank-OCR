package ec.com.jmgorduez.BankOCR;

import ec.com.jmgorduez.BankOCR.domain.Digit;
import ec.com.jmgorduez.BankOCR.domain.abstractions.ICharacter;
import ec.com.jmgorduez.BankOCR.domain.DigitToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static ec.com.jmgorduez.BankOCR.domain.Digit.*;
import static ec.com.jmgorduez.BankOCR.domain.DigitToken.TokenType.*;
import static ec.com.jmgorduez.BankOCR.utils.Constants.*;
import static org.mockito.Mockito.mock;

public class DataTestGenerator {

    public static final int STRING_LENGTH = 9;
    public static final int MATRIX_WIDTH_27 = 27;
    public static final int MATRIX_WIDTH_3 = 3;
    public static final int MATRIX_HEIGHT_3 = 3;
    public static final int MATRIX_MODULE = MATRIX_HEIGHT_3 * MATRIX_WIDTH_3;

    public static final Digit DIGIT_ONE = new Digit(ONE);
    public static final Digit DIGIT_TWO = new Digit(TWO);
    public static final Digit DIGIT_THREE = new Digit(THREE);
    public static final Digit DIGIT_FOUR = new Digit(FOUR);
    public static final Digit DIGIT_FIVE = new Digit(FIVE);
    public static final Digit DIGIT_SIX = new Digit(SIX);
    public static final Digit DIGIT_SEVEN = new Digit(SEVEN);
    public static final Digit DIGIT_EIGHT = new Digit(EIGHT);
    public static final Digit DIGIT_NINE = new Digit(NINE);
    public static final Digit DIGIT_ZERO = new Digit(ZERO);

    public static final int BINARY_CODE_ONE = 11;
    public static final Integer[] BINARY_CODE_ONE_ARRAY = new Integer[]{0, 1, 1};
    public static final int BINARY_CODE_THREE = 233;

    public static final Integer[] ONE_BASE_TWO_ARRAY = new Integer[]{0, 0, 1};
    public static final Integer[] THREE_BASE_TWO_ARRAY = new Integer[]{0, 1, 1};
    public static final Integer[] FIVE_BASE_TWO_ARRAY = new Integer[]{1, 0, 1};

    public static DigitToken[] generateDigitTokenBlankSpaceArray() {
        return new DigitToken[]{
                new DigitToken(BLANK_SPACE),
                new DigitToken(BLANK_SPACE),
                new DigitToken(BLANK_SPACE),
                new DigitToken(BLANK_SPACE),
                new DigitToken(BLANK_SPACE),
                new DigitToken(BLANK_SPACE),
                new DigitToken(BLANK_SPACE),
                new DigitToken(BLANK_SPACE),
                new DigitToken(BLANK_SPACE)};
    }

    public static DigitToken[][] generateDigitTokenNumberOneStringMatrix(int columns, int rows) {
        DigitToken[][] digitTokens = new DigitToken[columns][rows];
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                DigitToken.TokenType tokenType = PIPE;
                if (j == 0 || i != 2) {
                    tokenType = BLANK_SPACE;
                }
                digitTokens[i][j] = new DigitToken(tokenType);
            }
        }
        return digitTokens;
    }

    public static DigitToken[][] generateDigitTokenNumberOneMatrix() {
        DigitToken[][] digitTokens = new DigitToken[][]{
                new DigitToken[]{
                        new DigitToken(BLANK_SPACE),
                        new DigitToken(BLANK_SPACE),
                        new DigitToken(BLANK_SPACE)
                },
                new DigitToken[]{
                        new DigitToken(BLANK_SPACE),
                        new DigitToken(BLANK_SPACE),
                        new DigitToken(PIPE)
                },
                new DigitToken[]{
                        new DigitToken(BLANK_SPACE),
                        new DigitToken(BLANK_SPACE),
                        new DigitToken(PIPE)
                }
        };
        return digitTokens;
    }


    public static DigitToken[][] generateDigitTokenNumberTwoMatrix() {
        DigitToken[][] digitTokens = new DigitToken[][]{
                new DigitToken[]{
                        new DigitToken(BLANK_SPACE),
                        new DigitToken(UNDERSCORE),
                        new DigitToken(BLANK_SPACE)
                },
                new DigitToken[]{
                        new DigitToken(BLANK_SPACE),
                        new DigitToken(UNDERSCORE),
                        new DigitToken(PIPE)
                },
                new DigitToken[]{
                        new DigitToken(PIPE),
                        new DigitToken(UNDERSCORE),
                        new DigitToken(BLANK_SPACE)
                }
        };
        return digitTokens;
    }

    public static DigitToken[][] generateDigitTokenNumberThreeMatrix() {
        DigitToken[][] digitTokens = new DigitToken[][]{
                new DigitToken[]{
                        new DigitToken(BLANK_SPACE),
                        new DigitToken(UNDERSCORE),
                        new DigitToken(BLANK_SPACE)
                },
                new DigitToken[]{
                        new DigitToken(BLANK_SPACE),
                        new DigitToken(UNDERSCORE),
                        new DigitToken(PIPE)
                },
                new DigitToken[]{
                        new DigitToken(BLANK_SPACE),
                        new DigitToken(UNDERSCORE),
                        new DigitToken(PIPE)
                }
        };
        return digitTokens;
    }

    public static DigitToken[][] generateDigitTokenNumberFourMatrix() {
        DigitToken[][] digitTokens = new DigitToken[][]{
                new DigitToken[]{
                        new DigitToken(BLANK_SPACE),
                        new DigitToken(BLANK_SPACE),
                        new DigitToken(BLANK_SPACE)
                },
                new DigitToken[]{
                        new DigitToken(PIPE),
                        new DigitToken(UNDERSCORE),
                        new DigitToken(PIPE)
                },
                new DigitToken[]{
                        new DigitToken(BLANK_SPACE),
                        new DigitToken(BLANK_SPACE),
                        new DigitToken(PIPE)
                }
        };
        return digitTokens;
    }

    public static DigitToken[][] generateDigitTokenNumberFiveMatrix() {
        DigitToken[][] digitTokens = new DigitToken[][]{
                new DigitToken[]{
                        new DigitToken(BLANK_SPACE),
                        new DigitToken(UNDERSCORE),
                        new DigitToken(BLANK_SPACE)
                },
                new DigitToken[]{
                        new DigitToken(PIPE),
                        new DigitToken(UNDERSCORE),
                        new DigitToken(BLANK_SPACE)
                },
                new DigitToken[]{
                        new DigitToken(BLANK_SPACE),
                        new DigitToken(UNDERSCORE),
                        new DigitToken(PIPE)
                }
        };
        return digitTokens;
    }

    public static DigitToken[][] generateDigitTokenNumberSixMatrix() {
        DigitToken[][] digitTokens = new DigitToken[][]{
                new DigitToken[]{
                        new DigitToken(BLANK_SPACE),
                        new DigitToken(UNDERSCORE),
                        new DigitToken(BLANK_SPACE)
                },
                new DigitToken[]{
                        new DigitToken(PIPE),
                        new DigitToken(UNDERSCORE),
                        new DigitToken(BLANK_SPACE)
                },
                new DigitToken[]{
                        new DigitToken(PIPE),
                        new DigitToken(UNDERSCORE),
                        new DigitToken(PIPE)
                }
        };
        return digitTokens;
    }

    public static DigitToken[][] generateDigitTokenNumberSevenMatrix() {
        DigitToken[][] digitTokens = new DigitToken[][]{
                new DigitToken[]{
                        new DigitToken(BLANK_SPACE),
                        new DigitToken(UNDERSCORE),
                        new DigitToken(BLANK_SPACE)
                },
                new DigitToken[]{
                        new DigitToken(BLANK_SPACE),
                        new DigitToken(BLANK_SPACE),
                        new DigitToken(PIPE)
                },
                new DigitToken[]{
                        new DigitToken(BLANK_SPACE),
                        new DigitToken(BLANK_SPACE),
                        new DigitToken(PIPE)
                }
        };
        return digitTokens;
    }

    public static DigitToken[][] generateDigitTokenNumberEightMatrix() {
        DigitToken[][] digitTokens = new DigitToken[][]{
                new DigitToken[]{
                        new DigitToken(BLANK_SPACE),
                        new DigitToken(UNDERSCORE),
                        new DigitToken(BLANK_SPACE)
                },
                new DigitToken[]{
                        new DigitToken(PIPE),
                        new DigitToken(UNDERSCORE),
                        new DigitToken(PIPE)
                },
                new DigitToken[]{
                        new DigitToken(PIPE),
                        new DigitToken(UNDERSCORE),
                        new DigitToken(PIPE)
                }
        };
        return digitTokens;
    }

    public static DigitToken[][] generateDigitTokenNumberNineMatrix() {
        DigitToken[][] digitTokens = new DigitToken[][]{
                new DigitToken[]{
                        new DigitToken(BLANK_SPACE),
                        new DigitToken(UNDERSCORE),
                        new DigitToken(BLANK_SPACE)
                },
                new DigitToken[]{
                        new DigitToken(PIPE),
                        new DigitToken(UNDERSCORE),
                        new DigitToken(PIPE)
                },
                new DigitToken[]{
                        new DigitToken(BLANK_SPACE),
                        new DigitToken(BLANK_SPACE),
                        new DigitToken(PIPE)
                }
        };
        return digitTokens;
    }

    public static DigitToken[][] generateDigitTokenNumberZeroMatrix() {
        DigitToken[][] digitTokens = new DigitToken[][]{
                new DigitToken[]{
                        new DigitToken(BLANK_SPACE),
                        new DigitToken(UNDERSCORE),
                        new DigitToken(BLANK_SPACE)
                },
                new DigitToken[]{
                        new DigitToken(PIPE),
                        new DigitToken(BLANK_SPACE),
                        new DigitToken(PIPE)
                },
                new DigitToken[]{
                        new DigitToken(PIPE),
                        new DigitToken(UNDERSCORE),
                        new DigitToken(PIPE)
                }
        };
        return digitTokens;
    }

    public static List<ICharacter<Integer>> generateListNumbersOne() {
        List<ICharacter<Integer>> digits = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            digits.add(new Digit(new Integer(ONE)));
        }
        return digits;
    }
}
