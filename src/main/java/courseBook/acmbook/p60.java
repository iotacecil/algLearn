package courseBook.acmbook;

import java.util.Arrays;

public class p60 {
    /**
     * @param A  wi ->[1,10^7]
     * @param V  vi ->[1,100]  n <= 100
     * @param W  W ->[1,10^9]
     * @return
     */
    int maxV = 100;
    int maxW = 1000000000;
    public int bigW01bag(int[] A,int[] V,int W)
    {
        int n = A.length;
        //dp[i+1][j] 前i个物品中挑选出价值总和为j时的总重量的最小值
        int[][] dp = new int[n+1][n*maxV+1];
        Arrays.fill(dp[0],maxW );
        dp[0][0] = 0;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <=n*maxV ; j++) {
                if(j<V[i])dp[i+1][j]=dp[i][j];
                else
                    dp[i+1][j] = Math.min(dp[i][j],dp[i][j-V[i]]+A[i] );
            }
        }
        int res = 0;
        for (int i = 0; i <= n*maxV ; i++) {
            if(dp[n][i]<=W)res = i;
        }
        return res;
    }
    /*
    w [1,10^9]范围很大的情况 的01背包
     */
    public static void main(String[] args) {
        int n = 4;
        int[]A = {2,1,3,2};
        int[]V = {3,2,4,2};
        int W = 5;
        p60 sl = new p60();
        System.out.println(sl.bigW01bag(A, V, W));
    }
}
