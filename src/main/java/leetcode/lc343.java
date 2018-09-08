package leetcode;

import sun.nio.ch.FileChannelImpl;

import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class lc343 {
    static int[] memo;
    private static int ib(int n){
        if(memo[n]!=-1)return memo[n];
        if(n<=1)return n;
        if(n==2)return 1;
        int res = -1;
        for(int i =1;i<n;i++){
            System.out.println("i="+i);
            res = Math.max(res,Math.max(i*(n-i),i*ib(n-i)));
            System.out.println(memo.length);
            memo[n] = res;
        }
        return res;
    }
    public static int integerBreak3(int n) {

        memo= new int[n+1];
        for(int i=0;i<memo.length;i++){
            memo[i]=-1;
        }
        return ib(n);
    }
    //超时
    public static int integerBreak2(int n) {

        if(n<=1)return n;
        if(n==2)return 1;
        int res = -1;
        for(int i =1;i<n;i++){
            res = Math.max(res,Math.max(i*(n-i),i*integerBreak(n-i)));

        }
        return res;
    }
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
//        int i = integerBreak(10);
//       memo = new int[11];
        int i = integerBreak3(10);
        System.out.println(i);
    }
}
