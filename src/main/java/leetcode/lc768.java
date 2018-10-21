package leetcode;

import java.util.Arrays;

public class lc768 {
    public int maxChunksToSorted100(int[] arr) {
        int n = arr.length;
        int[] minOfRight = new int[n];
        minOfRight[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minOfRight[i] = Math.min(minOfRight[i + 1], arr[i]);
        }
        int res = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(max,arr[i]);
            if (max <= minOfRight[i + 1]) res++;
        }
        return res + 1;
    }

    public int maxleftlessright(int[] arr){
        int n = arr.length;
        int[] maxLeft = new int[n];
        int[] minRight = new int[n];
        maxLeft[0] = arr[0];
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i-1],arr[i]);
        }
        minRight[n-1] = arr[n-1];
        for (int i = n-2; i >= 0 ; i--) {
            minRight[i] = Math.min(minRight[i+1],arr[i]);
        }

        System.out.println(Arrays.toString(maxLeft));
        System.out.println(Arrays.toString(minRight));
        int res = 0;
        for (int i = 0; i < n-1; i++) {
            if(maxLeft[i] <= minRight[i+1]){
                System.out.println(maxLeft[i] +" "+ minRight[i+1]);
                res++;
            }
        }
        return res+1;
    }
    public int maxChunksToSorted(int[] arr) {
        int sum1 = 0,sum2 = 0,ans = 0;
        int[] copy = arr.clone();
        Arrays.sort(copy);
        for (int i = 0; i < arr.length; i++) {
            sum1 += copy[i];
            sum2 += arr[i];
            if(sum1 == sum2)ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,3,4,4};
        lc768 sl = new lc768();
        System.out.println(sl.maxChunksToSorted100(arr));
    }
}
