package other_oj;
import java.io.*;
import java.util.Arrays;
//Accepted	3772K	1750MS
public class poj2686 {
    final static int inf = 1000;
    /**
     *
     * 3 4 3路径数量 1 4
     3 1 2
     1 2 10
     2 3 30
     3 4 20
     time = graph[v][w]/hourse[i]
     * @param n ticket number 一张票只能走一条路
     * @param m city number
     * @param graph
     * @param a 起点
     * @param b 终点
     * @param hourse 马的数量
     * @return
     */
    public static double mintime(int n,int m,int[][] graph,int a,int b,int[] hourse){
        // dp[S][v]剩下车票S 当前在城市v的最小花费
        double[][] dp = new double[1<<n][m];
        for (int i = 0; i <1<<n ; i++) {
            Arrays.fill(dp[i], inf);
        }
        //起点
        dp[(1<<n)-1][a-1] = 0;
        double res = inf;
        //n = 3 S = 111 用哪个车票的子集
        for (int S = (1<<n)-1; S >=0 ; S--) {
            res = Math.min(res, dp[S][b-1]);
            for (int v = 0; v < m ; v++) {
                //车票i
                for (int i = 0; i < n ; i++) {
                    if((S>>i & 1)!=0){
                        for (int u = 0; u <m ; u++) {
                            if(graph[v][u]>=0){
                                dp[S&~(1<<i)][u] = Math.min(dp[S&~(1<<i)][u],dp[S][v]+(double)graph[v][u]/hourse[i]);
                            }
                        }
                    }
                }
            }
        }
        if(res == inf){
            return -1;
        }else return res;
    }
    public static void main(String[] args) throws IOException {
        int n;
        while ( (n = nextInt())!= 0) {
//            if(n==0)break;
            int m = nextInt();
            int p = nextInt();
            int a = nextInt();
            int b = nextInt();
//            System.out.println(n+" "+m);
            int[] hourse = new int[n];
            for (int i = 0; i <n ; i++) {
                hourse[i] = nextInt();
            }
//            System.out.println(Arrays.toString(hourse));
            int[][] graph = new int[m][m];
            for (int i = 0; i < m; i++) {
                Arrays.fill(graph[i],-1);
                graph[i][i] = 0;
            }
            while (p-->0){
                int x = nextInt()-1;
                int y = nextInt()-1;
                int z =  nextInt();
                graph[x][y] = z;
                graph[y][x] = z;
            }
            double mint = mintime(n, m, graph, a, b, hourse);
//            System.out.println(mint);
            if ( mint== -1) {
                System.out.println("Impossible");
                out.println("Impossible");
            } else {
                System.out.printf("%.3f\n", mint);
                out.printf("%.3f\n", mint);
            }
        }


    }



    static BufferedReader br = new BufferedReader(new InputStreamReader(
            System.in));
    static StreamTokenizer in = new StreamTokenizer(br);
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static String next() throws IOException {
        in.nextToken();
        return in.sval;
    }

    static char nextChar() throws IOException {
        in.nextToken();
        return in.sval.charAt(0);
    }

    static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    static long nextLong() throws IOException {
        in.nextToken();
        return (long) in.nval;
    }

    static float nextFloat() throws IOException {
        in.nextToken();
        return (float) in.nval;
    }

    static double nextDouble() throws IOException {
        in.nextToken();
        return in.nval;
    }
}
