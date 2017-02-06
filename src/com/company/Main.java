package com.company;

import java.util.Scanner;

public class Main {

    /*************************************************************************
     * This method asks the user if they want to continue the program or not *
     *************************************************************************/
    public static boolean askUserToContinue() {
        // Variable declarations
        String userInput = "";                  // User input string
        Scanner scan = new Scanner(System.in);  // Scanner object for user input

        // Prompt user to enter yes or no
        System.out.print("Continue? (y/n): ");
        userInput = scan.nextLine();
        System.out.println("");

        // Validate whether user input is ok, and continue asking until right
        while (!userInput.equalsIgnoreCase("y") &&
                !userInput.equalsIgnoreCase("yes") &&
                !userInput.equalsIgnoreCase("n") &&
                !userInput.equalsIgnoreCase("no")) {
            System.out.println("That is not a valid input.  Please try again. ");
            System.out.print("Do you want to continue? (y/n): ");
            userInput = scan.nextLine();
            System.out.println("");
        }

        // Return true if user says yes, and false if user says no
        if (userInput.equalsIgnoreCase("y") || userInput.equalsIgnoreCase("yes")) {
            return true;
        } else {
            return false;
        }
    }

    /****************************************************************
     * getValidInteger function to validate that it is an int value *
     ****************************************************************/
    public static long getValidInteger() {
        Scanner scnr = new Scanner(System.in);

        // This keeps looping until integer input is received.
        while (!scnr.hasNextLong()) {
            scnr.nextLine();         // clear the buffer
            System.out.println("Please enter an integer!");
        }

        return scnr.nextLong();
    }


    /**
     * This is the method that checks the range
     */
    public static boolean checkRange(long input, long min, long max) {

        if (input >= min && input <= max) {
            return true;
        }
        else {
            return false;
        }
    }

    /*****************************************************************************
     * This is a method to determine whether the integer is within min/max range *
     * Use with checkRangeMethod                                                 *
     *****************************************************************************/
    public static long getValidInteger(long min, long max) {

        long userInput = getValidInteger();
        while (checkRange(userInput,min,max) == false) {
            System.out.println("Please provide a number within range!");
            userInput = getValidInteger();
        }
        return userInput;
    }

    /****************************************************************
     * getFactorial function to get valid integer value *
     ****************************************************************/
    public static long getFactorial(long number) {
        if (number == 1) {
            return 1;
        }
        else {
            return number * getFactorial(number - 1);
        }
    }

    public static void main(String[] args) {
	    // Variable declarations
        boolean continueProgram = true;     // boolean to keep program running
        long min = 1;                        // range of valid user input
        long max = 9;                       // range of valid user input

        // Welcome message
        System.out.println("Welcome to the Factorial Calculator!\n");

        // Continue the program until user terminates
        while (continueProgram) {
            // Prompt user and get number
            System.out.print("Enter an integer that's greater than " + (min - 1) +
                                " but less than " + (max + 1) + ": ");
            long number = getValidInteger(min, max);
            System.out.println("");

            long result = getFactorial(number);

            // Print result
            System.out.println("The factorial of " + number + " is " + result + "\n");

            // Ask the user if they want to continue
            continueProgram = askUserToContinue();
        }

        // Exit message
        System.out.println("Goodbye\n");

    }
}
