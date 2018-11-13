package leetcode;

import java.util.ArrayList;
import java.util.List;

public class lc813 {
    public static void main(String[] args) {
        String prefix = "aaa";
        List<String> dict = new ArrayList<>();
        
        System.out.println(prefix.substring(0,1));
    }
//    public double largestSumOfAverages(int[] A, int K) {
//        int n = A.length;
//        int[] presum = new int[n];
//        presum[0] = A[0];
//        for(int i = 1;i < n;i++){
//            presum[i] = presum[i-1]+A[i];
//        }
//
//        double[][] memo = new double[n+1][n+1];
//        double cur = 0;
//        for (int i = 0; i < n; i++) {
//            cur += A[i];
//            memo[i+1][1] = cur / (i + 1);
//
//        }
//
//    }
//    // idx = 1
//    public double back(int[] presum,int[] A,int n,int K,int idx){
//        if(K == 1){
//            return (presum[n - 1] - presum[idx-1]) / (n - idx + 1);
//        }
//
//        for (int i = idx; i <= n - K + 1; i++) {
//            int sum = Math.max()
//
//        }
//    }
}
