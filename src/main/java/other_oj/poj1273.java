package other_oj;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

/*

5 4
1 2 40
1 4 20
2 4 20
2 3 30
3 4 10

 */

public class poj1273 {



    private static int edmondsKarp(int[][] G,int start,int end){
        int rst = 0;
        int[] prev = new int[G.length];
        while (bfs(G,prev,start,end)){
            int min = Integer.MAX_VALUE;
            for (int i = end; i !=start ; i=prev[i]) {
                min = Math.min(min,G[prev[i]][i]);
            }
            for (int i = end; i !=start ; i = prev[i]) {
                G[prev[i]][i] -= min;
                G[i][prev[i]] += min;
            }
            rst += min;
        }
        return rst;
    }

    private static boolean bfs(int[][] G, int[] prev, int start, int end) {
        Arrays.fill(prev,-1);
        prev[start] = 0;
        Queue<Integer> que = new ArrayDeque<Integer>();
        que.add(start);
        while (!que.isEmpty()){
            int first = que.poll();
            for (int i = 1; i <=end ; i++) {
                // 还没访问过 而且有边
                if(prev[i] == -1 && G[first][i] != 0){
                    que.add(i);
                    prev[i] = first;
                    if(i == end)return true;
                }
            }
        }
        return false;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] G = new int[M + 1][M + 1];
            for (int i = 0; i < N; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                int cap = sc.nextInt();
                G[from][to] += cap;
            }
            int start = 1;

            System.out.println(edmondsKarp(G, start, M));
        }
    }

}
