package leetcode;

public class lc713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1)return 0;
        int cnt = 0;
        int pro = 1;
        for (int i = 0, j = 0; j < nums.length; j++) {
            pro *= nums[j];
            while (i<=j && pro >=k){
                pro /= nums[i++];
            }
            cnt += j - i + 1;
        }
        return cnt;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{10, 5, 2, 6};
        int k = 100;
        lc713 sl = new lc713();
        System.out.println(sl.numSubarrayProductLessThanK(nums, k));
    }
}
