package javaquickTest.lambdaStream;

public class lambdaLearn {
    public static void main(String[] args) {
        Object ok = new Runnable() {
            @Override
            public void run() {
                System.out.println("ok");
            }
        };
        new Thread((Runnable)ok).start();

        new Thread(()->System.out.println("ok")).start();
        Object target3 = (Runnable)()->System.out.println("ok");
        new Thread((Runnable)target3);
    }



}
