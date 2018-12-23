package leetcode;

import java.util.Arrays;

public class lc354 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a, b) -> b[0]*b[1] - a[0]*a[1]);
        if(envelopes.length < 2)return envelopes.length;
        int[] small = envelopes[0];
        int cnt  =1;

        for(int i =1;i<envelopes.length;i++){
            if(envelopes[i][0] - small[0] >0 && envelopes[i][1] - small[1] >0 ){
                small = envelopes[i];
                cnt++;
            }
        }
        return cnt;
    }
}
