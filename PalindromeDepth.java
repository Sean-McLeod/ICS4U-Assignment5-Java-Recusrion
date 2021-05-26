/*
* This program uses recursion to
* figure out the palindrome depth of numbers.
*
* @author  Sean McLeod
* @version 1.0
* @since   2021-05-23
*/

import java.util.Scanner;

final class PalindromeDepth {
    private PalindromeDepth() {
        // Prevent instantiation
        // Optional: throw an exception e.g. AssertionError
        // if this ever *is* called
        throw new IllegalStateException("Cannot be instantiated");
    }

    public static boolean isPalindrome(String stringToCheck) {
        if (stringToCheck.length() == 0 || stringToCheck.length() == 1) {
            return true;
        }
        if (stringToCheck.charAt(0) == stringToCheck.charAt
                                      (stringToCheck.length() - 1)) {
            return isPalindrome(stringToCheck.substring
                                (1, stringToCheck.length() - 1));
        }
        return false;
    }

    public static long addNumber(long number, int depth) {
        String stringNumber = Long.toString(number);
        String reversedString = reverse(stringNumber);
        if (isPalindrome(reversedString)) {
            return depth;
        } else {
            long total = number + Long.parseLong(reversedString);
            // recursive call
            long result = addNumber(total, depth += 1);
            return result;
        }
    }

    public static String reverse(final String stringToReverse) {
        // This function reverses a string
        if (stringToReverse.length() == 1) {
            return stringToReverse;
        } else {
            // return characters one by one
            return reverse(stringToReverse.substring(1)) + stringToReverse.charAt(0);
        }
    }

    public static void main(final String[]args) {
        final int startTwoDigit = 10;
        final int  endTwoDigit = 100;

        System.out.println("\nWelcome!\n");
        System.out.println("The Format = number: number of times it takes to reverse the ");
        System.out.println("             number and add it to itself until the ");
        System.out.println("             number is a palindrome.\n");
        System.out.println("For example, 12 is not a palindrome, so reverse it ");
        System.out.println("and add it to it self (12 + 21 = 33). 33 is a ");
        System.out.println("palindrome. So it took 1 step to solve for 12.\n");
        for (int counter = startTwoDigit; counter < endTwoDigit; counter++) {
            long result = addNumber(counter, 0);
            System.out.print(counter + ": " + result + "      ");
        }
    }
}
