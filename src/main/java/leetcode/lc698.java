package leetcode;


import java.util.Arrays;
//https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
public class lc698 {
//    public boolean canPartitionKSubsetsDPRight(int[] nums,int k){
//        // 1. 求每组应该的平均值
//        int sum = 0;
//        for(int num : nums){
//            sum += num;
//        }
//        if(sum % k != 0){
//            return false;
//        }
//        int subsum = sum/k;
//        int n = nums.length;
//        boolean[] memo = new boolean[1<<n];
//        memo[(1 << n) - 1] = true;
//    }
//
//    private boolean search(int idx,int target,boolean[] memo,int[] nums){
//        if(memo[idx] == false){
//
//        }
//    }
    // 错的
    public boolean canPartitionKSubsetsDP(int[] nums,int k){
        // 1. 求每组应该的平均值
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % k != 0){
            return false;
        }
        int subsum = sum/k;
        // 2. 等于平均值的单独分成一组
        Arrays.sort(nums);
        int n = nums.length;
        int idx = n-1;
        if(nums[n-1] >= subsum)return false;
        int[][] dp = new int[subsum+1][n+1];
        for (int i = 1; i <= n ; i++) {
            int num = nums[i-1];
            for (int w = 1; w <=subsum ; w++) {
                dp[w][i] = dp[w][i-1];
                if(w >= num){
                    dp[w][i] = Math.max(dp[w-num][i-1] + num,dp[w][i-1]);
                }
            }
        }
        return dp[subsum][n] == subsum;
//


    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // 1. 求每组应该的平均值
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % k != 0){
            return false;
        }
        int subsum = sum/k;
        // 2. 等于平均值的单独分成一组
        Arrays.sort(nums);
        int n = nums.length;
        int idx = n-1;
        if(nums[n-1] >= subsum)return false;
        for(int i = n-1;i >= 0;i--){
            if(nums[i] < subsum)break;
            if(nums[i] == subsum){
                k--;
                idx--;
            }
        }
        // 3. 回溯分组
        int[] group = new int[k];
        return back(group,idx,subsum,nums);
    }
    private boolean back(int[] group,int idx,int target,int[] nums){
        // 全部都分组好了
        if(idx < 0){
            return true;
        }
        // 试着放到每一组
        for(int i = 0;i < group.length;i++){
            if(group[i] + nums[idx] > target){
                continue;
            }
            group[i] += nums[idx];
            if(back(group,idx-1,target,nums)){
                return true;
            }
            group[i] -= nums[idx];
        }
        return false;
    }

    public static void main(String[] args) {
        lc698 sl = new lc698();
        System.out.println(sl.canPartitionKSubsetsDP(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
    }
}
