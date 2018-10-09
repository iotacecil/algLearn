package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class lc18 {
    //81%
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> rst = new ArrayList<>();
        if(nums==null||nums.length<4)return rst;
        int n = nums.length;
        Arrays.sort(nums);
        int max = nums[n-1];
        if(4*nums[0]>target||4*max<target)return rst;
        for (int i = 0; i < n-3; i++) {
            if(i==0||(i>0 && nums[i]!=nums[i-1])){
                List<List<Integer>> lists = threeSum(i+1,n,nums, target - nums[i]);
                for(List<Integer> tmp :lists){

                    tmp.add(0,nums[i]);
                    rst.add(tmp);
                }
            }

        }
        return rst;
    }
    public List<List<Integer>> threeSum(int start,int end,int[] num,int target) {
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = start; i <end-2; i++) {
            //关键去重
            if(i==start||(i>start && num[i]!=num[i-1])){
                int lo = i+1,hi=end-1,sum = target-num[i];
                //关键
                while (lo<hi){
                    if(num[lo]+num[hi] == sum){

                        res.add(new ArrayList<>(Arrays.asList(num[i],num[lo],num[hi])));
                        //去重
                        while (lo<hi&&num[lo]==num[lo+1])lo++;
                        while (lo<hi&&num[hi]==num[hi-1])hi--;
                        lo++;hi--;
                    }else if(num[lo]+num[hi]<sum)lo++;
                    else hi--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,0,-1};
        int target = 2;
        lc18 sl = new lc18();
        System.out.println(sl.fourSum(nums, target));

    }
}
