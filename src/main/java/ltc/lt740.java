package ltc;

import java.util.Arrays;

public class lt740 {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        dp[0] =1;
        for(int i=0;i<n;i++){
            for(int j = 1;j<=amount;j++){
                if(j>=coins[i])
                    dp[j]+=dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
    //这样写不对
    int cnt=0;
    public int rec(int amount, int[] coins){
        if(amount==0)return 1;

        for(int coin:coins){
            if(coin>=amount)
            cnt+=rec(amount-coin,coins);
        }
        return cnt;
    }

    int count(int[] coins,int N,int idx){
        if(N==0)return 1;
        if(N<0)return 0;
        if(coins==null||(idx<=0&&N>=1))
            return 0;
        //用/不用这枚硬币(无限次)换
        return count(coins,N ,idx-1)+count(coins,N-coins[idx-1] ,idx);
    }

    //
    public int coinDp2(int amount, int[] coins){
        int n = coins.length;
//        Arrays.sort(coins);
        int[][] dp = new int[n+1][amount+1];
        dp[0][0] =1;
        for (int i = 1; i <=n ; i++) {
            for (int j = 0; j <= amount; j++) {
                if(coins[i-1]<=j)
                    dp[i][j] += dp[i][j - coins[i-1]];
                dp[i][j]+= dp[i - 1][j];
            }

        }
        return dp[n][amount];
    }

    public static void main(String[] args) {
        int amount = 8;
        int[] coins = {2,3,8};
        lt740 sl = new lt740();
        System.out.println(sl.coinDp2(amount, coins));
    }
}
