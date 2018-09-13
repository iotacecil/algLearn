package javaquickTest;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        Random rnd = new Random();
        while (true)
        System.out.println(rnd.nextInt(4)+1);
    }
}
