package dsLearn.basic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class DepthFirstOrder {
    private boolean[] marked;
    private List<Integer> pre;
    private List<Integer> post;
    private Deque<Integer> reversePost;

    public DepthFirstOrder(int n,int[][] edges){
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i <n ; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] edge:edges){
            graph[edge[0]].add(edge[1]);
        }
        marked = new boolean[n];
        pre = new ArrayList<>();
        post = new ArrayList<>();
        reversePost = new ArrayDeque<>();

        for (int i = 0; i <n ; i++) {
            if(!marked[i])dfs(graph,i);
        }
    }
    private void dfs( List<Integer>[] graph ,int v){
        pre.add(v);
        marked[v] = true;
        for(int w :graph[v]){
            if(!marked[w])
                dfs(graph,w);
        }
        post.add(v);
        reversePost.push(v);
    }
//    public Iterable<Integer> pre(){
//        return pre;
//    }
//    public Iterable<Integer> post(){
//        return post;
//    }
//    public Iterable<Integer> reversePost(){
//        return reversePost;
//    }

    public static void main(String[] args) {
//        DepthFirstOrder sl = new DepthFirstOrder(13,new int[][]{{0,1},{0,5},{0,6},{2,0},{2,3},{3,5},{5,4},{6,4},{6,9},{7,6},{8,7},{9,10},{9,11},{9,12},{11,12}});
        DepthFirstOrder s2 = new DepthFirstOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}});
//        System.out.println(sl.pre);
//        System.out.println(sl.post);
//        System.out.println(sl.reversePost);
        System.out.println(s2.pre);
    }
}
