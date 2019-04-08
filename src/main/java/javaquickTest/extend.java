package javaquickTest;

import java.util.ArrayList;
import java.util.List;

class Aa {
    String name="a";
    String go(){
        return "- function in A";
    }
}

public class extend extends Aa{
    String name="b";
    String go(){
        return "- function in B";
    }
    public static void main(String[] args) {
        Aa a= new extend();
        List<Object> lo;
        List<String> ls  =  new ArrayList<>();


        System.out.println(a.name+a.go());
    }

}
