package leetcode;

public class lc477 {
    public int totalHammingDistance(int[] nums){
        int total = 0,n = nums.length;
        for (int i = 0; i < 32 ; i++) {
            int bitCnt = 0;
            //有几个num这个位是1
            for (int j = 0; j < n ; j++) {
                bitCnt += (nums[j] >> i) & 1;
            }
            total += bitCnt*(n-bitCnt);
        }
        return total;
    }
}
