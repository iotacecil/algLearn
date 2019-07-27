package niuke.wangyi;

import java.util.Scanner;

/*
背包方案数
总体积不超过背包容量的情况下,他一共有多少种零食放法
 */
public class 牛牛的背包问题2019 {

    private static long cnt(long[] arr, long w, int idx) {
        //只有1个物品   容量够 装or不装  容量不够 不装
        if (w < 0) return 0;
        if (idx == 0) {
            if (w >= arr[0]) return 2;
            else return 1;
        }

        if (w == 0) {
            return 1;

        }
        return cnt(arr, w, idx - 1) + cnt(arr, w - arr[idx], idx - 1);


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long w = sc.nextLong();
        long[] v = new long[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextLong();
            sum += v[i];
        }
        if (sum <= w) {
            System.out.println((long) Math.pow(2, n));
            return;
        }
        System.out.println(cnt(v, w, n - 1));
        // 1
        // 2,2,2,2,2...
        // 2
        // 1 2 3  3....
        // 3
        //
        // 4
        //0 1 2 3 4
        // 1 2 3 3
//        long[][] dp = new long[n+1][w+1];
//        Arrays.fill(dp[0],1);
//        for (int i = 1; i <=n ; i++) {
//            dp[i] =dp[i-1].clone();
//            for (int j =v[i-1] ; j <=w ; j++) {
//                dp[i][j]  += dp[i-1][j-v[i-1]];
//                //容量为2 能装 方案数dp[2] = dp[0=2-{2}]+dp[1=2-{1}] = 装1，2或者不装
//                // 容量为3能装0, 1, 2, 12
//            }
////            System.out.println(Arrays.toString(dp[i]));
//
//        }
//        System.out.println(dp[n][w]);
    }
}
