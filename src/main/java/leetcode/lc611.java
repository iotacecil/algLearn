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
        int n = nums.length;
        for (int i = n-1; i >1 ; i--) {
            int l = 0,r = i-1;
            while (l<r){
                if(nums[l] + nums[r] >nums[i]){
                    cnt += r-l;
                    r--;
                }else l++;
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
