package leetcode;

import java.util.*;

public class lc310 {
   // int minval = Integer.MAX_VALUE;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer>[] map = new ArrayList[n];
        for (int i = 0; i <n ; i++) {
            map[i] = new ArrayList<>();
        }
        List<Integer> rst = new ArrayList<>();

        for(int[] edge:edges){
            map[edge[0]].add(edge[1]);
            map[edge[1]].add(edge[0]);
        }

        List<Integer> leaf = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (map[i].size() == 1) {
                leaf.add(i);
            }
        }
        while (true) {
            List<Integer> tmp = new ArrayList<>();
            // lef = <0,1,2,5>
            n -= leaf.size();
            if(n<=0){
                return leaf;
            }
            for(int i:leaf){
                Integer center = map[i].get(0);
                map[i] = null;
                map[center].remove(Integer.valueOf(i));
                if (map[center].size() ==1) tmp.add(center);
            }
            leaf = new ArrayList<>(tmp);
        }
    }



    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
        lc310 sl = new lc310();
        System.out.println(sl.findMinHeightTrees(n, edges));
    }
}
