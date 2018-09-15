package ltc;

public class lt279 {
    /**
     *11 = 1 + 1 + 1... + 1
         = 1 + 1 + 1 + 1 + 1 + 1 + 5
         = 1 + 5 + 5
         = 1 + 10
     * @param n 11
     * @return 4
     */
    public int waysNCents(int n) {
        int[] coins = {1,5,10,25};
       int[] dp = new int[n+1];
       dp[0] = 1;
        for (int i = 0; i <4 ; i++) {
            for (int j = 1; j <=n ; j++) {
                if(j>=coins[i])
                    dp[j]+=dp[j-coins[i]];
            }

        }
        return dp[n];

    }

    public static void main(String[] args) {
        lt279 sl = new lt279();
        System.out.println(sl.waysNCents(11));
    }
}
