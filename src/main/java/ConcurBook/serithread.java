package ConcurBook;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


public class serithread {
   static class c1 implements Runnable{

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public void run() {
            System.out.println(incr.incrementAndGet());
            System.out.println(Thread.currentThread().getName());
        }
    }
    static AtomicInteger incr = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor poll = new ThreadPoolExecutor(1,1,10, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(100));
        for (int i = 0; i <100 ; i++) {
//            Thread t = new Thread(new c1(),""+incr.incrementAndGet());
//            System.out.println(t.getName());
            poll.execute(new c1());
//            t.start();
//            t.join();
//            poll.execute(t);
        }

    }
}
