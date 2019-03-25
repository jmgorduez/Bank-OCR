package ec.com.jmgorduez.BankOCR.domain.abstractions;

import ec.com.jmgorduez.BankOCR.domain.abstractions.ICharacter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ec.com.jmgorduez.BankOCR.utils.MathOperations.bitsArrayToNumberBaseTen;
import static ec.com.jmgorduez.BankOCR.utils.MathOperations.digitsArrayToNumberBaseTen;

public abstract class AbstractCharacter<CHARACTER_TYPE> implements ICharacter<CHARACTER_TYPE> {

    protected CHARACTER_TYPE value;
    protected Integer[][] binaryMatrix;

    public AbstractCharacter(CHARACTER_TYPE value, Integer[][] binaryMatrix){
        this.value = value;
        this.binaryMatrix = binaryMatrix;
    }

    @Override
    public CHARACTER_TYPE getValue() {
        return this.value;
    }

    @Override
    public int getBinaryCode() {
        return binaryMatrixToBinaryCode(binaryMatrix);
    }

    public static int binaryMatrixToBinaryCode(Integer[][] binaryMatrix) {
        Integer[] binaryNumber =
                Arrays.stream(binaryMatrix).map(row -> {
                    return bitsArrayToNumberBaseTen(row);
                }).toArray(Integer[]::new);
        return digitsArrayToNumberBaseTen(binaryNumber);
    }

    @Override
    public List<ICharacter<CHARACTER_TYPE>> getSimilarCharacters() {
        return new ArrayList<>();
    }
}
