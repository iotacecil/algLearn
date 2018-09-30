package courseBook.acmbook;

import java.util.Arrays;

public class p62 {
    public boolean canSumOnk(int[] A,int[] V,int K){
        //dp[i+1][j] 用前i种数求和j 第i种数最多剩多少个 不能得到j 为-1
        int[] dp = new int[K+1];
        int n = A.length;
        Arrays.fill(dp,-1 );
        dp[0] = 0;
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j <=K ; j++) {
                //如果前i-1可以得到j i不用加，剩下全部
                if(dp[j]>=0){
                    dp[j] = A[i];
                }else if(j<V[i]||dp[j-V[i]]<=0){
                    dp[j] =-1;
                }else{
                    //前i-1个可以加出 -V[i]的情况
                    dp[j] = dp[j-V[i]]-1;
                }
            }
        }
        return dp[K]>=0;
    }
    public boolean canSum(int[] A, int[] V,int K){
        int n = A.length;
        //dp[i+1][j]用钱i种数字是否能加和成j
        boolean[][] dp = new boolean[n+1][K+1];
        dp[0][0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <=K ; j++) {
                //为了使用数字i，需要i-1数字加成j-vi,j-2*vi,j-m*vi的情况
                for (int k = 0; k <=A[i]&&k*V[i]<=j ; k++) {
                    dp[i+1][j] |= dp[i][j-k*A[i]];
                }
            }
        }
        return dp[n][K];
    }
    public static void main(String[] args) {
        int n = 3;
        int[] a = {3,5,8};
        int[] m = {3,2,2};
        int K = 17;
        p62 sl = new p62();
        System.out.println(sl.canSum(m, a, K));
        System.out.println(sl.canSumOnk(m, a, K));
    }
}
