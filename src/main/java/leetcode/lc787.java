package leetcode;
//Input:
//n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
//src = 0, dst = 2, k = 1
//Output: 200

import java.util.*;
//todo nexttime
public class lc787 {

    //dp
    //14ms
    public int findCheapestPriceDp(int n, int[][] flights, int src, int dst, int k) {
        int max = 10001*(k+2);
        //走1~k+1步
        int[][] dp = new int[k+2][n];
        for(int[] ints:dp){
            for (int j = 0; j < n; j++) {
                ints[j] = max;
            }
        }
        dp[0][src] = 0;
        for (int i = 1; i <= k+1; i++) {
            //走i步走到src ， cost 0
            dp[i][src] = 0;
            for(int[] flight:flights){
                dp[i][flight[1]] = Math.min(dp[i][flight[1]],dp[i-1][flight[0]]+flight[2]);
            }
        }
        return dp[k+1][dst]>=max?-1:dp[k+1][dst];
    }


//    94ms
    //使用了广度优先搜索
    //固定了一个顶点作为源节点然后找到该顶点到图中所有其它节点的最短路径，产生一个最短路径树
    public int findCheapestPriceDj(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> graph = edgeC2graph(flights, n);
        //每次选cost最小的先扩展
        Queue<int[]> que = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        que.add(new int[]{0,src,k+1});
        while(!que.isEmpty()){
            int[] top = que.remove();
            int price = top[0];
            int city = top[1];
            int stops = top[2];
            if(city == dst)return price;
            if(stops>0){
                Map<Integer, Integer> adj = graph.getOrDefault(city, new HashMap<>());
                for(int a:adj.keySet()){
                    que.add(new int[]{price+adj.get(a),a,stops-1});
                }
            }
        }
        return -1;
    }


    //有点问题
    public int findCheapestPriceBFS(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> graph = edgeC2graph(flights, n);
//        System.out.println(graph);
        int ans = Integer.MAX_VALUE;
        Deque<int[]>que = new ArrayDeque<>();
       // que里是当前节点，从source到当前节点的cost
        que.add(new int[]{src,0});
        int step = 0;
        while(!que.isEmpty()){
            int size = que.size();
            while (size-->0){
                int[] front = que.poll();
                int curr = front[0];
                int cost = front[1];
                if(curr==dst){
                    ans = Math.min(ans,cost);
                }
                Map<Integer, Integer> adj = graph.getOrDefault(src,new HashMap<>());
                for (int key : adj.keySet()) {
                    if (cost + adj.get(key) > ans) continue;
                    que.add(new int[]{key,adj.get(key)+cost});
                }
            }
            if(step++>K)break;
        }
        return ans == Integer.MAX_VALUE?-1:ans;

    }
    //229ms
    //u,v,cost
    Map<Integer, Map<Integer, Integer>> graph;
    boolean[] visited;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        graph = new HashMap<>(n);
        for (int[] edge : flights) {
            graph.putIfAbsent(edge[0], new HashMap<>());
            graph.get(edge[0]).put(edge[1], edge[2]);
        }
        visited = new boolean[n];
        visited[src] = true;
        dfs(graph, src, dst, K + 1, 0);


        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    int ans = Integer.MAX_VALUE;



    Map<Integer, Map<Integer, Integer>> edgeC2graph(int[][]edges,int n){
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>(n);
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new HashMap<>());
            graph.get(edge[0]).put(edge[1], edge[2]);
        }
        return graph;
    }
    private void dfs(Map<Integer, Map<Integer, Integer>> graph, int src, int dst, int k, int cost) {
        if (src == dst) {
            ans = cost;
            return;
        }
        if (k == 0) return;
        Map<Integer, Integer> adj = graph.getOrDefault(src,new HashMap<>());
        for (int key : adj.keySet()) {
            if (visited[key]) continue;
            if (cost + adj.get(key) > ans) continue;
            visited[key] = true;
            dfs(graph, key, dst, k - 1, cost + adj.get(key));
            visited[key] = false;
        }
    }



//    class graphNode{
//        int v;
//        int cost;
//
//        public graphNode(int v, int cost) {
//            this.v = v;
//            this.cost = cost;
//        }
//    }
//    public int findCheapestPriceDFS(int n, int[][] flights, int src, int dst, int K) {
//       List<List<int[]>> graph_list = new ArrayList<>(n);
//       for(int i =0;i<n;i++)graph_list.add(new ArrayList<>());
//       for(int[] edge:flights){
//           graph_list.get(edge[0]).add(new int[]{edge[1],edge[2]}));
//       }
//        visited = new boolean[n];
//        visited[src] = true;
//    }
//
//
//
//
//
        public static void main(String[] args) {
        int n = 3,src =0,dst =2,k=1;
        int[][] edge = {{0,1,100},{1,2,100},{0,2,500}};

        lc787 sl = new lc787();
//        System.out.println(sl.findCheapestPriceDj(n, edge, src, dst, k));
        System.out.println(sl.findCheapestPriceDp(n, edge, src, dst, k));
    }

}
