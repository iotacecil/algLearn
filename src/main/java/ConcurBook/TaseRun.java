package ConcurBook;


import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TaseRun {
    public static AtomicInteger rst = new AtomicInteger(0);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService poll = Executors.newFixedThreadPool(100);
        Task[] tasks = new Task[100];
        for (int i = 0; i < 100; i++) {
            tasks[i] = new Task();

        }
        Future[] ft = new Future[100];
        int i = 0;
        long start = System.currentTimeMillis();
        for (Task ts : tasks) {
            ft[i++] = poll.submit(new Worker(ts));
//            System.out.println(submit.isDone());
//            System.out.println(submit.get());
        }

        for (Future<Integer> f : ft) {
//            if(f.isDone())
            rst.addAndGet(f.get());
            //++i
        }
        System.out.println(rst.get());
        System.out.println(System.currentTimeMillis() - start);
        poll.shutdown();

    }

    static class Worker implements Callable<Integer> {
        Task task;

        public Worker(Task ts) {
            task = ts;
        }

        @Override
        public Integer call() throws Exception {
            return task.fun();
//            return null;
        }
    }


    static class Task {
        public int fun() throws InterruptedException {
            Thread.sleep(1000);
            return 10;
        }
    }
}
