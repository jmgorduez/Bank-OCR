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
import java.util.stream.Collectors;

import static ec.com.jmgorduez.BankOCR.domain.Digit.binaryMatrixToBinaryCode;
import static ec.com.jmgorduez.BankOCR.utils.Constants.*;


public class MultilineDigitReader implements IMultilineCharacterReader<Integer, DigitToken.TokenType> {

    private static final HashMap<Integer, Integer> binaryCodesForDigits = generateBinaryCodesForDigits();

    @Override
    public ICharacter<Integer> readCharacter(IMultilineString<IToken<DigitToken.TokenType>> digitTokenMatrix) {

        Integer[][] binaryMatrix = digitTokenMatrixToBinaryMatrix(digitTokenMatrix);
        Integer binaryCode = binaryMatrixToBinaryCode(binaryMatrix);
        try {
            return binaryCodeToDigit(binaryCode);
        } catch (IllegalArgumentException error) {
            return new UndefinedDigit(binaryMatrix);
        }
    }

    @Override
    public ICharacter<Integer> readCharacter(Integer[][] binaryMatrix) {
        Integer binaryCode = binaryMatrixToBinaryCode(binaryMatrix);
        try {
            return binaryCodeToDigit(binaryCode);
        } catch (IllegalArgumentException error) {
            return new UndefinedDigit(binaryMatrix);
        }
    }

    Integer[][] digitTokenMatrixToBinaryMatrix(IMultilineString<IToken<DigitToken.TokenType>> digitTokenMatrix) {

        List<Integer[]> binaryMatrix = new ArrayList<>();
        digitTokenMatrix.rows().stream().forEach(line -> {
            List<Integer> binaryToken =
                    line.stream().map(token -> {
                        return token.isVisible() ? ONE : ZERO;
                    }).collect(Collectors.toList());
            binaryMatrix.add(binaryToken.toArray(new Integer[]{}));
        });
        return binaryMatrix.toArray(new Integer[][]{});
    }

    public static Digit binaryCodeToDigit(Integer binaryCode)
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
        for (Digit digit = new Digit(ZERO); digit.getValue() <= NINE; ) {
            binaryCodesForDigits.put(digit.getValue(), digit.getBinaryCode());
            try {
                digit = digit.successor();
            } catch (UnsupportedOperationException error) {
                break;
            }
        }
        return binaryCodesForDigits;
    }
}
