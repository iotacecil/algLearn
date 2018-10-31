package leetcode;

import java.util.HashMap;
import java.util.Map;

public class lc930 {
    public int numSubarraysWithSum(int[] A, int S) {
        Map<Integer,Integer> presum = new HashMap<>();

        int sum = 0;
        int cnt = 0;
        for (int i = 0; i <A.length ; i++) {
            sum += A[i];
            if(presum.get(sum-S) != null){
                cnt += presum.get(sum - S);
            }
            if(sum == S){
                cnt++;
            }
            presum.put(sum, presum.getOrDefault(sum, 0) +1);
        }
        return cnt;

    }

    public static void main(String[] args) {
        int [] A = {0,0,0,0,0,0,1,0,0,0};
//        int [] A = {0,1,1,1,1};

        int S = 0;
        lc930 sl = new lc930();
        System.out.println(sl.numSubarraysWithSum(A, S));
    }
}
