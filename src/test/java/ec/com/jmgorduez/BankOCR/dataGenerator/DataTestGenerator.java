package ec.com.jmgorduez.BankOCR.dataGenerator;

import ec.com.jmgorduez.BankOCR.domain.*;
import ec.com.jmgorduez.BankOCR.domain.abstractions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ec.com.jmgorduez.BankOCR.domain.DigitToken.TokenType.*;
import static ec.com.jmgorduez.BankOCR.utils.Constants.*;

public class DataTestGenerator {

    public static final UndefinedDigit UNDEFINED_CHARACTER = new UndefinedDigit(WRONG_BINARY_MATRIX);

    public static final String NULL_STRING = null;

    public static final String BLANK_SPACE_STRING_27 = "                           ";
    public static final String PIPE_STRING_27 = "|||||||||||||||||||||||||||";
    public static final String UNDER_SCORE_STRING_27 = "___________________________";

    public static final String STRING_ACCOUNT_NUMBER_000000000 = "000000000";
    public static final String STRING_ACCOUNT_NUMBER_111111111 = "111111111";
    public static final String STRING_ACCOUNT_NUMBER_123456789 = "123456789";
    public static final String STRING_ACCOUNT_NUMBER_345882865 = "345882865";
    public static final String STRING_ACCOUNT_NUMBER_49006771_ = "49006771?";
    public static final String STRING_ACCOUNT_NUMBER_490067714 = "490067714";

    public static final List<ICharacter> CHARACTERS_ACCOUNT_NUMBER_000000000
            = generateListDigitFromIntegerArray(new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0});
    public static final List<ICharacter> CHARACTERS_ACCOUNT_NUMBER_111111111
            = generateListDigitFromIntegerArray(new Integer[]{1, 1, 1, 1, 1, 1, 1, 1, 1});
    public static final List<ICharacter> CHARACTERS_ACCOUNT_NUMBER_123456789
            = generateListDigitFromIntegerArray(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
    public static final List<ICharacter> CHARACTERS_ACCOUNT_NUMBER_49006771_
            = generateListDigitFromIntegerArray(new Integer[]{4, 9, 0, 0, 6, 7, 7, 1, -1},
            generateUndefinedCharacterSimilarDigitNine());
    public static final List<ICharacter> CHARACTERS_ACCOUNT_NUMBER_490067719
            = generateListDigitFromIntegerArray(new Integer[]{4, 9, 0, 0, 6, 7, 7, 1, 9});
    public static final List<ICharacter> CHARACTERS_ACCOUNT_NUMBER_345882865
            = generateListDigitFromIntegerArray(new Integer[]{3, 4, 5, 8, 8, 2, 8, 6, 5});

    public static final AccountNumber ACCOUNT_NUMBER_000000000
            = new AccountNumber(CHARACTERS_ACCOUNT_NUMBER_000000000);
    public static final AccountNumber ACCOUNT_NUMBER_111111111
            = new AccountNumber(CHARACTERS_ACCOUNT_NUMBER_111111111);
    public static final AccountNumber ACCOUNT_NUMBER_123456789
            = new AccountNumber(CHARACTERS_ACCOUNT_NUMBER_123456789);
    public static final AccountNumber ACCOUNT_NUMBER_49006771_
            = new AccountNumber(CHARACTERS_ACCOUNT_NUMBER_49006771_);
    public static final AccountNumber ACCOUNT_NUMBER_490067719
            = new AccountNumber(CHARACTERS_ACCOUNT_NUMBER_490067719);
    public static final AccountNumber ACCOUNT_NUMBER_345882865
            = new AccountNumber(CHARACTERS_ACCOUNT_NUMBER_345882865);

    public static final Integer CHECK_SUM_111111111 = 45;
    public static final Integer CHECK_SUM_123456789 = 165;
    public static final Integer CHECK_SUM_345882865 = 231;

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

    public static final int WRONG_BINARY_CODE = 757;

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
                new DigitToken(UNDERSCORE),
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

    public static List<ICharacter> generateListSameDigits(Integer integerDigit) {
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

    public static List<ICharacter> generateListDigitOneSimilarCharacters() {
        List<ICharacter> similarCharacters = new ArrayList<>();
        similarCharacters.add(DIGIT_SEVEN);
        return similarCharacters;
    }

    public static List<ICharacter> generateListDigitSevenSimilarCharacters() {
        List<ICharacter> similarCharacters = new ArrayList<>();
        similarCharacters.add(DIGIT_ONE);
        return similarCharacters;
    }

    public static List<ICharacter> generateListDigitEightSimilarCharacters() {
        List<ICharacter> similarCharacters = new ArrayList<>();
        similarCharacters.add(DIGIT_ZERO);
        similarCharacters.add(DIGIT_SIX);
        similarCharacters.add(DIGIT_NINE);
        return similarCharacters;
    }

    public static List<ICharacter> generateListDigitNineSimilarCharacters() {
        List<ICharacter> similarCharacters = new ArrayList<>();
        similarCharacters.add(DIGIT_THREE);
        similarCharacters.add(DIGIT_FIVE);
        similarCharacters.add(DIGIT_EIGHT);
        return similarCharacters;
    }

    public static List<ICharacter> generateListDigitZeroSimilarCharacters() {
        List<ICharacter> similarCharacters = new ArrayList<>();
        similarCharacters.add(DIGIT_EIGHT);
        return similarCharacters;
    }

    public static List<ICharacter> generateListDigitFiveSimilarCharacters() {
        List<ICharacter> similarCharacters = new ArrayList<>();
        similarCharacters.add(DIGIT_NINE);
        similarCharacters.add(DIGIT_SIX);
        return similarCharacters;
    }

    public static List<ICharacter> generateListDigitSixSimilarCharacters() {
        List<ICharacter> similarCharacters = new ArrayList<>();
        similarCharacters.add(DIGIT_EIGHT);
        similarCharacters.add(DIGIT_FIVE);
        return similarCharacters;
    }

    public static List<ICharacter> generateListUndefinedCharacterSimilarDigitNineSimilarCharacters() {
        List<ICharacter> similarCharacters = new ArrayList<>();
        similarCharacters.add(DIGIT_NINE);
        return similarCharacters;
    }

    public static List<ICharacter> generateListDigitFromIntegerArray(Integer[] integers,
                                                                              ICharacter... undefinedCharacter) {
        List<ICharacter> characters =
                Arrays.stream(integers).map(integer -> {
                    if (integer.equals(UNDEFINED_DIGIT_VALUE)) {
                        return undefinedCharacter[0];
                    }
                    return new Digit(integer);
                }).collect(Collectors.toList());
        return characters;
    }

    public static ICharacter generateUndefinedCharacterSimilarDigitNine() {
        Integer[][] binaryMatrixDigitSimilarZero = new Integer[][]{
                new Integer[]{ZERO, ONE, ZERO},
                new Integer[]{ONE, ONE, ONE},
                new Integer[]{ZERO, ONE, ZERO}
        };
        return new UndefinedDigit(binaryMatrixDigitSimilarZero);
    }

    public static final String FILE_PATH_111111111 = FILE_PATH + "input111111111.txt";
    public static final String FILE_PATH_123456789 = FILE_PATH + "input123456789.txt";
    public static final String FILE_PATH_49006771_ = FILE_PATH + "input49006771_.txt";
    public static final String FILE_PATH_MAIN = FILE_PATH + "input.txt";
    public static IMultilineStringReader multilineStringReader;
    public static ILineReader<DigitToken.TokenType> lineReader;
    public static IMultilineCharacterReader< DigitToken.TokenType> multilineCharacterReader;
    public static IAccountNumberReader<DigitToken.TokenType> accountNumberReader;

    public static List<IAccountNumber<AccountNumber.IntegerAccountNumberClassification>> generateWrongAccountNumber49006771_(){
        return Stream.generate(() -> {
            return ACCOUNT_NUMBER_49006771_;
        }).limit(ONE).collect(Collectors.toList());
    }
}
