package ec.com.jmgorduez.BankOCR.utils;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static ec.com.jmgorduez.BankOCR.utils.Constants.*;

public class MathOperations {
    private final static int TEN = 10;

    public static int bitsArrayToNumberBaseTen(Integer[] binaryNumber){
        return arrayToNumberAccordingBase(binaryNumber, TWO);
    }

    public static int digitsArrayToNumberBaseTen(Integer[] binaryNumber){
        return arrayToNumberAccordingBase(binaryNumber, TEN);
    }

    private static int arrayToNumberAccordingBase(Integer[] arrayNumber, int numberBase){
        double number = 0;
        int position = arrayNumber.length - ONE;
        for (int digit : arrayNumber){
            number = digit * Math.pow(numberBase,position) + number;
            position--;
        }
        return (int) number;
    }
}
