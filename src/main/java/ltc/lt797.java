package ltc;

import java.util.ArrayList;
import java.util.List;

public class lt797 <T>{
//    T[] a = new T[2];
    T[] a = (T[])new Object[3];
    public static void main(String[] args) {
        //java不支持泛型数组
//        Object[] obj = new ArrayList<String>[10];
        //因为支持了之后 类型擦除不报错
//        obj[0]=new ArrayList<Integer>();
//        @SuppressWarnings("unchecked")

        List<Integer>[] gen = (List<Integer>[]) new ArrayList[10];
        //然而并没有骗过去
        gen[0] = new ArrayList();
        gen[0].add(1);


    }
}
