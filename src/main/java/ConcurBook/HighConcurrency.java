package ConcurBook;


public class HighConcurrency {
    abstract static class c1 extends HighConcurrency{

    }
    public static void main(String[] args) throws InterruptedException {
        final Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 引用t1线程，等待t1线程执行完
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t1");
            }
        });
        // 1.现在有T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行
        final Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 引用t1线程，等待t1线程执行完
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t2");
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 引用t2线程，等待t2线程执行完
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t3");
            }
        });
        t3.start();//这里三个线程的启动顺序可以任意，大家可以试下！
        t2.start();
        Thread.sleep(2000);
        t1.start();
    }



}
