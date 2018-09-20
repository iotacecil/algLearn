package other_oj;

import java.io.*;
import java.util.Arrays;
//1653MS fast



/*

1
4 4 22 0 3
1 1 1 1
5 7 9 12
0 1 10
1 3 10
0 2 10
2 3 10


 */
public class hdu4571 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(
            System.in));
    static StreamTokenizer in = new StreamTokenizer(br);
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static int n, m, T, st, ed;
    static int map[][];
    static int inf = 1 << 29;
    static node node[];

    static class node implements Comparable<node> {
        int s, c, id;

        node(int i) {
            id = i;
        }

        public int compareTo(node o) {
            return this.s - o.s;
        }

        @Override
        public String toString() {
            return "node{" +
                    "s=" + s +
                    ", c=" + c +
                    ", id=" + id +
                    '}';
        }
    }

    int[][][] memo;
    int dfs(int u,int  val,int t){
        if(t<map[u][ed])return -1;
        int tmp = 0,i;
        for (int j = 0; j <n ; j++) {
            if(node[j].s<=val){
                continue;
            }
            tmp+=Math.max(tmp,dfs(node[j].id,node[j].s,T-node[j].c-map[u][node[j].id])+node[j].s);
        }
        return tmp;
    }

    /**
     *
     * 所有点可以重复访问(?
     * 可以只经过那个点但是不获得那个si值
     * 1 test case
     spots num N 4  path num 4 time limi 22 start  0 end 3
     spot i visit time 1 1 1 1
     profit i 5 7 9 12
     spot u 2 v 的双向路径 cost
     0 1 10
     1 3 10
     0 2 10
     2 3 10
     * @param args
     * @out the greatest satisfaction value.
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        int test = nextInt(), u, v, val, temp;
        for (int ttt = 1; ttt <= test; ttt++) {
            n = nextInt();
            m = nextInt();
            T = nextInt();
            st = nextInt();
            ed = nextInt();

            node = new node[n];
            //visit time
            for (int i = 0; i < n; i++) {
                node[i] = new node(i);
                node[i].c = nextInt();
            }
            // profit
            for (int i = 0; i < n; i++)
                node[i].s = nextInt();

            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(map[i], inf);
                map[i][i] = 0;
            }
            //path 只保留最短
            for (int i = 1; i <= m; i++) {
                u = nextInt();
                v = nextInt();
                val = nextInt();
                map[v][u] = map[u][v] = Math.min(map[u][v], val);
            }

            //弗洛伊德算法 扩充全部最短路径
            for (int k = 0; k < n; k++)
                for (int i = 0; i < n; i++) {
                    if (map[i][k] == inf)
                        continue;
                    for (int j = 0; j < n; j++) {
                        if (map[k][j] == inf)
                            continue;
                        map[j][i] = map[i][j] = Math.min(map[i][j], map[i][k]
                                + map[k][j]);
                    }
                }
            System.out.println(Arrays.deepToString(map));
            // whose satisfaction value is strictly larger than that of which he visited last time
            //node profit 从小到大排序
            //背包
            Arrays.sort(node);
            //dp[n个点][time+1]
            int dp[][] = new int[n][T + 1];




            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], -1);
            }
            //初始化 start->0~n tmp = [start][v]+visit[v]
            for (int i = 0; i < n; i++) {
                v = node[i].id;
                temp = map[st][v] + node[i].c;
                //从起点到v,花费tmp(+visit) 的socre
                if (temp <= T)
                    dp[v][temp] = node[i].s;
            }
            System.out.println(Arrays.deepToString(dp));
            //node已经按profit排序了.i是最大的 j是i之后最大的

            //1-2-3... 不用考虑1-3-2 因为profit 是一样的
            //1-3-4
            for (int i = 0; i < n; i++) {

                u = node[i].id;
                for (int t = 0; t <= T; t++) {
                    //为什么可以跳过1-3-2 因为无向图
                    for (int j = i + 1; j < n; j++) {
                        v = node[j].id;

                        //没有到u的路线
                        if (node[i].s == node[j].s || dp[u][t] == -1)
                            continue;
                        //之前到u的时间t,+访问v的时间+ [u][v]的路线
                        temp = t + node[j].c + map[u][v];
                        //时间容许则更新
                        if (temp <= T) {
                            if (v == ed) System.out.println("equals");

                            dp[v][temp] = Math.max(dp[v][temp], dp[u][t]
                                    + node[j].s);
                        }
                    }
                }
            }

            //
            int ans = 0;
            for (int i = 0; i < n; i++) {
                v = node[i].id;
                for (int t = 0; t <= T; t++) {
                    //toend
                    if(v==ed) System.out.println("equals");
                    if (t + map[v][ed] <= T)
                        ans = Math.max(ans, dp[v][t]);
                }
            }

            out.println("Case #" + ttt + ":");
            out.println(ans);
        }
        out.flush();
        out.close();
    }

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
