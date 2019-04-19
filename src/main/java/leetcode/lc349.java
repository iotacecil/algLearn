package leetcode;

import java.util.HashSet;
import java.util.Set;

public class lc349 {
    public static void main(String[] args) {

    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        // List<Integer> list = new ArrayList<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            if (set.contains(num) && !set2.contains(num)) {
                // list.add(num);
                set2.add(num);
            }
        }


        int[] rst = new int[set2.size()];
        int i = 0;
        for (int num : set2) {
            rst[i++] = num;
        }
        return rst;
    }
}
