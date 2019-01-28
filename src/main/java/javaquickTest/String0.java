package javaquickTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class String0 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        String[] strings = list.toArray(new String[0]);
        System.out.println(Arrays.toString(strings));
    }
}
