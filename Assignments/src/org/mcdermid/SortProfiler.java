package org.mcdermid;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Calendar;

public class SortProfiler {

    public static void main(String[] args) {
        int[] arr;
        try {
            arr = readToArray();
        } catch (FileNotFoundException e) {
            System.out.println("lmao you fucked up wrong filename");
            throw new RuntimeException();
        }
        // add sorting algorithm here
        Sorter.bubbleSort(arr, arr.length);
        long
    }

    public static int[] readToArray() throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("test.txt"));
        int[] arr = new int[4000];
        for (int i = 0; i < 4000; i++) { // I can guarantee there are exactly 4000 integers in this file
            arr[i] = in.nextInt();
        }
        return arr;
    }
}
