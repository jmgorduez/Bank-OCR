package ec.com.jmgorduez.BankOCR.infrastructure;

import ec.com.jmgorduez.BankOCR.domain.Digit;
import ec.com.jmgorduez.BankOCR.domain.abstractions.ICharacter;
import ec.com.jmgorduez.BankOCR.domain.abstractions.IToken;
import ec.com.jmgorduez.BankOCR.domain.DigitToken;
import ec.com.jmgorduez.BankOCR.infrastructure.abstractions.ICharacterReader;

import java.util.Arrays;

import static ec.com.jmgorduez.BankOCR.domain.Digit.binaryCodeToDigit;
import static ec.com.jmgorduez.BankOCR.domain.Digit.binaryMatrixToBinaryCode;
import static ec.com.jmgorduez.BankOCR.utils.Constants.ONE;
import static ec.com.jmgorduez.BankOCR.utils.Constants.ZERO;


public class DigitReader implements ICharacterReader<Integer, DigitToken.TokenType> {

    @Override
    public ICharacter<Integer> readCharacter(IToken<DigitToken.TokenType>[][] digitTokenMatrix) {

        Integer[][] binaryMatrix = digitTokenMatrixToBinaryMatrix(digitTokenMatrix);
        Integer binaryCode = binaryMatrixToBinaryCode(binaryMatrix);
        return binaryCodeToDigit(binaryCode);
    }

    Integer[][] digitTokenMatrixToBinaryMatrix(IToken<DigitToken.TokenType>[][] tokenToRead) {

        Integer[][] binaryMatrix = new Integer[tokenToRead.length][tokenToRead[0].length];
        for (int i = 0; i < tokenToRead.length; i++) {
            for (int j = 0; j < tokenToRead[i].length; j++) {
                binaryMatrix[i][j] = tokenToRead[i][j].isVisible() ? ONE : ZERO;
            }
        }
        return binaryMatrix;
    }
}
