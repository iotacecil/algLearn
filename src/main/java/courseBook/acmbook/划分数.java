package courseBook.acmbook;

public class 划分数 {
    public static void main(String[] args) {
        int n = 4;
        int m = 3;
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;
        for (int i = 1; i <= m ; i++) {
            for (int j = 0; j <=n ; j++) {
                if(j-i >= 0){
                    dp[i][j] = dp[i-1][j]+dp[i][j-i];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[m][n]);
    }
}
