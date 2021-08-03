package com.pauldelaney.dvdlibrary.ui;

import java.util.Scanner;

/**
 *
 * @author pauldelaney
 */
public class UserIOConsoleImpl implements UserIO {

    @Override
    public void print(String message) {
        //prints a string message
        System.out.println(message);
    }

    @Override
    public String readString(String prompt) {
        Scanner scan = new Scanner(System.in);      // Instantiate scanner
        System.out.println(prompt);                 // print prompt
        return scan.nextLine();                     // return user input

    }

    @Override
    public int readInt(String prompt) {

        Scanner scan = new Scanner(System.in);      // instantiate scanner
        System.out.println(prompt);                 // print prompt
        return Integer.parseInt(scan.nextLine());   // return user input as int
    }

    @Override
    public int readInt(String prompt, int min, int max) {

        /* While loop is set to true and we break this loop when user enters
        *  an integer in the correct range.
         */
        Scanner scan = new Scanner(System.in);      // instantiate scanner

        while (true) {
            System.out.println(prompt);                    // prompt user
            int input = Integer.parseInt(scan.nextLine()); // user input
            if (input >= min && input <= max) {
                return input;                       // return input if valid
            } else {
                System.out.println("Invalid input. Please enter an integter "
                        + " between " + min + " and " + max + ".");
            }
        }
    }

    @Override
    public double readDouble(String prompt) {
        Scanner scan = new Scanner(System.in);      // instantiate scanner
        System.out.println(prompt);                 // print prompt
        return Double.parseDouble(scan.nextLine()); // return user input Double
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        /* While loop is set to true and we break this loop when user enters
        *  a double in the correct range.
         */
        Scanner scan = new Scanner(System.in);      // instantiate scanner

        while (true) {
            System.out.println(prompt);                    // prompt user
            Double input = Double.parseDouble(scan.nextLine()); // user input
            if (input >= min || input <= max) {
                return input;                       // return input if valid
            } else {
                System.out.println("Invalid input. Please enter a value "
                        + " between " + min + " and " + max + ".");
            }
        }
    }

    @Override
    public float readFloat(String prompt) {
        Scanner scan = new Scanner(System.in);      // instantiate scanner
        System.out.println(prompt);                 // print prompt
        return Float.parseFloat(scan.nextLine());   // return user input float
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        /* While loop is set to true and we break this loop when user enters
        *  an float in the correct range.
         */
        Scanner scan = new Scanner(System.in);      // instantiate scanner

        while (true) {
            System.out.println(prompt);                    // prompt user
            float input = Float.parseFloat(scan.nextLine()); // user input
            if (input >= min && input <= max) {
                return input;                       // return input if valid
            } else {
                System.out.println("Invalid input. Please enter an value "
                        + " between " + min + " and " + max + ".");
            }
        }
    }

    @Override
    public long readLong(String prompt) {
        Scanner scan = new Scanner(System.in);      // instantiate scanner
        System.out.println(prompt);                 // print prompt
        return Long.parseLong(scan.nextLine());     // return user input as int
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        /* While loop is set to true and we break this loop when user enters
        *  a long in the correct range.
         */
        Scanner scan = new Scanner(System.in);      // instantiate scanner

        while (true) {
            System.out.println(prompt);                    // prompt user
            long input = Integer.parseInt(scan.nextLine()); // user input
            if (input >= min && input <= max) {
                return input;                       // return input if valid
            } else {
                System.out.println("Invalid input. Please enter a value "
                        + " between " + min + " and " + max + ".");
            }
        }

    }
}
