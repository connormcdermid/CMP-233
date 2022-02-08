package org.mcdermid;

import java.util.Scanner;

/**
 * @author Connor McDermid
 * Section CMP-233-23122
 * Date 2022-01-31
 * Recursion homework
 */
public class Main {

    public static void main(String[] args) {
        displayRowOfCharacters('*', 10); // Exercise 1
        getInput(); // Exercise 3
        factorial(45); // Exercise 4
        factorial2(45);
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] ar2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        inPlaceReverse(arr, 0, arr.length - 1); // Exercise 5
        for (int i: arr) {
            System.out.println(i);
        }
        arr = copyReverse(ar2, 0, ar2.length - 1, new int[ar2.length]); // Exercise 6
        for (int i: arr) {
            System.out.println(i);
        }
        Scanner user = new Scanner(System.in);
        String in = user.nextLine();
        System.out.println(reverseString(in, 0, in.length() - 1)); // Exercise 7
        System.out.println(simpleReverseString(in));
    }

    /**
     * Problem 1: Write a recursive method that displays a given character a given number of times.
     * @param c The character to display
     * @param n The number of times to display it
     */
    public static void displayRowOfCharacters(char c, int n) {
        if (n > 0) {
            System.out.print(c);
            displayRowOfCharacters(c, n - 1);
            int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            int[] ar2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        }
    }

    /*
     * Problem 2: Describe a recursive algorithm that draws concentric circles.
     * Writing this out within a comment as the problem only says to "describe"
     * a recursive algorithm, and I do *not* want to implement a GUI in my homework.
     * I shall write the algorithm in pseudocode.
     *
     *  public static void concentric(float diameter) {
     *      if (diameter < 1.0) {
     *          return;
     *      } else {
     *          drawCircle(diameter);
     *          concentric(0.75 * diameter);
     *      }
     *  }
     */

    /**
     * Problem 3: Write a method that asks for user input... If the input is out of range, call yourself.
     */
    public static void getInput() {
        System.out.println("Please input a number between 1 and 10.");
        Scanner user = new Scanner(System.in);

        int in = user.nextInt();
        if (in < 1 || in > 10) {
            System.out.println("Good job!");
        } else {
            getInput();
        }
    }

    /**
     * Problem 4: Write a recursive method that solves n! Solution 1.
     * This method solves the problem on the way down the stack.
     * @param n Input
     * @return  n!
     * @throws IllegalArgumentException Someone entered a negative number!
     */
    public static int factorial(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("No negative numbers allowed.");
        } else if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    /**
     * Problem 4: Solution 2.
     * This method solves the problem on the way up the stack.
     * @param n
     * @return
     * @throws IllegalArgumentException
     */
    public static int factorial2(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("No negative numbers allowed.");
        } else if (n == 0) {
            return 1;
        } else {
            return factorial2(n - 1) * n;
        }
    }

    /**
     * Exercise 5: Reverse an array.
     * @param arr Input array
     * @param start Index to start the reverse operation
     * @param end Index to end the reverse operation
     * @return A reversed array
     */
    public static int[] inPlaceReverse(int[] arr, int start, int end) {
        if (start < end) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            inPlaceReverse(arr, start + 1, end - 1);
        }
        return arr;
    }

    /**
     * Exercise 6: Reverse an array, but *differently*.
     * @param source Input array
     * @param start Index to start reverse operation
     * @param end Index to end reverse operation
     * @param sink Output array
     * @return The output array
     */
    public static int[] copyReverse(int[] source, int start, int end, int[] sink) {
        if (start < end) {
            int tmp = source[start];
            sink[end] = tmp;
            tmp = source[end];
            sink[start] = tmp;
            return copyReverse(source, start + 1, end - 1, sink);
        } else {
            return sink;
        }
    }

    public static String reverseString(String str, int start, int end) {
        char[] charray = str.toCharArray();
        if (start < end) {
            char tmp = charray[start];
            charray[start] = charray[end];
            charray[end] = tmp;
            return reverseString(new String(charray), start + 1, end - 1);
        } else {
            return str;
        }
    }

    public static String simpleReverseString(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        } else {
            return simpleReverseString(str.substring(1)) + str.charAt(0);
        }
    }
}