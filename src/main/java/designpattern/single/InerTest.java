package designpattern.single;

public class InerTest {
    public static void main(String[] args) {
        Thread thread = new Thread(new InnerThread());
        Thread thread2 = new Thread(new InnerThread());
        thread.start();
        thread2.start();
        System.out.println("end");

    }
}
