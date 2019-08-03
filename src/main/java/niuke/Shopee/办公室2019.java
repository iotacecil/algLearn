package niuke.Shopee;

import java.util.Scanner;

public class 办公室2019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[x + 1][y + 1];
        //  int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        for (int i = 0; i < n; i++) {
            int xx = sc.nextInt();
            int yy = sc.nextInt();
            grid[xx][yy] = -1;

//            for(int[] dir:dirs){
//                int xxx = xx+dir[0];
//                int yyy = yy+dir[1];
//                if(xxx>=0&&xxx<x&&yyy>=0&&yyy<y){
//                    grid[xxx][yyy] = -1;
//                }
//            }
        }
        int[][] dp = new int[x + 1][y + 1];

        for (int i = 0; i <= x; i++) {
            if (grid[i][0] == -1) continue;
            dp[i][0] = 1;
        }
        for (int i = 0; i <= y; i++) {
            if (grid[0][i] == -1) continue;
            dp[0][i] = 1;
        }

        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                if (grid[i][j] == -1) continue;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        System.out.println(dp[x][y]);

    }
}
