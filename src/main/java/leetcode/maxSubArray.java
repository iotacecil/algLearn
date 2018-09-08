package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;


class Solution9 {
    public int maxSubArray(int[] nums) {
        return fenzhi(nums,0,nums.length);
    }


    private int fenzhi(int[] nums,int left,int right){
        //[-1,2,3,-1]
        if(left>=right) return nums[left];
        //0+3/2=1
        int mid = (left+right)>>2;
        int leftnum= fenzhi(nums,left,mid);
        int rightnum= fenzhi(nums,mid+1,right);
        int midleft = nums[mid],midright= nums[mid+1];

        int tmp = 0;
        for(int i=mid;i>=left;--i){
            tmp+=nums[i];
            if(tmp>midleft)midleft=tmp;
        }
        tmp= 0;
        for (int i = mid+1;i<=right;++i){
            tmp += nums[i];
            if(tmp>midright) midright= tmp;
        }
        return Math.max(Math.max(leftnum,rightnum),midleft+midright);


    }
}

public class maxSubArray {
    public static void main(String[] args){
        Solution9 sl = new Solution9();
        int[] nums = {-2,1};
        System.out.println(sl.maxSubArray(nums));
    }
}
