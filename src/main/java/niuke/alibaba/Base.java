package niuke.alibaba;


public class Base {
    public String baseName = "base";

    public Base() {
        System.out.println(baseName);
    }

    public void callName() {
        System.out.println(baseName);
    }

    static class Sub extends Base {
        public String baseName = "sub";

        public void callName() {
            System.out.println(baseName);
        }
    }

    public static void main(String[] args) {
        Base b = new Sub();

        b.callName();
        System.out.println(b.baseName);
    }
}