/*
* This program uses recursion to
* print out the symmetrical pattern of an hourglass.
*
* @author  Sean McLeod
* @version 1.0
* @since   2021-05-23
*/

import java.util.Scanner;

final class SymmetricPattern {
    private SymmetricPattern() {
        // Prevent instantiation
        // Optional: throw an exception e.g. AssertionError
        // if this ever *is* called
        throw new IllegalStateException("Cannot be instantiated");
    }

    public static void printStars(final int nOfStars,
                                  final int spaceBeforeStars, int space) {
        if (nOfStars == 1 && spaceBeforeStars == 0) {
            /* if the input is 1 from the beginning,
            display two lines with one star each */
            System.out.println("*\n*");
            System.out.println("\nDone");
        } else {
            if (spaceBeforeStars < 0 && space < 0) {
                // if there are no more spaces to put, end the program
                System.out.println("\nDone");
            } else {
                // print spaces before the stars
                for (int counter = 0; counter < spaceBeforeStars; counter++) {
                    System.out.print(" ");
                }
                // print stars and spaces
                for (int counter = 0; counter < nOfStars; counter++) {
                    System.out.print("* ");
                }
                System.out.println();

                // upper part is finished, decrease the space before stars from here
                if (nOfStars == 1) {
                    space = -1;
                }

                // recursive call
                printStars(nOfStars - space, spaceBeforeStars + space, space);
            }
        }
    }

    public static void main(final String[] args) {
        // input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        try {
            int nOfStars = input.nextInt();

            if (nOfStars >= 1) {
                // process
                printStars(nOfStars, 0, 1);
            } else {
                System.out.println("\nThis is less than 1");
            }
        } catch (Exception e) {
            System.out.println("\nPlease enter an integer");
        }
    }
}
