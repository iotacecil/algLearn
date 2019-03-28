package leetcode;

public class lc650 {
    public int minSteps(int n) {
        // 1->2->4->8 //011  1->10->11 5 101 1->010->100
        // 11 - 10 = 1
        // 1<<1 -> 10 + 2 +1
//        int idx = 1;
        //100  1<<3
        //1->0 2->1 3->3 4->
        int[] dp = new int[n+1];
        for (int i = 2; i <=n ; i++) {
            dp[i] = i;
            for (int j = i-1; j >1 ; j--) {
                if(i%j == 0){
                    // 先完成长度j，然后长度j粘贴i/j次
                    //dp[4] = dp[2]+1;
                    //dp[2] = dp[1]+2
                    dp[i] = dp[j] + (i/j);
                }
            }
        }
        return dp[n];


    }

    public static void main(String[] args) {
        System.out.println(Math.abs(Integer.MIN_VALUE));
        lc650 sl = new lc650();
        System.out.println(sl.minSteps(4));
    }
}
