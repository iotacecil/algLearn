package javaquickTest;

import java.util.ArrayList;

public class byvalue {
    // 不能再方法中改变对象的引用
    public static void change(ArrayList<Integer> a){
        ArrayList<Integer> b = new ArrayList<>();
        b.add(3);
        b.add(4);
        b.add(5);
        a = b;
    }
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(0);
        a.add(1);
        a.add(2);

      change(a);
        System.out.println(a);
    }
}
