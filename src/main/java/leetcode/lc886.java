package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc886 {
    public boolean possibleBiparitition(int N,int[][] dislikes){
        int[][] graph = new int[N][N];
        //边集->无向图 邻接矩阵
        for(int[] d:dislikes){
            graph[d[0]-1][d[1]-1] = 1;
            graph[d[1]-1][d[0]-1] = 1;
        }
        int[] group = new int[N];
        for (int i = 0; i < N; i++) {
            if(group[i] == 0&& !dfs2d(graph,group,i,1))return false;
        }
        return true;
    }
    //可不可以分到g组
    private boolean dfs2d(int[][] graph,int[] group,int idx,int g){
        group[idx] = g;
        //行是邻边
        for (int i = 0; i < graph.length; i++) {
            if(graph[idx][i] == 1){
                if(group[i] == g){
                 return false;
                }
                if(group[i] == 0&&!dfs2d(graph,group,i,-g))return false;

            }
        }
        return true;
    }
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
