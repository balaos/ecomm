package com.sample.ecomm.others;

import java.util.Scanner;

public class PyramidPattern {
    private static void printPattern1(int rows) {
        // for loop for the rows
        for (int i = 1; i <= rows; i++) {
            // white spaces in the front of the numbers
            int numberOfWhiteSpaces = rows - i;

            //print leading white spaces
            printString(" ", numberOfWhiteSpaces);

            //print numbers
            printString(i + " ", i);

            //move to next line
            System.out.println("");
        }
    }

    //utility function to print string given times
    private static void printString(String s, int times) {
        for (int j = 0; j < times; j++) {
            System.out.print(s);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the rows to print:");
        int rows = scanner.nextInt();
        // System.out.println("Rows = "+rows);
        scanner.close();

        System.out.println("Printing Pattern 1\n");
        printPattern1(rows);
        printPattern2(rows);
        printPattern3(rows);
        printPattern4(rows);
        printPattern5(rows);

    }

    private static void printPattern2(int rows) {
        // for loop for the rows
        for (int i = 1; i <= rows; i++) {
            // white spaces in the front of the numbers
            int numberOfWhiteSpaces = rows - i;

            //print leading white spaces
            printString(" ", numberOfWhiteSpaces);

            //print numbers
            for(int x = 1; x<=i; x++) {
                System.out.print(x+" ");
            }

            //move to next line
            System.out.println("");
        }
    }

    private static void printPattern3(int rows) {
        // for loop for the rows
        for (int i = 1; i <= rows; i++) {
            // white spaces in the front of the numbers
            int numberOfWhiteSpaces = rows - i;

            //print leading white spaces
            printString(" ", numberOfWhiteSpaces);

            //print character
            printString("* ", i);

            //move to next line
            System.out.println("");
        }
    }

    private static void printPattern4(int rows){
        for (int i = 1; i <= rows; i++) {
            // Print spaces
            for (int j = 1; j <= rows - i; j++) {
                System.out.print("  "); // Two spaces for better alignment
            }

            // Print increasing numbers
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }

            // Print decreasing numbers
            for (int j = i - 1; j >= 1; j--) {
                System.out.print(j + " ");
            }

            System.out.println(); // Move to next line
        }
    }

    private static void printPattern5(int rows) {
        // for loop for the rows
        for (int i = rows; i >= 1; i--) {
            // white spaces in the front of the numbers
            int numberOfWhiteSpaces = rows - i;

            //print leading white spaces
            printString(" ", numberOfWhiteSpaces);

            //print character
            printString("* ", i);

            //move to next line
            System.out.println("");
        }
    }

}
