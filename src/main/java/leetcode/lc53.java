package leetcode;

public class lc53 {
    public int maxSubArray(int[] nums) {
        int rst = 0;
        int sum = 0;
        for(int num:nums){

            if(sum<0)sum = num;
            else sum+= num;
            rst = Math.max(sum,rst);
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
    }
}
