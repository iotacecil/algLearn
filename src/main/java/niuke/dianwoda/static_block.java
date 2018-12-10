package niuke.dianwoda;

class A{
   int a = 1;

    {
        System.out.println("???A");
    }
    static {
        System.out.println("AS");
    }
    public A(){
        System.out.println("AC");
    }
}
class B extends A{
    static {
        System.out.println("BS");
    }
    public B(){
        System.out.println("BC");
    }
}
public class static_block {
    public static void main(String[] args) {
        new B();
    }

}
