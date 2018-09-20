package leetcode;

import com.sun.org.apache.xpath.internal.SourceTree;

public class lc877 {
    /**
     * [5,3,4,5] dp
     * @param piles
     * @return
     */
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        //left=i,right=i的子问题
        for (int i = 0; i <n ; i++) {
            dp[i][i] = piles[i];
        }
        //长度为[2,n]的子问题
        for (int i = 2; i <=n ; i++) {
            for (int l = 0; l <n-i+1 ; l++) {
                int r = i+l-1;
                //[l+1][r]的长度比[l][r]小 已经计算过了
                dp[l][r] = Math.max(piles[l]-dp[l+1][r],piles[r]-dp[l][r-1]);
            }
        }
        return dp[0][n-1]>0;
    }
    public boolean stoneGameDP1D(int[] piles) {
        int n  = piles.length;
        int[] dp = piles.clone();
        for (int i = 2; i <=n ; i++) {
            for (int l = 0; l<n-i+1 ; l++) {
                //dp[i] 还没有更新,都是长度i-1的值
                dp[i] = Math.max(piles[l]-dp[i+1],piles[l+i-1]-dp[i] );
            }
        }
        return dp[0]>0;
    }

        public static void main(String[] args) {
        lc877 sl = new lc877();
        System.out.println(sl.stoneGame(new int[]{5, 3, 4,5}));
    }
}
