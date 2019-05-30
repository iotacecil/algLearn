package leetcode;

public class lc664 {
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        dfs(s, 0, n-1, dp);
        return dp[n-1][n-1];
    }

    private int dfs(String s, int i,int j,int[][] dp){
        if(i > j)return 0;
        if(dp[i][j] == 0){
            //最坏情况，后面的一个一个打
            dp[i][j] = dfs(s,i,j-1,dp)+1;
            for (int k = i; k < j; k++) {
                // 可以同时打印 k和j
                if(s.charAt(k) == s.charAt(j)){
                    dp[i][j] = Math.min(dp[i][j],dfs(s,i,k,dp)+dfs(s,k+1,j-1,dp) );
                }

            }
        }
        return dp[i][j];
    }

}
