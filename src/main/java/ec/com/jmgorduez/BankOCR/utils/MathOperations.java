package ec.com.jmgorduez.BankOCR.utils;

import static ec.com.jmgorduez.BankOCR.utils.Constants.ONE;
import static ec.com.jmgorduez.BankOCR.utils.Constants.TWO;

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
