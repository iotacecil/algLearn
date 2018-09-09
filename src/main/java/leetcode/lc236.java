package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class lc236 {
    public static void main(String[] args) {
        Deque<Integer> list = new LinkedList<>();

        Integer[] listarr = new Integer[list.size()];
        list.toArray(listarr);
        Integer[] objects = (Integer[])list.toArray();
        List<Integer> rst = new ArrayList<>();
        rst.addAll(list);
    }
}
