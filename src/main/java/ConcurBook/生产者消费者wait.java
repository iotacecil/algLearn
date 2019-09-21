package ConcurBook;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class 生产者消费者wait {
    static class Consumer implements Runnable {
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

    static class Producer implements Runnable {
        Product<Integer> pro;
        AtomicInteger a = new AtomicInteger(0);

        Producer(Product<Integer> p) {
            pro = p;
        }

        @Override
        public void run() {
            int i = 0;
            while (i++ < 5) {
//            pro.produce(1);
                pro.produce(a.getAndAdd(1));
                System.out.println("生产");
            }
        }
    }

    static class Product<T> {
        T[] arr;
        int size = 0;
        final Lock lock = new ReentrantLock();
        final Condition notFull = lock.newCondition();
        final Condition notEmpty = lock.newCondition();
        int putidx, takeidx, cnt;

        public Product(int capacity) {
            size = capacity;
            this.arr = (T[]) new Object[capacity];
            ;
        }

        public void produce(T a) {
            lock.lock();
            while (cnt == arr.length) {
                try {
                    notFull.await();

                    arr[putidx] = a;
                    if (++putidx == arr.length) putidx = 0;
                    ++cnt;
                    notEmpty.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }


        }

        public T consume() {
            lock.lock();
            T t = null;
            while (cnt == 0) {
                try {
                    notEmpty.await();

                    t = arr[takeidx];
                    if (++takeidx == arr.length) takeidx = 0;
                    --cnt;
                    notFull.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
            return t;


        }


    }

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
