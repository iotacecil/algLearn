package ConcurBook;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class printi {
    static AtomicInteger ai = new AtomicInteger();
    static class  runn implements Runnable{


        @Override
        public void run() {
           ai.incrementAndGet();
        }
    }
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ExecutorService poll = Executors.newFixedThreadPool(1);
        for (int i = 0; i <1000000 ; i++) {
           poll.submit(new runn());
        }
        poll.shutdown();
        System.out.println(System.currentTimeMillis() - start);
    }
}
