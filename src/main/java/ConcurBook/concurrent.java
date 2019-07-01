package ConcurBook;
/*
子线程循环10次，接着主线程循环100次，接着又回到子线程循环10次，接着在回到主线程循环100次，如此循环50次，请写出程序。
 */

public class concurrent {

    public static void main(String[] args) {

        final Business business= new Business();
        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int j = 1; j <= 50; j++) {
                    business.sub(j);
                }
            }
        }).start();
        for (int j = 1; j <= 50; j++) {
            business.main(j);
        }

    }

}

class Business {
    private volatile boolean bshouldSub = true;//子线程和主线程通信信号

    public synchronized void sub(int j) {
        if (!bshouldSub) {
            try {
                this.wait();
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
        for (int i = 1; i <= 10; i++) {
            System.out.println("子线程内" + i
                    + ",第" + j+"个子线程");

        }
        bshouldSub = false;//运行结束，设置值为FALSE 让主程序运行
        this.notify();//唤醒等待的程序

    }

    public synchronized void main(int j) {
        if (bshouldSub) {//如果bshouldsub=true ，等待  让子程序运行
            try {
                this.wait();
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
        for (int i = 1; i <= 100; i++) {
            System.out.println("内循环 " + i
                    + ",第" + j+"个主线程");
        }
        bshouldSub = true;//让子程序运行
        this.notify();//唤醒等待的一个程序
    }
}




