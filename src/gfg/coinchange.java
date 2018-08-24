package gfg;

public class coinchange {
    int count(int[] coins,int N,int idx){
        if(N==0)return 1;
        if(N<0)return 0;
        if(coins==null||(idx<=0&&N>=1))
            return 0;
        //用/不用这枚硬币(无限次)换
        return count(coins,N ,idx-1)+count(coins,N-coins[idx-1] ,idx);
    }
    int contdp(int[] coins,int N){
        int[] dp = new int[N+1];
        dp[0] =1;
        for (int i = 0; i <coins.length ; i++) {
            for (int j = coins[i]; j <=N ; j++) {
                dp[j] += dp[j-coins[i]];

            }
        }
        return dp[N];
    }

    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int N = 4;
        coinchange sl = new coinchange();
        System.out.println(sl.count(coins, N,coins.length));

    }
}
