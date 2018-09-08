package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc886 {
    boolean[] marked;
    boolean[] color;

    public boolean possibleBipartition(int N, int[][] dislikes) {
        Map<Integer,List<Integer>> graph = new HashMap<>(N);
        for(int[] edge:dislikes){
            List<Integer> nei = graph.getOrDefault(edge[0], new ArrayList<>());
            List<Integer> nei2 = graph.getOrDefault(edge[1], new ArrayList<>());
            nei.add(edge[1]);
            nei2.add(edge[0]);
            graph.put(edge[0],nei);
            graph.put(edge[1],nei2);

        }
//        System.out.println(graph);
        marked = new boolean[N+1];
        color = new boolean[N+1];
        for (int v:graph.keySet()) {
            if(!marked[v]&&!dfs(graph,v))return false;

        }
        return true;
    }
    private boolean dfs(Map<Integer,List<Integer>> graph,int v){
        marked[v] = true;
        for(int w :graph.get(v)){
            if(!marked[w]) {
                color[w] = !color[v];
                if (!dfs(graph, w)) return false;

            }else if(color[w]==color[v])return false;
        }
        return true;
    }

    public static void main(String[] args) {
        lc886 sl = new lc886();
        System.out.println(sl.possibleBipartition(5,new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}}));
        System.out.println(sl.possibleBipartition(4,new int[][]{{1,2},{1,3},{2,4}}));
    }

}
