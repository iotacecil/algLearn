package javaquickTest;



public class Stringintern {
    public static void main(String[] args) {
        String s = new String("a");
        s.intern();
        String s2 = "a";
        //false
        System.out.println(s==s2);
        String s3 = new String("a")+new String("a");
        s3.intern();
        String s4 = "aa";
        //true
        System.out.println(s3==s4);



    }
}
