package leetcode;

import java.util.HashSet;
import java.util.Set;

public class lc219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(i > k) {
                set.remove(nums[i - k - 1]);
            }
            if(!set.add(nums[i]))return true;

            System.out.println(set);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        int k = 3;
        lc219 sl = new lc219();
        System.out.println(sl.containsNearbyDuplicate(nums, k));
    }
}
