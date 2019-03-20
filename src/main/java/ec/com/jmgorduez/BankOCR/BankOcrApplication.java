package ec.com.jmgorduez.BankOCR;

import ec.com.jmgorduez.BankOCR.domain.*;
import ec.com.jmgorduez.BankOCR.domain.abstractions.*;
import ec.com.jmgorduez.BankOCR.utils.Constants;
import javafx.scene.control.Dialog;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static ec.com.jmgorduez.BankOCR.utils.Constants.STRING_LENGTH;

public class BankOcrApplication {

    private static final String FILE_PATH = "C:\\Users\\JuanMa\\projects\\java\\Bank-OCR\\inputFiles\\input.txt";

    public static void main(String[] args) {
        try {
            do {
                BufferedReader bufferedReader =
                        new BufferedReader(new FileReader(FILE_PATH));
                IMultilineStringReader multilineStringReader =
                        new MultilineDigitStringReader(STRING_LENGTH);
                ILineReader<DigitToken.TokenType> lineReader
                        = new LineReader();
                IMultilineCharacterReader<Integer, DigitToken.TokenType> multilineCharacterReader =
                        new MultilineDigitReader();
                List<ICharacter<Integer>> characters
                        = multilineStringReader.read(bufferedReader, lineReader, multilineCharacterReader);
                IAccountNumberReader<DigitToken.TokenType, Integer, Integer> accountNumberReader =
                        new IntegerAccountNumberReader();
                IAccountNumber<Integer> accountNumber
                        = accountNumberReader.readAccountNumber(characters);
                System.out.println(accountNumber.getValue());
            }while (true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("----------------THE END-----------------");
        }
    }

}
