package ec.com.jmgorduez.BankOCR.infrastructure;

import ec.com.jmgorduez.BankOCR.domain.abstractions.ICharacter;
import ec.com.jmgorduez.BankOCR.domain.abstractions.IToken;
import ec.com.jmgorduez.BankOCR.domain.DigitToken;
import ec.com.jmgorduez.BankOCR.infrastructure.abstractions.IMultilineCharacterReader;
import ec.com.jmgorduez.BankOCR.infrastructure.abstractions.IMultilineString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static ec.com.jmgorduez.BankOCR.utils.Constants.ONE;
import static ec.com.jmgorduez.BankOCR.utils.Constants.ZERO;


public class MultilineDigitReader implements IMultilineCharacterReader<Integer, DigitToken.TokenType> {

    @Override
    public ICharacter<Integer> readCharacter(IMultilineString<IToken<DigitToken.TokenType>> digitTokenMatrix) {

        /*Integer[][] binaryMatrix = digitTokenMatrixToBinaryMatrix(digitTokenMatrix);
        Integer binaryCode = binaryMatrixToBinaryCode(binaryMatrix);
        return binaryCodeToDigit(binaryCode);*/
        return null;
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
}
