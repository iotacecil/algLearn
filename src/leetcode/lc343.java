package leetcode;

import sun.nio.ch.FileChannelImpl;

import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class lc343 {
    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        //dp[i]当前数拆分的最大乘积
        for(int i = 2; i <= n; i ++) {//2:1 1 3:1,2 3,2,1
            for(int j = 1; j < i; j ++) {
                System.out.println(j+" "+dp[j]);
                System.out.println((i-j)+" "+dp[i-j]);
                dp[i] = Math.max(dp[i], (j * (i - j)));
                ConcurrentSkipListMap<Integer,Integer> map = new ConcurrentSkipListMap<>();

            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int i = integerBreak(10);
        System.out.println(i);
    }
}
