package ec.com.jmgorduez.BankOCR.dataGenerator;

import ec.com.jmgorduez.BankOCR.domain.IntegerAccountNumber;
import ec.com.jmgorduez.BankOCR.domain.Digit;
import ec.com.jmgorduez.BankOCR.domain.abstractions.IAccountNumber;
import ec.com.jmgorduez.BankOCR.domain.abstractions.ICharacter;
import ec.com.jmgorduez.BankOCR.domain.DigitToken;
import ec.com.jmgorduez.BankOCR.domain.abstractions.IToken;
import ec.com.jmgorduez.BankOCR.domain.MultilineString;
import ec.com.jmgorduez.BankOCR.domain.abstractions.IMultilineString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ec.com.jmgorduez.BankOCR.domain.DigitToken.TokenType.*;
import static ec.com.jmgorduez.BankOCR.utils.Constants.*;
import static org.mockito.Mockito.mock;

public class DataTestGenerator {

    public static final String Null_STRING = null;
    public static final String EMPTY_STRING = "";

    public static final String BLANK_SPACE_STRING_27    = "                           ";
    public static final String PIPE_STRING_27           = "|||||||||||||||||||||||||||";
    public static final String UNDER_SCORE_STRING_27    = "___________________________";

    public static final String STRING_ACCOUNT_NUMBER_000000000 = "000000000";
    public static final String STRING_ACCOUNT_NUMBER_111111111 = "111111111";
    public static final String STRING_ACCOUNT_NUMBER_123456789 = "123456789";

    public static final IAccountNumber ACCOUNT_NUMBER_000000000
            = new IntegerAccountNumber(STRING_ACCOUNT_NUMBER_000000000);
    public static final IAccountNumber ACCOUNT_NUMBER_111111111
            = new IntegerAccountNumber(STRING_ACCOUNT_NUMBER_111111111);

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

    public static final int WRONG_BINARY_CODE = -1;

    public static final Integer[][] BINARY_MATRIX_UNDEFINED_CHARACTER = new Integer[][]{
            new Integer[]{ONE, ONE, ONE},
            new Integer[]{ONE, ZERO, ONE},
            new Integer[]{ONE, ONE, ONE}
    };

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
        digitTokens = new DigitToken[]{
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
        digitTokens = new DigitToken[]{
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
        digitTokens = new DigitToken[]{
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

    public static IMultilineString<IToken<DigitToken.TokenType>> generateDigitTokenNumberZeroMatrix() {
        IMultilineString<IToken<DigitToken.TokenType>> multilineString = new MultilineString<>(MATRIX_WIDTH_3);
        DigitToken[] digitTokens = new DigitToken[]{
                new DigitToken(BLANK_SPACE),
                new DigitToken(UNDERSCORE),
                new DigitToken(BLANK_SPACE)
        };
        multilineString.add(Arrays.asList(digitTokens));
        digitTokens = new DigitToken[]{
                new DigitToken(PIPE),
                new DigitToken(BLANK_SPACE),
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

    public static IMultilineString<IToken<DigitToken.TokenType>> generateDigitTokenUndefidedCharacterMatrix() {
        IMultilineString<IToken<DigitToken.TokenType>> multilineString = new MultilineString<>(MATRIX_WIDTH_3);
        DigitToken[] digitTokens = new DigitToken[]{
                new DigitToken(PIPE),
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
        digitTokens = new DigitToken[]{
                new DigitToken(BLANK_SPACE),
                new DigitToken(BLANK_SPACE),
                new DigitToken(PIPE)
        };
        multilineString.add(Arrays.asList(digitTokens));
        return multilineString;
    }

    public static List<ICharacter<Integer>> generateListSameDigits(Integer integerDigit) {
      Stream<Digit> stream = Stream.generate(
                () -> new Digit(new Integer(integerDigit))).limit(NINE);
        return stream.collect(Collectors.toList());
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

    public static List<IToken<DigitToken.TokenType>> generateListTokens(DigitToken.TokenType tokenType, Integer length) {
        Stream<DigitToken> stream = Stream.generate(
                () -> new DigitToken(tokenType)).limit(length);
        return stream.collect(Collectors.toList());
    }

    public static List<IToken<DigitToken.TokenType>> generateListTokensFirstLineDigitOne() {
        return generateListTokens(BLANK_SPACE, MATRIX_WIDTH_3);
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
