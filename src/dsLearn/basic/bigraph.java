package dsLearn.basic;

import com.sun.beans.util.Cache;

import java.util.*;

public class bigraph {
    public static void main(String[] args) {

        bigraph sl = new bigraph();
        System.out.println(sl.isBipartite(new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}}));
        System.out.println(sl.isBipartite(new int[][]{{1, 2,3}, {0, 2}, {0,1, 3}, {0, 2}}));
        System.out.println(sl.isBipartite(new int[][]{{2,3,5,6,7,8,9},{2,3,4,5,6,7,8,9},{0,1,3,4,5,6,7,8,9},{0,1,2,4,5,6,7,8,9},{1,2,3,6,9},{0,1,2,3,7,8,9},{0,1,2,3,4,7,8,9},{0,1,2,3,5,6,8,9},{0,1,2,3,5,6,7},{0,1,2,3,4,5,6,7}}));

    }

    private boolean[] marked;
    private boolean[] color;
//    private boolean isTwo =true;
    public boolean isBipartite(int[][] graph) {
//        Map<Integer,List<Integer>> map = new HashMap<>();
//        for(int i=0;i<graph.length;i++){
//            ArrayList<Integer> nes = new ArrayList<>();
//
//            for(int ne:graph[i])
//                nes.add(ne);
//            map.putIfAbsent(i,nes);
//
//        }
//        System.out.println(map);
        marked = new boolean[graph.length];
        color = new boolean[graph.length];
        for (int s = 0; s <graph.length ; s++) {
            if(!marked[s]&&!dfs(graph,s))return false;
        }
//        System.out.println(Arrays.toString(color));
        return true;

    }
    private boolean dfs(int[][] G,int v){
        marked[v] = true;
        for (int w :G[v]) {
            if(!marked[w]){
                color[w] = !color[v];
               if(!dfs(G,w))return false;
            }
            else if(color[w]==color[v])return false;

        }
        return true;
    }
}
