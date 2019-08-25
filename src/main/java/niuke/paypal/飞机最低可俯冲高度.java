package niuke.paypal;

import java.util.Scanner;

public class 飞机最低可俯冲高度 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int h = sc.nextInt();
        //有k架飞机，测试1-H，最不理想多少次
        System.out.println(drapEgg(k, h));
    }

    public static int superEggDrop(int K, int N) {
        int dp[] = new int[K + 1], m = 0;
        for (m = 0; dp[K] < N; ++m)
            for (int k = K; k > 0; --k)
                dp[k] += dp[k - 1] + 1;
        return m;
    }

    private static int drapEgg(int k, int h) {
        int[][] dp = new int[h + 1][k + 1];
        int m = 0;
        // k个鸡蛋，移动m次可以check的最大层数
        while (dp[m][k] < h) {
            ++m;
            // k个鸡蛋的check高度+1
            for (int i = 1; i <= k; i++) {
                dp[m][i] = dp[m - 1][i - 1] + dp[m - 1][i] + 1;
            }
        }
        return m;
    }
}
