package leetcode;

import java.util.*;

public class lc684 {
    //dfs找路径
    private boolean hasPath(int cur,int target,Map<Integer,List<Integer>> graph,HashSet visited){
        if(cur== target)return true;
        visited.add(cur);
        List<Integer> neib = graph.get(cur);

        for (int next:neib) {
            if(visited.contains(next))continue;
            if(hasPath(next,target,graph,visited))return true;

        }
        return false;
    }
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for (int[] edge:edges) {
            graph.putIfAbsent(edge[0],new ArrayList<>());
            graph.putIfAbsent(edge[1],new ArrayList<>());
            HashSet<Integer> visited= new HashSet<>();
            if(hasPath(edge[0],edge[1],graph,visited)){
                return edge;
            }
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);


        }
        return new int[]{};
    }
    public int[] findRedundantConnection2(int[][] edges) {
        int[] parent = new int[6];
        for (int i = 0; i <parent.length ; i++) {
            parent[i]=i;
        }
        for(int[] edge:edges){
            System.out.println(Arrays.toString(parent));
            int f = edge[0],t=edge[1];
            if(find(parent,f)==find(parent,t))return edge;
            else parent[find(parent,f)]=find(parent,t);
        }
        return new int[2];
    }
    private int find(int[] parent,int f){
        System.out.println(Arrays.toString(parent));
        if(f!=parent[f]){
            parent[f]=find(parent,parent[f]);
        }
        return parent[f];
    }
    //无向连通图
    public int findFather(int[] father,int i){
        if(father[i]==i)return i;
         return findFather(father,father[i]);
    }
    public void uni(int[] father,int i,int j){
        System.out.println(Arrays.toString(father));
        int fi = findFather(father,i);
        int fj = findFather(father,j);
        father[fi] = fj;
    }
    public int[] myself(int[][] edges) {
        //顶点数
        int[] father = new int[edges.length+1];
        for (int i = 0; i <father.length ; i++) {
            father[i]=i;
        }
        for (int i = 0; i <edges.length ; i++) {
            int[] edge =edges[i];
            if(findFather(father,edge[0])==findFather(father,edge[1]))return edge;
            uni(father,edge[0],edge[1]);
        }
        return new int[]{};
    }
    public static void main(String[] args) {
        lc684 sl = new lc684();
        int[] redundantConnection2 = sl.myself(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}});
        System.out.println(Arrays.toString(redundantConnection2));
    }
}
