package javaquickTest;

public class Finalization {
    public static Finalization finalization;

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalize");
        finalization = this;
    }

    public static void main(String[] args) {
        Finalization f = new Finalization();
        System.out.println("初始化完成：" + f);
        f = null;
        // 会触发finalize()
        System.gc();
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("完成GC："+f);
        System.out.println(finalization);
        System.out.println(f+" "+finalization);
    }
}
