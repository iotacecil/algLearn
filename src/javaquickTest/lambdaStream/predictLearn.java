package javaquickTest.lambdaStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class predictLearn {
    private static List<String> filter(List<String>list,Predicate<String> prd){
        List<String> res=new ArrayList<>();
        for(String s:list){
            if(prd.test(s))res.add(s);
        }
        return res;
    }
    public static void main(String[] args) {
        Predicate<Integer> predicate = i->i>0;
        System.out.println(predicate.test(9));

        List<String> words = Arrays.asList("LL","LB","EE");
        List<String> sig = filter(words,(d)->d.contains("L"));
        System.out.println(sig);
        IntPredicate predicateint = i->i>0;
        IntConsumer intConsumer = System.out::println;
        int i =3;
        intConsumer.accept(i);
        System.out.println(i);
        Consumer<String> consumer = s-> System.out.println(s);
        consumer.accept("等待输出");
    }
}
