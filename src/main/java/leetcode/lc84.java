package leetcode;

import java.util.Arrays;

public class lc84 {
    public int largestRectangleArea(int[] h) {
        int rst = 0;
        int n = h.length;
//        Deque<Integer> stk1 = new ArrayDeque<>();
//        Deque<Integer> stk2 = new ArrayDeque<>();
        int[] stk = new int[n];
        int[] L = new int[n];
        int[] R = new int[n];
        int t = 0;
        for (int i = 0; i < h.length; i++) {
            while (t > 0 && h[stk[t - 1]] >= h[i]) t--;
            L[i] = t == 0 ? 0 : (stk[t - 1] + 1);
            stk[t++] = i;
        }
        System.out.println(Arrays.toString(L));
        t = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (t > 0 && h[stk[t - 1]] >= h[i]) t--;
            R[i] = t == 0 ? n - 1 : (stk[t - 1] - 1);
            stk[t++] = i;
        }
        System.out.println(Arrays.toString(R));

        for (int i = 0; i < n; i++) {
            rst = Math.max(rst, h[i] * (R[i] - L[i] + 1));
        }

        return rst;
    }

    public static void main(String[] args) {
//        int[] arr = {2,1,5,6,2,3};
        int[] arr = {2, 4};
        lc84 sl = new lc84();
        System.out.println(sl.largestRectangleArea(arr));
    }
}
