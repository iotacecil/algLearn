package leetcode;

import java.util.*;

public class lc322 {
    public static int coinChange(int[] coins, int amount) {
        // int[] coin={186,419,83,408};
        // coins=coin;
        // amount=6249;

        if(amount<0||coins==null||coins.length<1)return -1;
        if(amount==0)return 0;
        int[]dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int coin:coins){
            //当前不使用这枚硬币时组成 上一层dp的各个最小值
            //i:剩下的钱
            for(int i =amount-coin;i>=0;i--){
                System.out.println("amount-coin"+i);
                System.out.println(Arrays.toString(dp));
                if(dp[i]!=Integer.MAX_VALUE){

                    //遍历加这一枚硬币的数量
                    for(int k = 1;k*coin+i<=amount;++k) {
                        //更新选这枚硬币的这一层
                        System.out.println("k" + k+"i"+i);
                        dp[i + k * coin] = Math.min(dp[i + k * coin], dp[i] + k);
                    }
                }
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
Map<String,Boolean> mem = new HashMap<>();
    public static void main(String[] args) {
        String s = "aaaa";
        System.out.println(s.substring(1));
        int[] coin ={1,2,5};
        coinChange2(coin,11);
    }
    public static int coinChange2(int[] coins, int amount) {
        // int[] coin={186,419,83,408};
        // coins=coin;
        // amount=6249;
        if(amount<0||coins==null||coins.length<1)return -1;
        if(amount==0)return 0;
        int[]dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        int[] a = {1,2,3,4,5,6};
//        Arrays.sort(a,Collections.reverseOrder());
        System.out.println(a);
        List<Integer> list = new ArrayList<>();


        dp[0]=0;
        for(int coin:coins){
            for(int i=coin;i<=amount;i++){
                System.out.println(Arrays.toString(dp));
                dp[i]=Math.min(dp[i],dp[i-coin]+1);
                System.out.println(Arrays.toString(dp));

            }
        }

        return dp[amount]>=amount+1?-1:dp[amount];
    }
}
