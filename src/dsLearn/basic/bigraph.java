package dsLearn.basic;

import com.sun.beans.util.Cache;

import java.util.*;

public class bigraph {
    public static void main(String[] args) {
        List<String> l1 = new ArrayList<String>();
        List<Integer> l2 = new ArrayList<Integer>();

        System.out.println(l1.getClass() == l2.getClass());
    }

    private boolean[] marked;
    private boolean[] color;
    private boolean isTwo =true;
//    public boolean isBipartite(int[][] graph) {
//        int[] ss = {1,2};
//        List<int[]> ints1 = Arrays.asList(ss);
//        Map<Integer,List<Integer>> map = new HashMap<>();
//        for(int i=0;i<graph.length;i++){
//            List<int[]> ints = Arrays.asList(graph[i]);
//            map.putIfAbsent(i, );
//
//        }
//
//    }
}
