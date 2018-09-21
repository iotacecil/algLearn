package ltc;

public class lc476 {
    public int stoneGame(int[] A) {
        int n = A.length;
        int[][] dp = new int[n][n];
        int[][]cost = new int[n][n];

        for (int i = 0; i <n-1 ; i++) {
            dp[i][i+1] = A[i]+A[i+1];
        }
        for(int i =2;i<n;i++){
            for (int j = 0; j+i<n ; j++) {
                dp[j][j+i]+= Math.min(dp[j][j+i-1]+A[j+i],dp[j+1][j+i]+A[j]);
                cost[j][j+i]+=dp[j][j+i];
            }
        }
        return cost[0][n-1];

    }
    public static void main(String[] args) {
        int[] nums = new int[]{4,1,1,4};
        lc476 sl = new lc476();
        System.out.println(sl.stoneGame(nums));


    }
}
