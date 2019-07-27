package leetcode;

import java.util.Arrays;

public class lc321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] rst = new int[k];
        int n = nums1.length;
        int m = nums2.length;


        Arrays.sort(nums2);
        int idx1 = 0;
        int idx2 = 0;
        int idx = 0;
        while (idx1 < n && idx2 < m) {
            if (nums1[idx1] > nums2[idx2]) {
                rst[idx++] = nums1[idx1++];
            } else {
                rst[idx++] = nums2[idx2++];
            }
        }
        while (idx1 < n) {
            rst[idx++] = nums1[idx1++];
        }
        while (idx2 < n) {
            rst[idx++] = nums2[idx2++];
        }
        return rst;

    }

}
