package luogu;

import java.util.Scanner;

/*
你现在有N个人选，每个人都有这样一些数据：A（能得到多少资料）、
B（伪装能力有多差）、C（要多少工资）。已知敌人的探查间谍能力为M（
即去的所有人B的和要小于等于M）和手头有X元钱，请问能拿到多少资料？
 */
public class p1910 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();

        int[][] dp = new int[m + 1][x + 1];
        int rst = 0;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            for (int j = m; j >= b; j--) {
                for (int k = x; k >= c; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - b][k - c] + a);
                    rst = Math.max(rst, dp[j][k]);
                }
            }
        }
        System.out.println(rst);

    }
}
