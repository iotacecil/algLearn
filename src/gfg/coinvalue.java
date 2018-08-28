package gfg;
/*
Input: coins[] = {25, 10, 5}, V = 30
Output: Minimum 2 coins required
We can use one coin of 25 cents and one of 5 cents

Input: coins[] = {9, 6, 5, 1}, V = 11
Output: Minimum 2 coins required
We can use one coin of 6 cents and 1 coin of 5 cents
 */
public class coinvalue {
    static int minCoins(int[] coins,int V){
        if(V==0)return 0;
        if(V<0)return -1;
        int res = Integer.MAX_VALUE;
        for(int coin:coins){
            if(coin<=V){
                int sub_res = minCoins(coins,V-coin );
                if(sub_res>=0&&sub_res!=Integer.MAX_VALUE&&sub_res+1<res){
                    res = sub_res+1;
                }
            }
        }
        return res==Integer.MAX_VALUE?-1:res;
    }

    public static void main(String[] args) {
        int[] coins = {25, 10, 5};
        coinvalue sl = new coinvalue();
        System.out.println(sl.minCoins(coins, 30));
        int[] coinss ={2};
        System.out.println(sl.minCoins(coinss, 3));

    }

}
