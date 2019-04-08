package leetcode;

import java.util.Arrays;

public class lc1020 {


    public boolean canThreePartsEqualSum(int[] A) {
        int n = A.length;
        int[] presum = new int[n+1];
        for (int i = 0; i < n; i++) {
            presum[i+1] = presum[i]+A[i];
        }
        System.out.println(Arrays.toString(presum));
        // [i,j)   [j,
        for (int i = 0; i <n ; i++) {
            for (int j = i+1; j < n+1; j++) {
                if(presum[i]-presum[0]==presum[j] - presum[i] &&presum[j] - presum[i]== presum[n]-presum[j]){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {0,2,1,-6,6,7,9,-1,2,0,1};
        lc1020 sl = new lc1020();
        System.out.println(sl.canThreePartsEqualSum(arr));
    }
}
