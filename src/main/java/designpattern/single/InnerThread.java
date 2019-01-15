package designpattern.single;

public class InnerThread implements Runnable{

    @Override
    public void run() {
        StaticInnerClassSingle instance = StaticInnerClassSingle.getInstance();
        System.out.println(Thread.currentThread().getName()+instance);

    }
}
