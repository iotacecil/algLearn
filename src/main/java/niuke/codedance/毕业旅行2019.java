package niuke.codedance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 毕业旅行2019 {

    private static int tspdp(int n, int[][] graph) {
        int[][] dp = new int[n][(1 << (n - 1))];
        for (int i = 1; i < n; i++) {
            dp[i][0] = graph[0][i];
        }
//1000
        for (int i = 1; i < (1 << n - 1); i++) {
            // 没访问过的j
            for (int j = 0; j < n; j++) {
                if (((i >> (j - 1)) & 1) == 0) {
                    dp[j][i] = 100000;
                    for (int k = 1; k < n; k++) {
                        // 找一个访问过的点用 找最近的k+j,k的距离更新到j的距离
                        if (((i >> (k - 1)) & 1) == 1) {
                            dp[j][i] = Math.min(dp[k][(i ^ (1 << (k - 1)))] + graph[j][k], dp[j][i]);
                        }

                    }

                }
            }

        }
        return dp[0][(1 << (n - 1)) - 1];

    }

    private static long tsp(int state, int start, int n, int[][] graph) {
//        System.out.println(start);
        if (dp[state][start] > 0) {
            return dp[state][start];
        }
        if (state == (1 << n) - 1 && start == 0) {
            return 0;
        }
        long res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (((state >> i) & 1) == 0) {

                res = Math.min(res, tsp(state | (1 << i), i, n, graph) + graph[start][i]);

            }

        }

        return dp[state][start] = res;

    }

    private static long[][] dp;

    private static int max;

    private static void hami(int[][] graph, int cur, int cnt, int start, int end, boolean[] visited) {
        if (cur > max) return;
        if (cnt == graph.length - 1) {
            max = Math.min(max, cur + graph[start][end]);
        }
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            hami(graph, cur + graph[start][i], cnt + 1, i, end, visited);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[][] graph = new int[n][n];
        max = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            String[] line = bf.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int score = Integer.parseInt(line[j]);
                graph[i][j] = score == 0 ? Integer.MAX_VALUE : score;
            }
        }
        System.out.println(tspdp(n, graph));


//        boolean[] visited = new boolean[n];
//        visited[0] = true;
//        dp = new long[1<<(n+1)][n];
//        System.out.println(tsp(0, 0, n,graph));
        // n=4 1<<3 ->1000 0111
//        int V = 1<<(n-1);
//        int[][] dp = new int[n][V];
//        // 回程
//        for (int i = 0; i <n ; i++) {
//            dp[i][0] = graph[i][0];
//        }
//        //除了0以外访问所有n-1个点的掩码
//        for (int i = 1; i <V ; i++) {
//            for (int j = 0; j <n ; j++) {
//                dp[i][j] = 100000;
//                // 没访问过的j
//                if(((i >> (j-1))&1)==1)continue;
//                for (int k = 0; k < n; k++) {
//                    // 找到一个访问过的k做松弛从 dp[state^(
//                    if((i>>(k-1)&1)==1&&graph[j][k]>0){
//
//                    }
//                    dp[i][j] = Math.min(dp[i][j],graph[j][k]+dp[i ][k]);
//
//                }
//
//            }
//
//        }
//        System.out.println(dp[0][(1<<(n-1))-1]);

//        hami(graph,0,0,0,0,visited);
//        System.out.println(max);

    }
}
