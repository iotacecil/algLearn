package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc210 {
    private boolean[] marked;
//    private List<Integer> pre;
    private List<Integer> post;
//    private Deque<Integer> reversePost;
    private boolean cycle = true;
public int[] findOrder(int n, int[][] edges) {

        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i <n ; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] edge:edges){
            graph[edge[0]].add(edge[1]);
        }
//    System.out.println(Arrays.toString(graph));
        marked = new boolean[n];
        onStack= new boolean[n];

//        pre = new ArrayList<>();
        post = new ArrayList<>();
//        reversePost = new ArrayDeque<>();

        for (int i = 0; i <n ; i++) {
            if(!marked[i])dfs(graph,i);
        }
        if(!cycle){
            return new int[]{};
        }

//    Integer[] integers = pre.toArray(new Integer[0]);
    int[] array = post.stream().mapToInt(i->i).toArray();
    return array ;
    }
    private boolean[] onStack;
    private void dfs( List<Integer>[] graph ,int v){
//    if(graph[v].size()<1)return;
        onStack[v]=true;
//        pre.add(v);
        marked[v] = true;
        for(int w :graph[v]){
            if(!marked[w])
                dfs(graph,w);
            else if(onStack[w]){
                cycle = false;
                return;
            }
        }
//        System.out.println(post);
        post.add(v);
//        reversePost.push(v);
        onStack[v] = false;
    }

    public static void main(String[] args) {

        lc210 sl = new lc210();
        System.out.println(Arrays.toString(sl.findOrder(2, new int[][]{{0, 1}})));
        System.out.println(Arrays.toString(sl.findOrder(2, new int[][]{{1, 0},{0, 1}})));
    }
}
