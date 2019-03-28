package ec.com.jmgorduez.BankOCR.domain.abstractions;

import ec.com.jmgorduez.BankOCR.domain.UndefinedDigit;
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

public abstract class AbstractCharacter implements ICharacter {

    protected Integer value;
    protected Integer[][] binaryMatrix;

    public AbstractCharacter(Integer value, Integer[][] binaryMatrix) {
        this.value = value;
        this.binaryMatrix = binaryMatrix;
    }

    @Override
    public Integer getIntegerValue() {
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
    public List<ICharacter> getSimilarCharacters(IMultilineCharacterReader multilineCharacterReader) {
        List<ICharacter> similarCharacters = new ArrayList<>();
        for (int i = 0; i < binaryMatrix.length; i++) {
            for (int j = 0; j < binaryMatrix[i].length; j++) {
                Integer[][] binaryMatrixCopy = copyBinaryMatrix(binaryMatrix);
                binaryMatrixCopy[i][j] = binaryMatrixCopy[i][j].equals(ZERO) ? ONE : ZERO;
                    ICharacter character
                            = multilineCharacterReader.readCharacter(binaryMatrixCopy);
                    if(multilineCharacterReader.isUndefinedDigit(character)){
                        continue;
                    }
                    similarCharacters.add(character);
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

    @Override
    public Integer calculateCheckSumValue(Integer characterIndex) {
        return characterIndex*value;
    }
}
