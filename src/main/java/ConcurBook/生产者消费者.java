package ConcurBook;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

class Product<T> {
    LinkedBlockingQueue<T> arr;
    Semaphore sema;

    public Product(int capacity) {
        this.arr = new LinkedBlockingQueue<T>(capacity);
        sema = new Semaphore(capacity);
    }

    public void produce(T a) {
//        if (sema.tryAcquire()) {
//            System.out.println(arr);
//            boolean offer = arr.offer(a);
//            sema.release();
//        }

        try {
            arr.put(a);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public T consume() {

        T poll = null;
        try {
            poll = arr.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        if(poll == null)Thread.yield();
        return poll;
    }
}

class Consumer implements Runnable {
    Product<Integer> pro;

    Consumer(Product<Integer> p) {
        pro = p;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("消费" + pro.consume());
        }
    }
}

class Producer implements Runnable {
    Product<Integer> pro;
    AtomicInteger a = new AtomicInteger(0);

    Producer(Product<Integer> p) {
        pro = p;
    }

    @Override
    public void run() {
        while (true) {
//            pro.produce(1);
            pro.produce(a.getAndAdd(1));
            System.out.println("生产");
        }
    }
}

public class 生产者消费者 {
    public static void main(String[] args) {
        ExecutorService poll = Executors.newFixedThreadPool(8);
        Product<Integer> pro = new Product<>(3);
//        poll.submit(new Producer(pro));
//        poll.submit(new Producer(pro));
        poll.submit(new Producer(pro));
        poll.submit(new Producer(pro));
        poll.submit(new Consumer(pro));
        poll.submit(new Consumer(pro));
        poll.submit(new Consumer(pro));
        poll.submit(new Consumer(pro));
        poll.shutdown();
    }

}
