package luogu;

import java.util.Scanner;

public class p2722 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[] dp = new int[M + 1];

        for (int i = 0; i < N; i++) {
            int score = sc.nextInt();
            int cost = sc.nextInt();
            for (int j = cost; j <= M; j++) {
                dp[j] = Math.max(dp[j], dp[j - cost] + score);
            }
        }
        int rst = 0;
        for (int i : dp) {
            rst = Math.max(rst, i);
        }
        System.out.println(rst);

    }
}
