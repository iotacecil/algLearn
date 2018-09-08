package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class lc189 {
    private static void rotateHelp(int[] nums,int start,int end){
        while(start<end){
            int tmp =  nums[start];
            nums[start] = nums[end-1];
            nums[end-1]=tmp;
            start++;
            end--;
        }
    }
    public static void rotate(int[] nums, int k) {//len=7,k=3
        String a = "aaaa";
        a.length();
        int po = k%nums.length;//[0:nums-po-1]==[nums-po-1:nums-1]
//        rotateHelp(nums,0,nums.length);

//        rotateHelp(nums,0,po);
        rotateHelp(nums,po,nums.length);

    }

    public static void main(String[] args) {
        int[] num = {1,2,3,4,5,6,7};
        rotate(num,3);
        System.out.println(Arrays.toString(num));
    }
}
