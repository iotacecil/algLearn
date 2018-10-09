package courseBook.acmbook;

public class p192 {
    public final int INF = 1<<19;
    int N;
    int[][] d;
    public int tsp(int[]d){
        N = d.length;
        dp = new int[1<<d.length][d.length];
        return rec(0,0);
    }
    int[][] dp;
    //已经访问过的集合S和当前位置v
    int rec(int S,int v){
        if(dp[S][v]>0)return dp[S][v];
        //回到0点
        if(S==(1<<N)-1&&v==0){
            return dp[S][v] = 0;
        }
        int res = INF;
        for (int u = 0; u <N ; u++) {
            if((S >> u & 1)==0){
                res = Math.min(res, rec(S | 1<<u,u)+d[v][u]);
            }
        }
        return dp[S][v] = res;

    }
    public static void main(String[] args) {

    }
}
