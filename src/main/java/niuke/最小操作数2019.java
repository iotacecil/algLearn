package niuke;

public class 最小操作数2019 {
    public int minOperationCount(String source, String target) {
        int n = source.length();
        int m = target.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 1;i<=n;i++){
            dp[i][0] = i;
        }
        for(int i = 1;i<=m;i++){
            dp[0][i] = i;
        }
        //    System.out.println(dp[0][1]);
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                System.out.println(source.charAt(i-1));
                if(source.charAt(i-1)==target.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else dp[i][j] = 1+Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        最小操作数2019 sl = new 最小操作数2019();
        System.out.println(sl.minOperationCount("a", "b"));
    }
}
