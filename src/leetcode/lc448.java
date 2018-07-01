package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc448 {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        // int max = -1;
        //[1,2,2,4]
        for(int i=0;i<len;i++){
            // {4,3,2,7,8,2,3,1};
//为什么要abs
            int val = nums[i]-1;//

            System.out.println(val+" "+nums[val]);
            if(nums[val]>0){
                nums[val]=-nums[val];
            }
//            nums[val]=nums[val]>0?-nums[val]:nums[val];
        }
        System.out.println(Arrays.toString(nums));
        for(int i =0;i<len;i++){
            if(nums[i]>0)
                list.add(i+1);
        }
        return list;

    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List a = findDisappearedNumbers(nums);
        System.out.println(a);
    }
}
