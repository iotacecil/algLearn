package leetcode;

import java.util.Arrays;

public class lc354 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a, b) ->a[0]-b[0]!=0?a[0]-b[0]:b[1] - a[1]);
        System.out.println(Arrays.deepToString(envelopes));
        if(envelopes.length < 2)return envelopes.length;
        int len = 0;
        int n = envelopes.length;
        int[]dp = new int[n];
        for(int[] env :envelopes){
            int idx = Arrays.binarySearch(dp, 0,len,env[1]);
            System.out.println(Arrays.toString(env));

            if(idx < 0){
                idx = -(idx+1);
            }
            System.out.println(idx);
            dp[idx] = env[1];
            if(idx == len)len++;
        }
        System.out.println(Arrays.toString(dp));
        return len;
    }

    public static void main(String[] args) {
        int[][] envs = {{1,2},{1,3},{2,3},{2,5},{4,3},{6,7},{8,9},{10,11}};
        lc354 sl = new lc354();
        System.out.println(sl.maxEnvelopes(envs));

    }

}
