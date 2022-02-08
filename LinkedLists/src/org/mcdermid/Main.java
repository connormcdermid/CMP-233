package org.mcdermid;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner usr = new Scanner(System.in); // import scanner
        // Create new empty LinkedList
        ListManager man = new ListManager();
        int in;

        do { // loop user to enter numbers until they enter 0
            System.out.println("Please enter a number: ");
            in = usr.nextInt();

            man.add(in);
        } while (in != 0);
        // user is now donw
        // print them
        man.traverse();
        System.out.println(man.length());

    }
}
