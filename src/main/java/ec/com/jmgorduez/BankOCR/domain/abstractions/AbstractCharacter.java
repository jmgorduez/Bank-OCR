package ec.com.jmgorduez.BankOCR.domain.abstractions;

import ec.com.jmgorduez.BankOCR.domain.abstractions.ICharacter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ec.com.jmgorduez.BankOCR.utils.Constants.ONE;
import static ec.com.jmgorduez.BankOCR.utils.Constants.ZERO;
import static ec.com.jmgorduez.BankOCR.utils.MathOperations.bitsArrayToNumberBaseTen;
import static ec.com.jmgorduez.BankOCR.utils.MathOperations.digitsArrayToNumberBaseTen;

public abstract class AbstractCharacter<CHARACTER_TYPE> implements ICharacter<CHARACTER_TYPE> {

    protected CHARACTER_TYPE value;
    protected Integer[][] binaryMatrix;

    public AbstractCharacter(CHARACTER_TYPE value, Integer[][] binaryMatrix) {
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
        List<ICharacter<CHARACTER_TYPE>> similarCharacters = new ArrayList<>();
        for (int i = 0; i < binaryMatrix.length; i++) {
            for (int j = 0; j < binaryMatrix[i].length; j++) {
                Integer[][] binaryMatrixCopy = copyBinaryMatrix(binaryMatrix);
                binaryMatrixCopy[i][j] = binaryMatrixCopy[i][j].equals(ZERO) ? ONE : ZERO;
                try {
                    ICharacter<CHARACTER_TYPE> character = getInstance(binaryMatrixCopy);
                    similarCharacters.add(character);
                } catch (IllegalArgumentException error) {
                    continue;
                }
            }
        }
        return similarCharacters;
    }

    public static Integer[][] copyBinaryMatrix(Integer[][] binaryMatrix) {
        List<Integer[]> binaryMatrixCopy =
                Arrays.stream(binaryMatrix).map(row -> {
                    return Arrays.copyOf(row, row.length);
                }).collect(Collectors.toList());
        return binaryMatrixCopy.toArray(new Integer[][]{});
    }

    protected abstract ICharacter<CHARACTER_TYPE> getInstance(Integer[][] binaryMatrix)
            throws IllegalArgumentException;
}
