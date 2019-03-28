package leetcode;

import java.util.Arrays;

/*

Input: [2,1,3]
Output: 6
Explanation:
Subsequences are [1], [2], [3], [2,1], [2,3], [1,3], [2,1,3].
The corresponding widths are 0, 0, 0, 1, 1, 2, 2.
The sum of these widths is 6.

思路，排序，对第`A[i]`个数字，
有i个比它小，有2^i个序列A[i]是最大的，
有n-1-i个比它大，有2^(n-1-i)个序列，A[i]是最小的。
//[min,max]
 */
public class lc891 {
    public int sumSubseqWidths(int[] A) {
        long rst = 0;
        long mod = (long)1_000_000_000+7;
        // 1 2 3
        Arrays.sort(A);
        int n = A.length;
        // 2^0
        //
         long[] pow2 = new long[n];
         pow2[0] = 1;
         for (int i = 1; i < n; ++i)
             pow2[i] = pow2[i-1] * 2 % mod;
        for (int i = 0; i < n ; i++) {
            long i2 = ((1 << (i))+mod)%mod;
            long i3 = ((1 << (n-1-i))+mod)%mod;
            System.out.println(i2 - i3);
            System.out.println(pow2[i] - pow2[n-1-i]);
            rst = (rst+ (i2 - i3)*A[i])%mod;

        }
        return (int)rst;

    }

    public static void main(String[] args) {
        lc891 sl = new lc891();
        System.out.println(sl.sumSubseqWidths(new int[]{5,69,89,92,31,16,25,45,63,40,16,56,24,40,75,82,40,12,50,62,92,44,67,38,92,22,91,24,26,21,100,42,23,56,64,43,95,76,84,79,89,4,16,94,16,77,92,9,30,13}));
    }
}
