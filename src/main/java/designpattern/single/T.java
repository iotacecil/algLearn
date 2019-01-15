package designpattern.single;

public class T implements Runnable{

    @Override
    public void run() {
        LazySinglenton instance = LazySinglenton.getInstance();
        System.out.println(Thread.currentThread().getName()+instance);
    }
}
