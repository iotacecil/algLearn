package leetcode;

import java.util.*;

 class State{
         int mask,source;
         State(int s,int m){
         mask=m;
         source=s;
         }
         }
public class lc847 {

    //dp
    public int shortestPathLengthDP(int[][] graph) {
        int n = graph.length;
        int[][] dp = new int[n][1<<n];
        Deque<State> que = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i],Integer.MAX_VALUE);
            dp[i][1<<i]=0;
            que.add(new State(i,1<<i));
        }
        while(!que.isEmpty()){
            State state = que.poll();
            for(int next:graph[state.source]){
//                if((state.mask&(1<<next))!=0) {
//                    System.out.println("访问重复节点");
//                    continue;
//                }
                int nextMask = state.mask|(1<<next);
                if(dp[next][nextMask]>dp[state.source][state.mask]+1){
                    dp[next][nextMask] = dp[state.source][state.mask]+1;
                    que.add(new State(next,nextMask));
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <n ; i++) {
            res = Math.min(res, dp[i][(1<<n)-1]);
        }
        return res;
    }

        //dfs有问题
    int res;
    private  void dfs(int[][] graph,List<Integer> cur,int[] visited,int cnt){
        if(res == graph.length)return;
        if(cnt == graph.length){
            res = Math.min(res,cur.size());
            return;
        }
        if(cur.size()>=res)return;
        int pos = cur.get(cur.size()-1);
        int minv = Integer.MAX_VALUE;
        for(int n:graph[pos])minv = Math.min(minv,visited[n]);
        for(int n:graph[pos]){
            if(minv == visited[n]){
                cur.add(n);
                if(visited[n]!=0)cnt++;
                visited[n]++;
                dfs(graph,cur,visited,cnt);
                visited[n]--;
                if(visited[n]!=0)cnt--;
                cur.remove(cur.size()-1);
            }
        }
    }
    public int shortestPathLength(int[][] graph) {
         res = Integer.MAX_VALUE;
        int n = graph.length;
        int[] visited = new int[n];
        int cnt = 0;
        List<Integer> cur = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cur.add(i);
            visited[i]++;
            cnt++;
            dfs(graph,cur,visited,cnt);
            cnt--;
            visited[i]--;
            cur.remove(cur.size()-1);

        }
        return res-1;
    }
    //dp

    public static void main(String[] args) {
        lc847 sl = new lc847();
        System.out.println(sl.shortestPathLengthDP(new int[][]{{1, 2, 3}, {0}, {0}, {0}}));
    }
}
