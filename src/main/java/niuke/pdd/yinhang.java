package niuke.pdd;

import java.util.Arrays;
import java.util.Scanner;

/*

Sample Input
6 3

1 1

3 5

4 8

6 4

10 3

11 2

Sample Output
5 3


题意
这个题保证银行位置是递增的，而且没有两个银行在同一个位置上
给你n个银行，每次银行的位置x[i],金钱w[i]， 现在让你选择两个不同的银行 使其距离大于等于D 且金钱和最大

输出选择的那两个银行，序号

题解：
先预处理出  i ~n 中 金钱最多的，序号是那个
 */
public class yinhang {
    // 满足条件的最小index
    public static int lowerBound(long[] nums, long target) {
        if (nums == null || nums.length == 0) return -1;
        int lb = -1, ub = nums.length;
        while (lb + 1 < ub) {
            int mid = lb + (ub - lb) / 2;
            if (nums[mid] >= target) {
                ub = mid;
            } else {
                lb = mid;
            }
        }
        return ub;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        long[] w = new long[n+2];
        long[] m = new long[n+2];
        for (int i = 1; i <=n ; i++) {
            w[i] = sc.nextLong();
            m[i] = sc.nextLong();
        }
        w[n+1] = Integer.MAX_VALUE;
        m[n+1] = Integer.MIN_VALUE;
        //预处理

        long[] dp1 = new long[n+2];
        int[] dp2 = new int[n+2];
        // 每个位置之后 最大的money
        // 以及对应的编号
        dp1[n+1] = -1;
        dp2[n+1] = n+1;
        for (int i = n; i >=1 ; i--) {
            if(m[i] >= dp1[i+1]){
                dp1[i] = m[i];
                dp2[i] = i;
            }else{
                dp1[i] = dp1[i+1];
                dp2[i] = dp2[i+1];
            }
        }
        System.out.println(Arrays.toString(dp1));
        System.out.println(Arrays.toString(dp2));
        long ans = 0,ansl = -1,ansr = -1;
        for (int i = 1; i <=n ; i++) {
            // 每个位置之后距离d的位置
            long tmp = w[i] + d;
            int pos = lowerBound(w,tmp);
            if(pos == n+1)break;
            if(m[i] + dp1[pos] >ans){
                ans = m[i] + dp1[pos] ;
                ansl = i;
                ansr = dp2[pos];
            }
        }
        System.out.println(ansl+" "+ansr);
        System.out.println(ans);

    }
}
