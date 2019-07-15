package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class lc786 {

    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        int n = A.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return A[a[0]]*A[n-1-b[1]] - A[n-1-a[1]]*A[b[0]];
        });
        for (int i = 0; i <n ; i++) {
            pq.add(new int[]{i,0});

        }
        while (--K >0){
            int[] p = pq.poll();
            if(++p[1] <n){
                pq.add(p);
            }
        }
        return new int[]{A[pq.peek()[0]],A[n-1-pq.peek()[1]]};
    }

    public static void main(String[] args) {
        lc786 sl = new lc786();
        System.out.println(Arrays.toString(sl.kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3)));
    }
}
