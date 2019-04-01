package ec.com.jmgorduez.BankOCR.domain.readers;

import ec.com.jmgorduez.BankOCR.domain.Digit;
import ec.com.jmgorduez.BankOCR.domain.UndefinedDigit;
import ec.com.jmgorduez.BankOCR.domain.abstractions.ICharacter;
import ec.com.jmgorduez.BankOCR.domain.abstractions.IToken;
import ec.com.jmgorduez.BankOCR.domain.DigitToken;
import ec.com.jmgorduez.BankOCR.domain.abstractions.IMultilineCharacterReader;
import ec.com.jmgorduez.BankOCR.domain.abstractions.IMultilineString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static ec.com.jmgorduez.BankOCR.domain.Digit.binaryMatrixToBinaryCode;
import static ec.com.jmgorduez.BankOCR.utils.Constants.*;


public class MultilineDigitReader implements IMultilineCharacterReader<DigitToken.TokenType> {

    private static final HashMap<Integer, Integer> binaryCodesForDigits = generateBinaryCodesForDigits();

    @Override
    public ICharacter readCharacter(IMultilineString<IToken<DigitToken.TokenType>> digitTokenMatrix) {

        Integer[][] binaryMatrix = digitTokenMatrixToBinaryMatrix(digitTokenMatrix);
        Integer binaryCode = binaryMatrixToBinaryCode(binaryMatrix);
        try {
            return binaryCodeToDigit(binaryCode);
        } catch (IllegalArgumentException error) {
            return new UndefinedDigit(binaryMatrix);
        }
    }

    @Override
    public ICharacter readCharacter(Integer[][] binaryMatrix) {
        Integer binaryCode = binaryMatrixToBinaryCode(binaryMatrix);
        try {
            return binaryCodeToDigit(binaryCode);
        } catch (IllegalArgumentException error) {
            return new UndefinedDigit(binaryMatrix);
        }
    }

    Integer[][] digitTokenMatrixToBinaryMatrix(IMultilineString<IToken<DigitToken.TokenType>> digitTokenMatrix) {
        return digitTokenMatrix.rows().stream()
                .map(line -> digitTokenArrayToBinaryArray(line))
                .toArray(Integer[][]::new);
    }

    Integer[] digitTokenArrayToBinaryArray(List<IToken<DigitToken.TokenType>> line) {
        return line.stream().map(token -> token.isVisible() ? ONE : ZERO)
                .toArray(Integer[]::new);
    }

    static Digit binaryCodeToDigit(Integer binaryCode)
            throws IllegalArgumentException {
        List<Digit> digitFound = new ArrayList<>();
        binaryCodesForDigits.forEach((digit, binCode) -> {
            if (binaryCode.equals(binCode)) {
                digitFound.add(new Digit(digit));
            }
        });
        if (digitFound.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return digitFound.get(0);
    }

    static HashMap<Integer, Integer> generateBinaryCodesForDigits() {
        HashMap<Integer, Integer> binaryCodesForDigits = new HashMap<>();
        for (Digit digit = new Digit(ZERO); digit.getIntegerValue() <= NINE; ) {
            binaryCodesForDigits.put(digit.getIntegerValue(), digit.getBinaryCode());
            try {
                digit = digit.successor();
            } catch (UnsupportedOperationException error) {
                break;
            }
        }
        return binaryCodesForDigits;
    }

    @Override
    public boolean isUndefinedDigit(ICharacter digit) {
        return digit instanceof UndefinedDigit;
    }
}
