package luogu;

import java.util.Scanner;

public class p2347 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 10, 20};
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[6];
        for (int i = 0; i < 6; i++) {
            nums[i] = sc.nextInt();

        }
        boolean[][] dp = new boolean[7][1001];
        dp[0][0] = true;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 1001; j++) {
                for (int k = 0; k <= nums[i] && j - k * arr[i] >= 0; k++) {
                    dp[i + 1][j] |= dp[i][j - k * arr[i]];
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < 1001; i++) {
            if (dp[6][i]) cnt++;
        }
        System.out.println("Total=" + (cnt - 1));
    }
}
