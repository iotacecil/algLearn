package leetcode;

import java.util.Random;

public class lc398 {
    int[] nums;
    Random rdm;
    public lc398(int[] nums){
        this.nums =nums;
        this.rdm = new Random();
    }
    //O(n)
    public int pick(int target){
        int rst = -1;
        int cnt = 0;
        for(int i =0;i<nums.length;i++){
            if(nums[i]!=target)continue;
            //读完整个数组，如果有几个重的，最后以1/count概率输出index
            if(rdm.nextInt(++cnt)==0){
                rst = i;
            }
        }
        return rst;

    }
}
