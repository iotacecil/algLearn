package ConcurBook;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class Task implements Callable<Integer>{
    int a = 0;
    CountDownLatch latch;
//    AtomicInteger rst;

    public Task(CountDownLatch latch) {
       this.latch = latch;
    }

    public int dodo() throws InterruptedException {
        Thread.sleep(1000);
        return 10;
    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Integer call() throws Exception {
        System.out.println("任务开始");
        int dodo = dodo();
        latch.countDown();
        System.out.println("任务结束");
        return  dodo;
    }
}



public class taskmerge {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CountDownLatch cdl = new CountDownLatch(10);
        ExecutorService poll = Executors.newFixedThreadPool(10);
         AtomicInteger rst = new AtomicInteger(0);

        Task[] ts = new Task[10];
        long start = System.currentTimeMillis();
        Future[] ft = new Future[10];
        for (int i = 0; i <10 ; i++) {
            ts[i] = new Task(cdl);
            ft[i]= poll.submit(ts[i]);
//            Integer rr = poll.submit(ts[i]).get();
//            System.out.println(rst.addAndGet(rr));


        }
        System.out.println("结束前");
        cdl.await();
        System.out.println("结束后");

        for(Future f:ft){

            if(f.isDone())
            rst.addAndGet((Integer)f.get());
        }
        System.out.println(System.currentTimeMillis()-start);
        System.out.println(rst.get());
        poll.shutdown();


    }
}
