package ltc;

import java.util.ArrayList;
import java.util.List;

public class lt402 {
    public List<Integer> continuousSubarraySum(int[] A) {
        List<Integer> rst = new ArrayList<>();
        int n = A.length;
        int minsum = 0,presum = 0;
        int maxsum = Integer.MAX_VALUE;
        int minidx = -1;
        int l = -1,r = -1;
        for (int i = 0; i <n ; i++) {
            presum = presum +A[i];
            if(presum - minsum > maxsum){
                maxsum = presum - minsum;
                l = minidx +1;
                r =  i;
            }
            if(presum < minsum){
                minsum = presum;
                minidx = i;
            }

        }
        rst.add(l);
        rst.add(r);
        return  rst;
    }

    public static void main(String[] args) {
        int[] A = {-3,1,3,-3,4};
        lt402 sl = new lt402();
        System.out.println(sl.continuousSubarraySum(A));
    }
}
