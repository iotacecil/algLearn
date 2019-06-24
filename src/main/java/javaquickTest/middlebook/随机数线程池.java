package javaquickTest.middlebook;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//117ms
public class 随机数线程池 {

    public static void main(String[] args) {
        final int count = 100000;
        long startTime = System.currentTimeMillis();
        final List<Integer> l = new LinkedList<>();
        ThreadPoolExecutor TP = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<>(count));
        final Random random = new Random();
        for (int i = 0; i < count; i++) {
            TP.execute(new Runnable() {
                @Override
                public void run() {
                    l.add(random.nextInt());
                }
            });

        }
        TP.shutdown();
        try {
            TP.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() - startTime);
        System.out.println(l.size());

    }
}
