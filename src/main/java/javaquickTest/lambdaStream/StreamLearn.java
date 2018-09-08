package javaquickTest.lambdaStream;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class StreamLearn {
    public static void main(String[] args) {
        Random random = new Random(1024);
        int[] test = new int[1<<10];
        for (int i = 0; i <test.length ; i++) {
            test[i] = random.nextInt(1<<10);
        }
        long start1 = System.currentTimeMillis();
        IntStream.of(test).min().getAsInt();
        long end1 = System.currentTimeMillis();
        System.out.println(end1-start1);
        long start = System.currentTimeMillis();
        IntStream.of(test).parallel().min().getAsInt();
        long end = System.currentTimeMillis();
        System.out.println(end-start);

    }
}
