package leetcode;

import java.util.Arrays;

public class lc300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] memo = new int[n+1][n];
        for(int[] l : memo){
            Arrays.fill(l, -1);
        }
        return lengthOfLIS(nums,-1,0,memo);
    }

    public int lengthOfLIS(int[] nums,int prev,int idx,int[][] memo){
        if(idx == nums.length)return 0;
        if (memo[prev + 1][idx] >= 0) {
            return memo[prev + 1][idx];
        }

        int taken = 0;
        if (prev < 0 || nums[idx] > nums[prev]) {
            taken = 1 + lengthOfLIS(nums, prev, idx + 1, memo);
        }

        int nottaken = lengthOfLIS(nums, prev, idx + 1, memo);
        memo[prev + 1][idx] = Math.max(taken, nottaken);
        return memo[prev + 1][idx];
    }
}
