package leetcode;

import java.util.Arrays;

public class lc416 {
    public boolean canPartition(int[] nums) {
        int sum =0;
        for(int n : nums){
            sum+=n;
        }
        if(sum%2!=0)return false;
        int[] dp = new int[sum+1];
        dp[0]=1;
        for(int n:nums){
            for(int v= sum;v>=0;v--){
                if(dp[v]!=0) {
                    dp[v + n] = 1;//v=0->0+num =1
                    System.out.println(Arrays.toString(dp));
                }
            }
            if(dp[sum/2]!=0)return true;
        }
        return false;
    }

    public static void main(String[] args) {
        lc416 sl = new lc416();
        sl.canPartition(new int[]{1,5,11,5});
    }
}
