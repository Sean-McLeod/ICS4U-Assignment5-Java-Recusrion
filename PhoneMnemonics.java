/*
* This program uses recursion to figure out the
* letter combination of phone numbers.
*
* @author  Sean McLeod
* @version 1.0
* @since   2021-05-23
*/

import java.util.Scanner;
import java.util.ArrayList;

final class PhoneMnemonics {
    private PhoneMnemonics() {
        // Prevent instantiation
        // Optional: throw an exception e.g. AssertionError
        // if this ever *is* called
        throw new IllegalStateException("Cannot be instantiated");
    }

    public static ArrayList<String> listMnemonics(final ArrayList<String> result,
                                                  String currentMnemonics,
                                                  String currentNumber) {
        if (currentNumber.length() == 0) {
            // add current mnemonic in the result
            result.add(currentMnemonics);
        } else {
            String letters = mnemonicData(currentNumber.charAt(0));
            if (currentNumber.length() > 1) {
                currentNumber = currentNumber.substring(1);
            } else {
                currentNumber = "";
            }
            for (int counter = 0; counter < letters.length(); counter++) {
                char eachLetter = letters.charAt(counter);
                currentMnemonics = currentMnemonics +
                                   Character.toString(eachLetter);
                // recursive call
                listMnemonics(result, currentMnemonics, currentNumber);
                currentMnemonics = currentMnemonics.substring(0,
                                   currentMnemonics.length() - 1); 
            }
        }
        return result;
    }

    public static String mnemonicData(final char userNumber) {
        String result = "";
        switch (userNumber) {
            // no letters for number 1
            case '2': result = "ABC";
                      break;
            case '3': result = "DEF";
                      break;
            case '4': result = "GHI";
                      break;
            case '5': result = "JKL";
                      break;         
            case '6': result = "MNO";
                      break;         
            case '7': result = "PQRS";
                      break;
            case '8': result = "TUV";
                      break;         
            case '9': result = "WXYZ";
                      break;         
        }
        return result;
    }
   
    public static void main(final String[] args) {
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<String> finalMnemonic;
        String phoneNumber;

        // input
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        try {
            int intPhoneNumber = input.nextInt();
            // process
            phoneNumber = Integer.toString(intPhoneNumber);
            finalMnemonic = listMnemonics(result, "", phoneNumber);
            // output
            System.out.print("\n" + finalMnemonic);

        } catch (Exception e) {
            System.out.println("\nPlease enter an integer");
        }
   }
}
