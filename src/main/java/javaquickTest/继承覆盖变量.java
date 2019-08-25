package javaquickTest;

class base {
    int a = 19;
    static int b = 111;

    public base(int a) {
        System.out.println("base");
        this.a = a;
    }

    public base() {
        System.out.println("basssss");
    }
}

class child extends base {
    int a = 99;
    static int b = 999;

    public child() {
        System.out.println("child");
    }
}

public class 继承覆盖变量 {
    public static void main(String[] args) {
        child ch = new child();
        base ba = new child();
        System.out.println(ch.a);
        System.out.println(ch.b);

        System.out.println(ba.a);
        System.out.println(ba.b);

    }
}
