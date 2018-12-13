package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc862 {
    public static void main(String[] args) {
        int[] A = {-28,81,-20,28,-29};

//        int[] A = {2,-1,2};
        int K = 89;
        lc862 sl = new lc862();
        System.out.println(sl.shortestSubarrayWindow(A, K));
    }

    public int shortestSubarrayWindow(int[] A, int K) {
        int n = A.length;
        long[] presum = new long[n+1];

        for (int i = 0; i <n ; i++) {
            if(A[i] >=K)return 1;
            presum[i+1] = presum[i] +A[i];
        }
        int minlen = n+1;

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i <n ; i++) {

            while (deque.size() >0 && presum[i] - presum[deque.getFirst()] >= K){

                minlen = Math.min(minlen, i-deque.pollFirst());
            }
            // 关键
            while (deque.size() > 0 && presum[i] <= presum[deque.getLast()]){
             deque.pollLast();
            }
            deque.addLast(i);

        }
        return minlen == n+1?-1:minlen;

    }
        public int shortestSubarray(int[] A, int K) {
        int l = 0,r = 0,n = A.length;

        int minlen = n + 1;
        while(l < n ){
            int sum = A[l];
            if(sum >= K){
               return 1;
            }
            System.out.println(l+ " "+r+" "+sum);

            r=l+1;
            while(r<n){
                sum+=A[r];
                if(r-l+1 > minlen)break;
                if(sum >= K){
                    minlen = Math.min(minlen, r-l+1);
                    System.out.println(l+ " "+r+" "+sum);


                    break;
                }
                r++;
            }
            l++;
        }
        return minlen == n+1?-1:minlen;
    }


}
