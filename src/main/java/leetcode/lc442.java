package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i])-1;
            System.out.println(idx);
            if(nums[idx] < 0)
                res.add(Math.abs(idx) + 1);
            nums[idx] = -nums[idx];
            System.out.println(Arrays.toString(nums));
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {4,3,2,7,8,2,3,1};
        lc442 sl = new lc442();
        System.out.println(sl.findDuplicates(a));
    }
}
