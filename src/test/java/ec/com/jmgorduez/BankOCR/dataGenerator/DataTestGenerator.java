package ec.com.jmgorduez.BankOCR;

import ec.com.jmgorduez.BankOCR.domain.Digit;
import ec.com.jmgorduez.BankOCR.domain.abstractions.ICharacter;
import ec.com.jmgorduez.BankOCR.domain.DigitToken;
import ec.com.jmgorduez.BankOCR.domain.abstractions.IToken;
import ec.com.jmgorduez.BankOCR.infrastructure.MultilineString;
import ec.com.jmgorduez.BankOCR.infrastructure.abstractions.IMultilineString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static ec.com.jmgorduez.BankOCR.domain.Digit.*;
import static ec.com.jmgorduez.BankOCR.domain.DigitToken.TokenType.*;
import static ec.com.jmgorduez.BankOCR.utils.Constants.*;
import static org.mockito.Mockito.mock;

public class DataTestGenerator {

    public static final String BLANK_SPACE_STRING_27 = "                           ";

    public static final int STRING_LENGTH = 9;
    public static final int MATRIX_WIDTH_27 = 27;
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

    public static final Integer[] BINARY_CODE_ONE_ARRAY = new Integer[]{0, 1, 1};

    public static final Integer[] ONE_BASE_TWO_ARRAY = new Integer[]{0, 0, 1};
    public static final Integer[] THREE_BASE_TWO_ARRAY = new Integer[]{0, 1, 1};
    public static final Integer[] FIVE_BASE_TWO_ARRAY = new Integer[]{1, 0, 1};

    public static List<IToken<DigitToken.TokenType>> generateLineWithTwentySevenBlankSpaceDigitToken() {
        List<IToken<DigitToken.TokenType>> line = new ArrayList<>();
        for (int i = ONE; i <= MATRIX_WIDTH_27; i++) {
            line.add(new DigitToken(BLANK_SPACE));
        }
        return line;
    }

    public static IMultilineString<IToken<DigitToken.TokenType>> generateDigitTokenNumberOneMatrix() {
        IMultilineString<IToken<DigitToken.TokenType>> multilineString = new MultilineString<>(MATRIX_WIDTH_3);
        DigitToken[] digitTokens = new DigitToken[]{
                new DigitToken(BLANK_SPACE),
                new DigitToken(BLANK_SPACE),
                new DigitToken(BLANK_SPACE)
        };
        multilineString.add(Arrays.asList(digitTokens));
        digitTokens = new DigitToken[]{
                new DigitToken(BLANK_SPACE),
                new DigitToken(BLANK_SPACE),
                new DigitToken(PIPE)
        };
        multilineString.add(Arrays.asList(digitTokens));
        digitTokens = new DigitToken[]{
                new DigitToken(BLANK_SPACE),
                new DigitToken(BLANK_SPACE),
                new DigitToken(PIPE)
        };
        multilineString.add(Arrays.asList(digitTokens));
        return multilineString;
    }


    public static IMultilineString<IToken<DigitToken.TokenType>> generateDigitTokenNumberTwoMatrix() {
        IMultilineString<IToken<DigitToken.TokenType>> multilineString = new MultilineString<>(MATRIX_WIDTH_3);
        DigitToken[] digitTokens = new DigitToken[]{
                new DigitToken(BLANK_SPACE),
                new DigitToken(UNDERSCORE),
                new DigitToken(BLANK_SPACE)
        };
        multilineString.add(Arrays.asList(digitTokens));
        digitTokens = new DigitToken[]{
                new DigitToken(BLANK_SPACE),
                new DigitToken(UNDERSCORE),
                new DigitToken(PIPE)
        };
        multilineString.add(Arrays.asList(digitTokens));
        digitTokens = new DigitToken[]{
                new DigitToken(PIPE),
                new DigitToken(UNDERSCORE),
                new DigitToken(BLANK_SPACE)
        };
        multilineString.add(Arrays.asList(digitTokens));
        return multilineString;
    }


    public static IMultilineString<IToken<DigitToken.TokenType>> generateDigitTokenNumberThreeMatrix() {
        IMultilineString<IToken<DigitToken.TokenType>> multilineString = new MultilineString<>(MATRIX_WIDTH_3);
        DigitToken[] digitTokens = new DigitToken[]{
                new DigitToken(BLANK_SPACE),
                new DigitToken(UNDERSCORE),
                new DigitToken(BLANK_SPACE)
        };
        multilineString.add(Arrays.asList(digitTokens));
        digitTokens = new DigitToken[]{
                new DigitToken(BLANK_SPACE),
                new DigitToken(UNDERSCORE),
                new DigitToken(PIPE)
        };
        multilineString.add(Arrays.asList(digitTokens));
        digitTokens = new DigitToken[]{
                new DigitToken(BLANK_SPACE),
                new DigitToken(UNDERSCORE),
                new DigitToken(PIPE)
        };
        multilineString.add(Arrays.asList(digitTokens));
        return multilineString;
    }


    public static IMultilineString<IToken<DigitToken.TokenType>> generateDigitTokenNumberFourMatrix() {
        IMultilineString<IToken<DigitToken.TokenType>> multilineString = new MultilineString<>(MATRIX_WIDTH_3);
        DigitToken[] digitTokens = new DigitToken[]{
                new DigitToken(BLANK_SPACE),
                new DigitToken(BLANK_SPACE),
                new DigitToken(BLANK_SPACE)
        };
        multilineString.add(Arrays.asList(digitTokens));
        digitTokens = new DigitToken[]{
                new DigitToken(PIPE),
                new DigitToken(UNDERSCORE),
                new DigitToken(PIPE)
        };
        multilineString.add(Arrays.asList(digitTokens));
        digitTokens = new DigitToken[]{
                new DigitToken(BLANK_SPACE),
                new DigitToken(BLANK_SPACE),
                new DigitToken(PIPE)
        };
        multilineString.add(Arrays.asList(digitTokens));
        return multilineString;
    }


    public static IMultilineString<IToken<DigitToken.TokenType>> generateDigitTokenNumberFiveMatrix() {
        IMultilineString<IToken<DigitToken.TokenType>> multilineString = new MultilineString<>(MATRIX_WIDTH_3);
        DigitToken[] digitTokens = new DigitToken[]{
                new DigitToken(BLANK_SPACE),
                new DigitToken(UNDERSCORE),
                new DigitToken(BLANK_SPACE)
        };
        multilineString.add(Arrays.asList(digitTokens));
        digitTokens = new DigitToken[]{
                new DigitToken(PIPE),
                new DigitToken(UNDERSCORE),
                new DigitToken(BLANK_SPACE)
        };
        multilineString.add(Arrays.asList(digitTokens));
        digitTokens =  new DigitToken[]{
                new DigitToken(BLANK_SPACE),
                new DigitToken(UNDERSCORE),
                new DigitToken(PIPE)
        };
        multilineString.add(Arrays.asList(digitTokens));
        return multilineString;
    }

    public static IMultilineString<IToken<DigitToken.TokenType>> generateDigitTokenNumberSixMatrix() {
        IMultilineString<IToken<DigitToken.TokenType>> multilineString = new MultilineString<>(MATRIX_WIDTH_3);
        DigitToken[] digitTokens = new DigitToken[]{
                new DigitToken(BLANK_SPACE),
                new DigitToken(UNDERSCORE),
                new DigitToken(BLANK_SPACE)
        };
        multilineString.add(Arrays.asList(digitTokens));
        digitTokens = new DigitToken[]{
                new DigitToken(PIPE),
                new DigitToken(UNDERSCORE),
                new DigitToken(BLANK_SPACE)
        };
        multilineString.add(Arrays.asList(digitTokens));
        digitTokens =  new DigitToken[]{
                new DigitToken(PIPE),
                new DigitToken(UNDERSCORE),
                new DigitToken(PIPE)
        };
        multilineString.add(Arrays.asList(digitTokens));
        return multilineString;
    }

    public static IMultilineString<IToken<DigitToken.TokenType>> generateDigitTokenNumberSevenMatrix() {
        IMultilineString<IToken<DigitToken.TokenType>> multilineString = new MultilineString<>(MATRIX_WIDTH_3);
        DigitToken[] digitTokens = new DigitToken[]{
                new DigitToken(BLANK_SPACE),
                new DigitToken(UNDERSCORE),
                new DigitToken(BLANK_SPACE)
        };
        multilineString.add(Arrays.asList(digitTokens));
        digitTokens = new DigitToken[]{
                new DigitToken(BLANK_SPACE),
                new DigitToken(BLANK_SPACE),
                new DigitToken(PIPE)
        };
        multilineString.add(Arrays.asList(digitTokens));
        digitTokens = new DigitToken[]{
                new DigitToken(BLANK_SPACE),
                new DigitToken(BLANK_SPACE),
                new DigitToken(PIPE)
        };
        multilineString.add(Arrays.asList(digitTokens));
        return multilineString;
    }

    public static IMultilineString<IToken<DigitToken.TokenType>> generateDigitTokenNumberEightMatrix() {
        IMultilineString<IToken<DigitToken.TokenType>> multilineString = new MultilineString<>(MATRIX_WIDTH_3);
        DigitToken[] digitTokens = new DigitToken[]{
                new DigitToken(BLANK_SPACE),
                new DigitToken(UNDERSCORE),
                new DigitToken(BLANK_SPACE)
        };
        multilineString.add(Arrays.asList(digitTokens));
        digitTokens =  new DigitToken[]{
                new DigitToken(PIPE),
                new DigitToken(UNDERSCORE),
                new DigitToken(PIPE)
        };
        multilineString.add(Arrays.asList(digitTokens));
        digitTokens = new DigitToken[]{
                new DigitToken(PIPE),
                new DigitToken(UNDERSCORE),
                new DigitToken(PIPE)
        };
        multilineString.add(Arrays.asList(digitTokens));
        return multilineString;
    }

    public static IMultilineString<IToken<DigitToken.TokenType>> generateDigitTokenNumberNineMatrix() {
        IMultilineString<IToken<DigitToken.TokenType>> multilineString = new MultilineString<>(MATRIX_WIDTH_3);
        DigitToken[] digitTokens = new DigitToken[]{
                new DigitToken(BLANK_SPACE),
                new DigitToken(UNDERSCORE),
                new DigitToken(BLANK_SPACE)
        };
        multilineString.add(Arrays.asList(digitTokens));
        digitTokens =   new DigitToken[]{
                new DigitToken(PIPE),
                new DigitToken(UNDERSCORE),
                new DigitToken(PIPE)
        };
        multilineString.add(Arrays.asList(digitTokens));
        digitTokens =  new DigitToken[]{
                new DigitToken(BLANK_SPACE),
                new DigitToken(BLANK_SPACE),
                new DigitToken(PIPE)
        };
        multilineString.add(Arrays.asList(digitTokens));
        return multilineString;
    }

    public static IMultilineString<IToken<DigitToken.TokenType>> generateDigitTokenNumberZeroMatrix() {
        IMultilineString<IToken<DigitToken.TokenType>> multilineString = new MultilineString<>(MATRIX_WIDTH_3);
        DigitToken[] digitTokens = new DigitToken[]{
                new DigitToken(BLANK_SPACE),
                new DigitToken(UNDERSCORE),
                new DigitToken(BLANK_SPACE)
        };
        multilineString.add(Arrays.asList(digitTokens));
        digitTokens =   new DigitToken[]{
                new DigitToken(PIPE),
                new DigitToken(BLANK_SPACE),
                new DigitToken(PIPE)
        };
        multilineString.add(Arrays.asList(digitTokens));
        digitTokens =  new DigitToken[]{
                new DigitToken(PIPE),
                new DigitToken(UNDERSCORE),
                new DigitToken(PIPE)
        };
        multilineString.add(Arrays.asList(digitTokens));
        return multilineString;
    }

    public static List<ICharacter<Integer>> generateListDigitsOne() {
        List<ICharacter<Integer>> digits = new ArrayList<>();
        for (int i = ZERO; i < NINE; i++) {
            digits.add(new Digit(new Integer(ONE)));
        }
        return digits;
    }

    public static List<List<IToken<DigitToken.TokenType>>> generateThreeRowsWithTwentySevenTokensThatRepresentsDigitOneMutilineString() {
        List<List<IToken<DigitToken.TokenType>>> rows = new ArrayList<>();
        for (int i = ONE; i <= MATRIX_HEIGHT_3; i++) {
            List<IToken<DigitToken.TokenType>> line = new ArrayList<>();
            for (int j = ONE; j <= MATRIX_WIDTH_27; j++) {
                if (i == ONE || j % THREE != ZERO) {
                    line.add(new DigitToken(DigitToken.TokenType.BLANK_SPACE));
                } else {
                    line.add(new DigitToken(DigitToken.TokenType.PIPE));
                }
            }
            rows.add(line);
        }
        return rows;
    }

    public static List<IToken<DigitToken.TokenType>> generateListTokensBlankSpace(Integer length) {
        List<IToken<DigitToken.TokenType>> list = new ArrayList<>();
        for (int i = ONE; i <= length; i++) {
            list.add(new DigitToken(BLANK_SPACE));
        }
        return list;
    }

    public static List<IToken<DigitToken.TokenType>> generateListTokensFirstLineDigitOne() {
        return generateListTokensBlankSpace(MATRIX_WIDTH_3);
    }

    public static List<IToken<DigitToken.TokenType>> generateListTokensSecondLineDigitOne() {
        DigitToken[] tokens = new DigitToken[]{
                new DigitToken(BLANK_SPACE),
                new DigitToken(BLANK_SPACE),
                new DigitToken(PIPE),
        };
        return Arrays.asList(tokens);
    }

    public static List<IToken<DigitToken.TokenType>> generateListTokensThirdLineDigitOne() {
        return generateListTokensSecondLineDigitOne();
    }

    public static MultilineString<IToken<DigitToken.TokenType>> multilineThatRepresentsDigitOne() {
        MultilineString<IToken<DigitToken.TokenType>> character = new MultilineString<>(MATRIX_WIDTH_3);
        character.add(generateListTokensFirstLineDigitOne());
        character.add(generateListTokensSecondLineDigitOne());
        character.add(generateListTokensThirdLineDigitOne());
        return character;
    }
}
