package leetcode;

import java.util.*;

public class lc322 {
    public static void main(String[] args) {

        int[] coin ={1,2,5};
        lc322 sl = new lc322();
        System.out.println(sl.coinChangedfs(coin, 11));
//        System.out.println(sl.coinChange3(coin, 11));
//        coinChange2(coin,3 );
    }
    //97%
    int minCount = Integer.MAX_VALUE;
    public int coinChangedfs(int[] coins,int amount){
        Arrays.sort(coins);
        dfs(amount,coins.length-1,coins,0);
        return minCount == Integer.MAX_VALUE?-1:minCount;
    }
    private void dfs(int amount,int idx,int[] coins,int count){
        if(amount%coins[idx]==0){
            int newC = count+amount/coins[idx];
            if(newC<minCount)
                minCount=newC;
        }
        if(idx==0)return;
        for(int i =amount/coins[idx];i>=0;i--){
            int newA = amount-i*coins[idx];
            int newC = count+i;
            int nextCoin = coins[idx-1];
            System.out.println(newC+" "+(newA+newC-1));
            if(newC+(newA+nextCoin-1)/nextCoin>=minCount)break;
            dfs(newA,idx-1,coins,newC);
        }
    }

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

    public static int coinChange2(int[] coins, int amount) {
        // int[] coin={186,419,83,408};
        // coins=coin;
        // amount=6249;
        if(amount<0||coins==null||coins.length<1)return -1;
        if(amount==0)return 0;
        int[]dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
//        int[] a = {1,2,3,4,5,6};
//        Arrays.sort(a,Collections.reverseOrder());
//        System.out.println(a);
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
    // 递归 超时？
    public int coinChange3(int[] coins, int amount) {
        if(amount<1)return 0;
        return coinChange2(coins,amount,new int[amount]);

    }
    private int coinChange2(int[] coins,int rem,int[] count){
        //不能构成
        if(rem<0)return -1;
        if(rem==0)return 0;
        System.out.println(Arrays.toString(count));
        if(count[rem-1]!=0){
            System.out.println("return: "+rem);
            return count[rem-1];
        }
        int min = Integer.MAX_VALUE;
        for(int coin:coins){
            int res = coinChange2(coins,rem-coin,count);
            if(res>=0&&res<min){
                min = 1+res;
            }
        }
        return count[rem-1] = (min==Integer.MAX_VALUE)?-1:min;
//        System.out.println(rem+" "+Arrays.toString(count));
//        return count[rem-1];
    }
    public int coinChangedp(int[] coins, int amount) {
        if(amount<1)return 0;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] =0;

        for(int coin:coins){
            for(int j = coin;j<=amount;j++){

                    System.out.println(dp[j]+" "+dp[j-coin]);
                    dp[j]=Math.min(dp[j],dp[j-coin]+1);



            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[amount];

    }
    //branch and bound
    //bfs
    public int coinChangebfs(int[] coins, int amount) {
        if(amount==0)return  0;
        boolean[] visited = new boolean[amount+1];
        visited[0]=true;
        Arrays.sort(coins);
        Deque<Integer> value1 = new ArrayDeque<>();
        value1.push(0);
        int cnt =0;
        while(!value1.isEmpty()){
            cnt++;
            Integer poll = value1.poll();

                for (int coin:coins){
                    int newval = poll+coin;
                    if(newval==amount)return cnt;
                    else if(newval>amount)continue;
                    else if(!visited[newval]){
                        visited[newval]=true;
                        value1.push(newval);
                    }
                }

        }
        return -1;
    }



}
