package niuke.pdd;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class yinhang_unsorted {
    // 输出[0,n]
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
        long[] w = new long[n];
        Map<Long,Long> map = new HashMap<>();
        for (int i = 0; i <n ; i++) {
            w[i] = sc.nextLong();
            map.put(w[i],sc.nextLong());
        }
        Arrays.sort(w);
        long max = -1;
        // [i:n-1]的最大值
        long[] backsmax = new long[n+1];
        backsmax[n] = -1;
        for (int i = n-1; i >= 0; i--) {
            backsmax[i] = Math.max(backsmax[i+1],map.get(w[i]));
        }
        for (int i = 0; i <n ; i++) {
            long tmp = w[i] + d;
            int idx = lowerBound(w, tmp);
            if(backsmax[idx] + map.get(w[i]) > max){
                max = Math.max(max, backsmax[idx] + map.get(w[i]));
            }
        }
        System.out.println(max);
    }
}
