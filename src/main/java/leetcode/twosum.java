package leetcode;

import java.util.Arrays;

//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
/*
Given nums = [2, 7, 11, 15], target = 9,
return [0, 1].
 */
class Solution1{
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++) {
                if (nums[i]+nums[j] == target)
                    //java数组的创建
                    return new int[]{i,j};
            }
        }
        //空值null
        return null;
    }
}
public class twosum {
    public static void main(String[] args){
        Solution1 sl = new Solution1();
        int[] arr = new int[]{2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(sl.twoSum(arr,target)));
    }
}
