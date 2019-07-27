package niuke.meituan;

import java.util.Scanner;

public class 拼凑钱币2018 {
    //10 =
    //1 = 1 dp[2]=dp[1] dp[3] = dp[2] dp[5]= dp[4]+dp[0]=2
    //dp[6]= 51,1111 =2  dp[5] +dp[1]
    // dp[9] = dp[8]+dp[4]
    //dp[10] = dp[0]+dp[5]+dp[9]  10=11111,11115,55,10
    // 用一个新的硬币，更新之前的值
    //硬币数量
    public static void main(String[] args) {
        int[] coins = {1, 5, 10, 20, 50, 100};
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int j = 0; j < coins.length; j++) {

            for (int i = coins[j]; i <= n; i++) {

                dp[i] += dp[i - coins[j]];


            }

        }
        System.out.println(dp[n]);
    }
}
