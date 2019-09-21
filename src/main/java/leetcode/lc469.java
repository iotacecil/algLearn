package leetcode;

import java.util.*;

public class lc469 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] nxt = new int[n];
        int[] rst = new int[n];
        Deque<Integer> stk = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = m - 1; i >= 0; i--) {
            if (!stk.isEmpty() && stk.peek() < nums2[i]) {
                stk.pop();
            }
            map.put(nums2[i], stk.isEmpty() ? -1 : stk.peek());
            stk.push(nums2[i]);
            System.out.println(stk);
            int i1 = 1999999999;
            boolean b = Long.parseLong(new String("123")) > Integer.MAX_VALUE;


        }

        for (int i = 0; i < n; i++) {
            rst[i] = map.get(nums1[i]);
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] a = {137, 59, 92, 122, 52, 131, 79, 236};
        int[] b = {137, 59, 92, 122, 52, 131, 79, 236, 94, 171};
        lc469 sl = new lc469();
        System.out.println(Arrays.toString(sl.nextGreaterElement(a, b)));
    }
}
