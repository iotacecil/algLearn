package javaquickTest.middlebook;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

//22595ms
public class 随机数不使用线程池 {
    public static void main(String[] args) {
        final int count = 100000;
        long startTime = System.currentTimeMillis();
        final List<Integer> l = new LinkedList<>();
        final Random random = new Random();
        for (int i = 0; i < count; i++) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    l.add(random.nextInt());
                }
            };
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


        System.out.println(System.currentTimeMillis() - startTime);
        System.out.println(l.size());
    }
}
