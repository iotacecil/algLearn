package GCJ;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.util.*;
import java.io.*;
import java.util.concurrent.Executor;

//public class Main {
public class oversize {
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Scanner in = new Scanner(new File("src\\GCJ\\A-small-practice.in"));

        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int m = in.nextInt();
            System.out.println("Case #" + i + ": " + (n + m) + " " + (n * m));
        }
    }
}


