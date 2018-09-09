package leetcode;
//Input:
//n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
//src = 0, dst = 2, k = 1
//Output: 200

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc787 {

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
//        public static void main(String[] args) {
//        int n = 3,src =0,dst =2,k=1;
//        int[][] edge = {{0,1,100},{1,2,100},{0,2,500}};
//
//        lc787 sl = new lc787();
//        System.out.println(sl.findCheapestPriceDFS(n, edge, src, dst, k));
//    }

}
