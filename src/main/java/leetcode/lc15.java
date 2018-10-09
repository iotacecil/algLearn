package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3sum a + b + c = 0
  Given array nums = [-1, 0, 1, 2, -1, -4],
 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 */
public class lc15 {
    //75%
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <num.length-2; i++) {
            //关键去重
            if(i==0||(i>0&&num[i]!=num[i-1])){
                int lo = i+1,hi=num.length-1,sum = 0-num[i];
                //关键
                while (lo<hi){
                    if(num[lo]+num[hi] == sum){
                        res.add(Arrays.asList(num[i],num[lo],num[hi]));
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
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        lc15 sl = new lc15();
        System.out.println(sl.threeSum(nums));
    }
}
