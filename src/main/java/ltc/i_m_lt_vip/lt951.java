package ltc.i_m_lt_vip;

import java.util.Arrays;

public class lt951 {
    /**打败了 100.00% 的提交 367ms
     * 偶数位上的数都小于所有奇数位上的数。
     * 同时，偶数位上的数也按照升序排序，奇数位上的也按照升序排序。
     *
     * 排个序，把前半放在偶数位，后半放在奇数位
     * @param nums 给出array = [-1,0,1,-1,5,10],
     * @return 返回 [-1,1,-1,5,0,10]。
     */
    public int[] rearrange(int[] nums) {
        Arrays.sort(nums);
        int[] ans = new int[nums.length];
        int pos = 0;
        //偶数
        for (int i = 0; i < ans.length ; i+=2) {
            ans[i] = nums[pos++];
        }
        for (int i = 1; i < ans.length ; i+=2) {
            ans[i] = nums[pos++];

        }
        return ans;
    }
}
