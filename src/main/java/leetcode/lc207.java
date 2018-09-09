package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// n courses you have to take, labeled from 0 to n-1.
//2, [[1,0],[0,1]]
public class lc207 {
    private boolean hasCycle;
    public boolean cycle2(int numCourses, int[][] prerequisites) {

//        edgeTo = new int[numCourses];
//        if(prerequisites.length<1)return true;
        marked =new boolean[numCourses];
        List<Integer>[] graph=new ArrayList[numCourses];
        for (int i = 0; i <numCourses ; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge :prerequisites) {

            graph[edge[0]].add(edge[1]);

        }
        System.out.println(Arrays.toString(graph));
        for (int i = 0; i < numCourses; i++) {
            if(!marked[i])dfs(graph,i,i);
        }
        return hasCycle;
    }
    private void dfs(List<Integer>[] G,int v,int u){
        marked[v] = true;
        for(int w:G[v]){
            if(!marked[w])dfs(G,w,v);
            else if(w!=u)hasCycle=true;
        }
    }
    //算法4
    private boolean[] marked;
//    private int[] edgeTo;
//    private Deque<Integer> cycle;//环
    boolean cycle=true;
    private boolean[] onStack;
    public boolean cycle(int numCourses, int[][] prerequisites) {
        onStack = new boolean[numCourses];
//        edgeTo = new int[numCourses];
        marked =new boolean[numCourses];
        List<Integer>[] graph=new ArrayList[numCourses];
        for (int i = 0; i <numCourses ; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge :prerequisites) {

            graph[edge[0]].add(edge[1]);

        }
        System.out.println(Arrays.toString(graph));
        for (int i = 0; i < numCourses; i++) {
            if(!marked[i])dfs(graph,i);
        }
        return cycle;
    }
    private void dfs(List<Integer>[] graph,int v){
//        System.out.println(Arrays.toString(onStack));
        if(graph[v].size()<1)return;

        onStack[v] =true;
        marked[v] =true;

        for(int w:graph[v]){

//            if(cycle!=null) return;
            if(!marked[w]){
//                edgeTo[w] = v;
                dfs(graph,w);
            }
            else if(onStack[w]){
                System.out.println("v:"+v+"w:"+w);
                System.out.println(Arrays.toString(onStack));
                cycle=false;
                return;
//                cycle = new ArrayDeque<>();
//                for (int x = v; x !=w ; x=edgeTo[x]) {
//                    cycle.push(x);
//                }
//                cycle.push(w);
//                cycle.push(v);
            }

        }
        onStack[v] =false;
    }



    //100%
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        int[] pre = new int[numCourses], pre2 = new int[numCourses];
        int[][] inv = new int[prerequisites.length][2];
        for(int i = 0; i < prerequisites.length; i++) {
            inv[i][1] = prerequisites[i][0];
            inv[i][0] = prerequisites[i][1];
        }
        for(int i = 0; i < numCourses; i++) {
            pre[i] = i;
            pre2[i] = i;
        }
        return loopCheck(prerequisites, pre) && loopCheck(inv, pre2);
    }
    private boolean loopCheck(int[][] prerequisites, int[] pre) {
        for(int[] pair : prerequisites) {
            int parent = pair[0], child = pair[1];
            while(pre[child] != child) {
                child = pre[child];
                if(child == parent) return false;
            }
            pre[parent] = child;
        }
        return true;
    }
    // 56%
    List[] graph_;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph_ = new ArrayList[numCourses];
       for(int i =0;i<numCourses;i++){
           graph_[i] = new ArrayList<Integer>();
       }
        for(int[] back:prerequisites){
            int pre = back[0];
            int lesson = back[1];
            graph_[lesson].add(pre);
        }
        System.out.println(Arrays.toString(graph_));
        //0没访问过，1正在访问，2 访问过了
        int[] visit = new int[numCourses];
        for(int i =0;i<numCourses;i++){
            if(hasCircle(i,visit))return false;
        }
        return true;
    }
    private boolean hasCircle(int idx,int[] visited){
        if(visited[idx]==1)return true;
        if(visited[idx]==2)return false;
        visited[idx]=1;
        List<Integer> neib = graph_[idx];
        for(int i:neib){
            if(hasCircle(i,visited))return true;
        }
        visited[idx]=2;
        return false;

    }

    public static void main(String[] args) {
        lc207 sl = new lc207();
//        System.out.println(sl.cycle(4, new int[][]{{0, 3}, {1, 3}, {3, 2}, {2, 1}}));
//        System.out.println(sl.cycle(2, new int[][]{{1,0},{0,1}}));
        System.out.println(sl.cycle(4, new int[][]{{2,0},{1,0},{3,1},{3,2},{1,3}}));

        //System.out.println(sl.canFinish(2, new int[][]{{1, 0}, {0, 1}}));

    }
}
