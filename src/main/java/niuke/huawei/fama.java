package niuke.huawei;

import java.util.Scanner;

public class fama {

    public static int fama(int n, int[] weight, int[] nums) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += weight[i] * nums[i];
        }
        boolean[][] dp = new boolean[n + 1][sum + 1];
        dp[0][0] = true;
        for (int i = 0; i < n; i++) {
            // 使用这个物品，尝试凑出这个总量，并且尝试使用几个
            for (int j = 0; j <= sum; j++) {
                for (int k = 0; k <= nums[i] && k * weight[i] <= j; k++) {
                    dp[i + 1][j] |= dp[i][j - k * weight[i]];
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i <= sum; i++) {
            if (dp[n][i]) cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] fa = new int[n];

        for (int i = 0; i < n; i++) {
            fa[i] = sc.nextInt();

        }
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        System.out.println(fama(n, fa, num));
    }
}
