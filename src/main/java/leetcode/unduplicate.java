package leetcode;
//从一个有序的数组中移除重复的元素，并返回之后数组的长度

import java.util.Arrays;

class Solution5{
    public int removeDuplicates(int[] nums) {
        if(nums.length<1)return nums.length;
        int cnt=1;
        for(int i =1;i<nums.length;i++){
            if(nums[i-1]!=nums[i])nums[cnt++]=nums[i];
        }
        System.out.println(Arrays.toString(nums));
        return cnt;

    }
}
public class unduplicate {
   public static void main(String[] args){
       Solution5 sl = new Solution5();
       int[] nums = new int[]{1,2,2,4,5};
       System.out.println(sl.removeDuplicates(nums));
   }
}

