package courseBook.acmbook;

import java.util.Arrays;

public class multibag {

    /**
     * dp[i+1][j] 从前i种物品中取j个的组合数
     * 从前i-1个中取j-k个 再从第i个取k个
     * @param a
     * @param n
     * @param m
     * @param M
     * @return
     */
    public static int multibagans(int[]a,int n,int m,int M){
        int[][] dp = new int[n+1][m+1];
        //每种都不取
        for (int i = 0; i <=n ; i++) {
            dp[i][0]=1;
        }

        for (int i = 0; i <n ; i++) {
            for (int j = 1; j <=m; j++) {
                if(j-1-a[i]>=0)
                dp[i+1][j] = (dp[i+1][j-1]+dp[i][j]-dp[i][j-1-a[i]]+M)%M;
                else
                    dp[i+1][j]=(dp[i+1][j-1]+dp[i][j])%M;
            }
        }
        return dp[n][m];
    }
    /**
     * n 物品每种ai个 取m个 求方案数取mod
     * out： 6 （0+0+3，0+1+2，0+2+1
     *
     * @param args
     */
    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        int[] a = new int[]{1,2,3};
        int M = 10000;
        System.out.println(multibagans(a, n, m, M));
    }
}
