package org.mcdermid;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RNJesus {

    public static void main(String[] args) throws IOException {
        Random r = new Random();
        BufferedWriter w = new BufferedWriter(new FileWriter("test.txt"));

        for (int i = 0; i < 4000; i++) {
            getRandomNumber(r, w);
        }
        w.close();
    }

    public static void getRandomNumber(Random r, BufferedWriter writer) throws IOException {
        writer.write(r.nextInt(0, 999) + "\n");
    }
}
