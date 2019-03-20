package ec.com.jmgorduez.BankOCR.infrastructure;

import ec.com.jmgorduez.BankOCR.domain.DigitToken;
import ec.com.jmgorduez.BankOCR.domain.abstractions.IToken;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static ec.com.jmgorduez.BankOCR.dataGenerator.DataTestGenerator.*;
import static ec.com.jmgorduez.BankOCR.utils.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;

class MultilineStringTest {

    private MultilineString<IToken<DigitToken.TokenType>> multilineStringUnderTest;

    void setUp() {
        multilineStringUnderTest = new MultilineString<>(MATRIX_WIDTH_3);
        List<List<IToken<DigitToken.TokenType>>> lines = generateThreeRowsWithTwentySevenTokensThatRepresentsDigitOneMutilineString();
        lines.stream().forEach(line -> {
            multilineStringUnderTest.add(line);
        });
    }

    @Test
    @DisplayName("It should add a line at the list of multiline.")
    void add() {
        multilineStringUnderTest = new MultilineString<>(MATRIX_WIDTH_3);
        multilineStringUnderTest.add(
                generateListTokensBlankSpace(MATRIX_WIDTH_27));
        List<List<IToken<DigitToken.TokenType>>> listExpected = new ArrayList<>();
        listExpected.add(generateListTokensBlankSpace(MATRIX_WIDTH_27));
        assertThat(multilineStringUnderTest.rows())
                .isEqualTo(listExpected);
        listExpected.add(generateListTokensBlankSpace(MATRIX_WIDTH_27));
        assertThat(multilineStringUnderTest.rows())
                .isNotEqualTo(listExpected);
    }

    @Test
    @DisplayName("It should return how many horizontal cells take a character")
    void getCharacterWidth() {
        setUp();
        assertThat(multilineStringUnderTest.characterWidth())
                .isEqualTo(MATRIX_WIDTH_3);
    }

    @Test
    @DisplayName("It should return the character section of a index")
    void getCharacterSection() {
        setUp();
        assertThat(multilineStringUnderTest.getCharacterSection(ZERO))
                .isEqualTo(multilineThatRepresentsDigitOne());
    }

    @Test
    @DisplayName("It should return if the multiline is equal to other")
    void equals() {
        setUp();
        assertThat(multilineStringUnderTest.equals(multilineStringUnderTest))
                .isTrue();
        MultilineString<IToken<DigitToken.TokenType>> otherMultiline = new MultilineString<>(MATRIX_WIDTH_3);
        List<List<IToken<DigitToken.TokenType>>> lines = generateThreeRowsWithTwentySevenTokensThatRepresentsDigitOneMutilineString();
        lines.stream().forEach(line -> {
            otherMultiline.add(line);
        });
        assertThat(multilineStringUnderTest.equals(otherMultiline))
                .isTrue();
        assertThat(multilineStringUnderTest.equals(this))
                .isFalse();
    }

    @Test
    @DisplayName("It should return number of line of a multiline string")
    void lineCount() {
        setUp();
        assertThat(multilineStringUnderTest.lineCount())
                .isEqualTo(MATRIX_HEIGHT_3);
    }

    @Test
    @DisplayName("It should return the rows of a multiline.")
    void rows() {
        setUp();
        List<List<IToken<DigitToken.TokenType>>> lines = generateThreeRowsWithTwentySevenTokensThatRepresentsDigitOneMutilineString();
        assertThat(multilineStringUnderTest.rows())
                .isEqualTo(lines);
    }
}