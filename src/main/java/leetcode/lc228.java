package leetcode;

import java.util.ArrayList;
import java.util.List;

public class lc228 {
    public List<String> summaryRanges(int[] nums) {
        int i = 0;int j = 1;int n = nums.length;
        List<String> rst = new ArrayList<>();
        while(j<n){
            while(j<n && nums[j] - nums[j-1] ==1){

                j++;
            }
            if(j-i >=2){
                rst.add(nums[i]+"->"+nums[j-1]);
                i =j;
            }else{
                rst.add(nums[i]+"");
                i=j;j++;
            }

        }
        return rst;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,4,5,7};
        System.out.println((new lc228()).summaryRanges(arr));
    }
}
