package leetcode;

import java.util.ArrayList;
import java.util.List;

public class lc312
{

    public int maxCoinsDP(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];
        int[][] dp = new int[n+2][n+2];
        System.arraycopy(nums, 0, arr, 1, n);
        arr[0] =1;
        arr[n+1] = 1;
        n = n+2;
        // n+1个矩阵
        for (int k = 2; k < n; k++) {
            for(int left = 0;left <n-k;left++){
                int right = left+k;
                for (int i = left+1; i <right ; i++) {
                    dp[left][right] = Math.max(dp[left][right],arr[left]*arr[i]*arr[right] + dp[left][i]+dp[i][right] );
                }
            }
            
        }
        return dp[0][n-1];

    }
    public int maxCoins(int[] nums) {

        int[] numsp = new int[nums.length + 2];
        int n = 1;
        for(int x : nums){
            if(x > 0){
                numsp[n++] = x;
            }
        }
        numsp[0] = numsp[n++] =1;
        return burst(new int[n][n], numsp, 0, n-1);
    }

    private int burst(int[][] memo,int[] nums,int left,int right){
        if(left + 1 == right)return 0;
        if(memo[left][right] > 0)return memo[left][right];
        int ans = 0;
        for(int i = left+1;i<right;i++){
            ans = Math.max(ans, nums[left]*nums[i]*nums[right] + burst(memo, nums, left, i) + burst(memo, nums, i, right));
        }
        memo[left][right] = ans;
        return ans;
    }

    public int findcoin(int[] nums){
        List<Integer> list = new ArrayList<>();
        for(int i =0;i<nums.length;i++){
            list.add(nums[i]);
        }
        return findMax(list);
    }

    public int findMax(List<Integer> nums) {
        if(nums.size() == 1)return nums.get(0);
        if(nums.size() == 0)return 0;
        int max = 0;
        for(int i =0;i<nums.size();i++){
            int c = nums.get(i);
            int l = i - 1<0?1:nums.get(i-1);
            int r = i + 1>=nums.size()?1:nums.get(i+1);
            int cur = nums.get(i)*l*r;
            nums.remove(i);
            max = Math.max(max,cur+findMax(nums) );
            // 回溯
            nums.add(i,c);
        }
        return max;
    }

        public static void main(String[] args) {
        int[] balls = {3,1,5,8};
        lc312 sl = new lc312();
        System.out.println(sl.maxCoinsDP(balls));
    }
}
