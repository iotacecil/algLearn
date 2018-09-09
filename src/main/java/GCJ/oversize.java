package GCJ;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//public class Main {
public class oversize {
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Scanner in = new Scanner(new File("src\\main.java.GCJ\\A-small-practice.in"));

        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int m = in.nextInt();
            System.out.println("Case #" + i + ": " + (n + m) + " " + (n * m));
        }
    }
}


