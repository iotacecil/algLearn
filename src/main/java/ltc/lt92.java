package ltc;

public class lt92 {
    //5%
    int[][] memo;
    public int backPack(int m, int[] A) {
        memo = new int[A.length+1][m+1];
        return pack(m,A.length,A);

    }
    private int pack(int W,int n,int[] wt){
        if(n==0||W==0)return 0;
        if(memo[n][W]!=0)return memo[n][W];
        if(wt[n-1]>W)return pack(W,n-1 ,wt );
        else {
            memo[n][W] = Math.max(wt[n-1]+pack(W-wt[n-1],n-1,wt),pack(W,n-1,wt));
            return memo[n][W];
        }
    }
    //24%
    public int backPackdp(int m, int[] A) {
        int n = A.length;
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <=n ; i++) {
            for (int w = 0; w <=m ; w++) {
                if(i==0||w==0){
                    dp[i][w] = 0;
                }
                else if(A[i-1]<=w){
                    dp[i][w] = Math.max(A[i-1]+dp[i-1][w-A[i-1]],dp[i-1][w]);
                }else
                    dp[i][w] = dp[i-1][w];
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        int[] w = {2, 3, 5, 7};
        int m = 11;

        lt92 sl = new lt92();
//        sl.memo = new int[w.length+1][m+1];
        System.out.println(sl.backPackdp(m, w));
    }
}
