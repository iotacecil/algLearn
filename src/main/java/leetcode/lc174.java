package leetcode;

public class lc174 {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon==null)return 0;
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[][] dp = new int[n+1][m+1];

        dp[n-1][m] = 1;
        dp[n][m-1] = 1;
        for (int i = 0; i <n-1 ; i++) {
            dp[i][m] = Integer.MAX_VALUE;
        }
        for (int i = 0; i <m-1 ; i++) {
            dp[n][i] = Integer.MAX_VALUE;
        }

        dp[n-1][m-1] = Math.max(1,1-dungeon[n-1][m-1]);
        for(int i =n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                //这一格补血的，导致血量是负数就行了，但是问题中不存在走到任何一格是负数,最小也是1

                dp[i][j]=Math.max(1,Math.min(dp[i+1][j],dp[i][j+1])-dungeon[i][j]);


            }

        }
        for (int i = 0; i <dp.length ; i++) {
            for (int j = 0; j <dp[0].length ; j++) {
                System.out.print(" "+dp[i][j]);
            }
            System.out.println();
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        int[][] dp = new int[5][5];
        lc174 sl = new lc174();
        sl.calculateMinimumHP(new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}});

    }
}
