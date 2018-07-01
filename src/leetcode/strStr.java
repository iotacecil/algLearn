package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Person2{

    private String name;
    public Person2(String name){
        this.name= name;
    }
    public static <T> T[] fun1(T...arg){
        return arg;
    }
    public boolean equals(Object obj){
        if (this==obj){
            return true;
        }
        if(obj instanceof Person2){
            Person2 obj2= (Person2)obj;
            return name.equals(obj2.name);
        }
        return false;
    }
}
class Solution7{
    private final char a= 'a';
    public Solution7(){
    }
    public int strr(String haystack, String needle) {
        Object a = new Object();
        Solution7 aa = (Solution7)a;
        int b=aa.a;
        return haystack.indexOf(needle);
    }
}
public class strStr {
    public static void main(String[] args){
        int[] input = new int[]{1,2,4,5};
        int[] input2 = {1,2,4,5};
        int num = 3;
        Person2 p1 = new Person2("p1");
        Person2 p2 = new Person2("p1");
        Integer[] abc = Person2.fun1(1,2,3,4,5);
        System.out.println("Integer[1]");
        System.out.println(p1.equals(p2));
        Set<Person2> per = new HashSet<>();
        per.add(p1);

        System.out.println("set:"+per.size());
        System.out.println(per.contains(p2));


        List<Person2> al = new ArrayList();
        al.add(p1);
        System.out.println("list:"+al.size());
        System.out.println(al.contains(p2));

        char[] chararr = {'a','b','c'};
        char[] chararr2 = chararr;
        chararr[2]='x';
        System.out.println(chararr2);
    }
}
