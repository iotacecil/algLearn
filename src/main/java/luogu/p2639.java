package luogu;

import java.util.Scanner;

public class p2639 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int n = sc.nextInt();
//        int[] arr = new int[n];
        boolean[][] dp = new boolean[n + 1][h + 1];
        dp[0][0] = true;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();

            for (int j = 0; j <= h; j++) {
                dp[i + 1][j] = dp[i][j];
                if (j - x >= 0)
                    dp[i + 1][j] |= (dp[i][j - x] | dp[i][j]);

            }
        }

        for (int i = h; i >= 0; i--) {
            if (dp[n][i]) {
                System.out.println(i);
                break;
            }

        }
    }
}
