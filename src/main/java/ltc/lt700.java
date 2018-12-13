package ltc;

import java.util.HashMap;
import java.util.Map;

public class lt700 {
    Map<Integer,Integer> map = new HashMap<>();
    public int cutting(int[] prices, int n) {
        if(map.containsKey(n))return map.get(n);
        if(n <=0 )return 0;
        if(n == 1)return prices[0];
        int sum = 0;
        for (int i = 1; i <n+1; i++) {
            sum = Math.max(sum, cutting(prices, n-i) + prices[i-1]);
        }
        map.put(n, sum);
        return sum;
        // Write your code here
    }
    public int cutingdp(int[] prices,int n){
        int[] dp = new int[n+1];
        for (int i = 1; i <=n ; i++) {
            int cur = -1;
            for (int j = 1; j <=i/2 ; j++) {
                cur = Math.max(cur, dp[j] +dp[i-j]);
            }
            dp[i] = Math.max(cur, prices[i-1]);
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        int n = 8;
        lt700 sl = new lt700();
        System.out.println(sl.cutting(price, n));
    }
}
