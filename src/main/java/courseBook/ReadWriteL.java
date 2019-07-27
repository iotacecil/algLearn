package courseBook;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteL {


    static Object Syn = new Object();
    static Object wlock = new Object();
    static Object rlock = new Object();
    static CountDownLatch latch = new CountDownLatch(6);

    class Reader implements Runnable {

        int quantity;

        Reader(int quantity) {
            this.quantity = quantity;
        }

        @Override
        public void run() {
            synchronized (Syn) {
                while (quantity > 0) {

                    System.out.println("读者" + data);
                }
                quantity--;
                latch.countDown();
            }

        }
    }

    class Writer implements Runnable {
        int quantity;

        Writer(int quantity) {
            this.quantity = quantity;
        }

        @Override
        public void run() {
            synchronized (wlock) {
                synchronized (rlock) {
                    while (quantity > 0) {
                        data = new Random().nextInt(10);
                        System.out.println("写" + data);
                        quantity--;
                    }
                }
                latch.countDown();
            }
        }
    }

    @Test
    void testReaderWriter() throws InterruptedException {
        ExecutorService poll = Executors.newFixedThreadPool(6);
        for (int i = 0; i < 3; i++) {
            poll.submit(new Reader(3));
        }

        for (int i = 0; i < 3; i++) {
            poll.submit(new Writer(3));

        }
        poll.shutdown();
        while (!poll.awaitTermination(10, TimeUnit.SECONDS)) {

        }
    }


    int readcnt = 0;
    int writecnt = 0;
    Semaphore readsema = new Semaphore(0);
    Semaphore writesema = new Semaphore(1);
    //    AtomicInteger rd = new AtomicInteger(0);
//    AtomicInteger wd = new AtomicInteger(0);
    private Object data = null;
    ReadWriteLock rwlock = new ReentrantReadWriteLock();


    public void get() {
        rwlock.readLock().lock();
        //读数据
        lockread();
        try {
            System.out.println("开始读" + data);
            Thread.sleep(1000);
            System.out.println("读结束" + data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            unlockread();
            //rwlock.readLock().unlock();
        }
    }

    private void put(Object in) {
        //  rwlock.writeLock().lock();
        lockwrite();
        try {
            System.out.println("开始写" + in);
            Thread.sleep(500);
            this.data = in;
            System.out.println("写结束" + data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
//            rwlock.writeLock().unlock();
            unlockwrite();
        }
    }


    class PV {
        int value;

        public PV(int v) {
            this.value = v;
        }

        public synchronized void P() {
            value = value - 1;
            if (value < 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public synchronized void V() {
            value = value + 1;
            if (value <= 0) {
                this.notifyAll();
            }
        }
    }


    public int swap(char[] num, int i, int j) {
        char tmp = num[i];
        num[j] = num[i];
        num[i] = num[j];

        return Integer.parseInt(new String(num));

    }

    @Test
    public void testsema() {

    }


    @Test
    public void testRWLock() throws InterruptedException {
        ReadWriteL testobj = new ReadWriteL();
        CountDownLatch latch = new CountDownLatch(6);
        ExecutorService poll = Executors.newFixedThreadPool(6);
        for (int i = 0; i < 3; i++) {
            poll.submit(new Runnable() {
                @Override
                public void run() {
                    testobj.get();
                    latch.countDown();
                }
            });

            poll.submit(new Runnable() {
                @Override
                public void run() {
                    testobj.put(new Random().nextInt(8));
                    latch.countDown();

                }
            });

        }
//        latch.await();
        poll.shutdown();
        while (!poll.awaitTermination(10, TimeUnit.SECONDS)) {

        }
        ;
    }

    public void lockread() {
        while (writecnt > 0) {
            synchronized (this) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
//        System.out.println("读"+readcnt +" "+data);
        readcnt++;
        System.out.println("读加锁" + readcnt + " " + data);
    }

    public void unlockread() {
        readcnt--;
        synchronized (this) {
            notifyAll();
        }
    }

    public void lockwrite() {
        while (writecnt > 0 || readcnt > 0) {
            synchronized (this) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        // 让写占个坑
        writecnt++;
        System.out.println("开始写" + writecnt + " " + data);
    }

    public void unlockwrite() {
        writecnt--;
        synchronized (this) {
            notifyAll();
        }
    }
}
