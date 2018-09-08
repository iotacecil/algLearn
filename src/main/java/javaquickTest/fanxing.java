package javaquickTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fanxing {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        List<String> l1 = new ArrayList<String>();

        List<Integer> l2 = new ArrayList<Integer>();
        l2.add(1);
        Method madd = l2.getClass().getDeclaredMethod("add",Object.class);
        madd.invoke(l2,"abc");
        System.out.println(l1.getClass() == l2.getClass());
        System.out.println(l2);
        List<?>[] obj = new ArrayList<?>[10];
        List<String> integers;
        integers = Arrays.asList("adaf","dfadfa");
        String[] strs = {"adaf","dfadfa"};
        Object[] objects1 = l1.toArray();
        obj[1]=integers ;
//        它只能读，不能写
//        obj[1].add(1);
        System.out.println(obj[1].get(1));
        List<?> objects = obj[1];
    }
}
