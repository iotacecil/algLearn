package leetcode;

import java.util.Arrays;

public class lc611 {
    /**
     * Input: [2,2,3,4]
     Output: 3
     Explanation:
     Valid combinations are:
     2,3,4 (using the first 2)
     2,3,4 (using the second 2)
     2,2,3
     * @param nums
     * @return
     */
    public int triangleNumber(int[] nums) {
        int cnt = 0;
        Arrays.sort(nums);
        for (int i = 0; i <nums.length-2 ; i++) {
            int k = i+2;
            for (int j = i+1; j <nums.length-1&&nums[i]!=0 ; j++) {
                //两边之和>k
                while (k<nums.length&&nums[i]+nums[j]>nums[k])k++;
                cnt+=(k-1-j);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,3,4};
        lc611 sl = new lc611();
        System.out.println(sl.triangleNumber(nums));
    }
}
