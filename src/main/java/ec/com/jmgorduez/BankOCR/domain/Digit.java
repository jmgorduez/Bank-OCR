package ec.com.jmgorduez.BankOCR.domain;

import ec.com.jmgorduez.BankOCR.domain.abstractions.ICharacter;

import java.util.*;

import static ec.com.jmgorduez.BankOCR.utils.Constants.*;
import static ec.com.jmgorduez.BankOCR.utils.MathOperations.bitsArrayToNumberBaseTen;
import static ec.com.jmgorduez.BankOCR.utils.MathOperations.digitsArrayToNumberBaseTen;

public class Digit implements ICharacter<Integer> {

    private static final HashMap<Integer, Integer[][]> binaryMatricesForDigits = generateBinaryMatricesForDigits();
    private static final HashMap<Integer, Integer> binaryCodesForDigits = generateBinaryCodesForDigits();

    private Integer value;
    private final Integer[][] binaryMatrix;

    public Digit(Integer value) {

        this.value = value;
        binaryMatrix = binaryMatricesForDigits.get(value);
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public int getBinaryCode() {

        return binaryMatrixToBinaryCode(binaryMatrix);
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

    static HashMap<Integer, Integer[][]> generateBinaryMatricesForDigits() {

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

    static HashMap<Integer, Integer> generateBinaryCodesForDigits() {
        HashMap<Integer, Integer> binaryCodesForDigits = new HashMap<>();
        for (Digit digit = new Digit(ZERO); digit.value <= 9; ) {
            binaryCodesForDigits.put(digit.value, digit.getBinaryCode());
            try {
                digit = digit.successor();
            }catch (UnsupportedOperationException error){
                break;
            }
        }
        return binaryCodesForDigits;
    }

    public static int binaryMatrixToBinaryCode(Integer[][] binaryMatrix) {
        List<Integer> binaryCode = new ArrayList<>();
        Arrays.stream(binaryMatrix).forEach(row -> {
            binaryCode.add(bitsArrayToNumberBaseTen(row));
        });
        return (int) digitsArrayToNumberBaseTen(binaryCode.toArray(new Integer[binaryCode.size()]));
    }

    public static Digit binaryCodeToDigit(Integer binaryCode) {
        List<Digit> digitFound = new ArrayList<>();
        binaryCodesForDigits.forEach((digit, binCode) -> {
            if (binaryCode.equals(binCode)) {
                digitFound.add(new Digit(digit));
            }
        });
        return digitFound.get(0);
    }

    public Digit successor() throws UnsupportedOperationException {
        if (value == NINE) {
            throw new UnsupportedOperationException();
        }
        int successorValue = value + ONE;
        return new Digit(successorValue);
    }

}
