package ec.com.jmgorduez.BankOCR.utils;

import ec.com.jmgorduez.BankOCR.domain.Digit;

import java.text.DecimalFormat;
import java.util.Arrays;

import static ec.com.jmgorduez.BankOCR.utils.Constants.*;

public class MathOperations {
    private final static int TEN = 10;

    public static int binaryToDecimal(Integer[] binaryNumber){
        return arrayToNumber(binaryNumber, TWO);
    }

    public static int intArrayToDecimal(Integer[] binaryNumber){
        return arrayToNumber(binaryNumber, TEN);
    }

    private static int arrayToNumber(Integer[] arrayNumber, int base){
        double number = 0;
        int position = arrayNumber.length - ONE;
        for (int digit : arrayNumber){
            number = digit * Math.pow(base,position) + number;
            position--;
        }
        return (int) number;
    }
}
