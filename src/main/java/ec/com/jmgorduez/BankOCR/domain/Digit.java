package ec.com.jmgorduez.BankOCR.domain;

import ec.com.jmgorduez.BankOCR.domain.abstractions.ICharacter;
import ec.com.jmgorduez.BankOCR.utils.MathOperations;
import sun.misc.FloatingDecimal;

import java.math.MathContext;
import java.util.*;

import static ec.com.jmgorduez.BankOCR.utils.Constants.*;
import static ec.com.jmgorduez.BankOCR.utils.MathOperations.binaryToDecimal;
import static ec.com.jmgorduez.BankOCR.utils.MathOperations.intArrayToDecimal;

public class Digit implements ICharacter<Integer> {

    private static final HashMap<Integer, Integer[][]> binaryMatrixForDigit = generateBinaryMatrixForDigit();

    private Integer value;
    private final Integer[][] binaryMatrix;

    public Digit(Integer value) {

        this.value = value;
        binaryMatrix = binaryMatrixForDigit.get(value);
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public int getBinaryCode() {
        List<Integer> binaryCode = new ArrayList<>();
        Arrays.stream(binaryMatrix).forEach(row -> {
            binaryCode.add(binaryToDecimal(row));
        });
        return (int) intArrayToDecimal(binaryCode.toArray(new Integer[binaryCode.size()]));
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Digit)) {
            return false;
        }
        return ((Digit) other).value.equals(this.value);
    }

    public int hashCode() {
        return Objects.hashCode(this.value);
    }

    private static HashMap<Integer, Integer[][]> generateBinaryMatrixForDigit() {
        HashMap<Integer, Integer[][]> binaryMatrixMap = new HashMap<>();
        binaryMatrixMap.put(ONE, BINARY_MATRIX_ONE);
        binaryMatrixMap.put(TWO, BINARY_MATRIX_TWO);
        binaryMatrixMap.put(THREE, BINARY_MATRIX_THREE);
        binaryMatrixMap.put(FOUR, BINARY_MATRIX_FOUR);
        binaryMatrixMap.put(FIVE, BINARY_MATRIX_FIVE);
        binaryMatrixMap.put(SIX, BINARY_MATRIX_SIX);
        binaryMatrixMap.put(SEVEN, BINARY_MATRIX_SEVEN);
        binaryMatrixMap.put(EIGHT, BINARY_MATRIX_EIGHT);
        binaryMatrixMap.put(NINE, BINARY_MATRIX_NINE);
        binaryMatrixMap.put(ZERO, BINARY_MATRIX_ZERO);
        return binaryMatrixMap;
    }

}
