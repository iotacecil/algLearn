package ConcurBook;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ReadWriteLock{
    private int readers = 0;
    private int writers = 0;
    private int writerquests = 0;
    public synchronized void lockRead() throws InterruptedException {
        while (writers>0 || writerquests >0){
            System.out.println("读锁等待");
            wait();
        }
        System.out.println("获取读");
        readers++;
    }

    public synchronized void unlockRead(){
        readers--;
        notifyAll();
        System.out.println("读释放");

    }

    public synchronized void lockWrite() throws InterruptedException {
        writerquests++;
        while (readers>0 || writers>0){
            wait();
        }
        writerquests--;
        writers++;
    }
    public synchronized void unlockWrite(){
        writers--;
        notifyAll();
    }
}

public class 读写锁 {

    //写操作的请求比对读操作的请求更重要，就要提升写请求的优先级
    //只有当没有线程正在锁住 ReadWriteLock 进行写操作，且没有线程请求该锁准备执行写操作时，才能保证读操作继续。
    public static void main(String[] args) {
        ExecutorService poll = Executors.newFixedThreadPool(20);
//        for (int i = 0; i <120 ; i++) {
//            new Runnable() {
//                @Override
//                public void run() {
//
//                }
//            }
//
//        }


    }

}
