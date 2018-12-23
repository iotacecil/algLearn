package leetcode;

import java.util.Arrays;

public class lc888 {
  
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        int n = A.length;
        int sumB = 0;
        int m = B.length;
        for(int t:A){
            sumA += t;
        }

        for(int t:B){
            sumB += t;
        }
        Arrays.sort(A);
        Arrays.sort(B);
        int dif = sumA - sumB;
        System.out.println(dif);
        for(int i = 0;i<n;i++){
            // 二分查找 B[j] = dif /2 +A[i];
            int target = -dif/2 + A[i];
            System.out.println(target);
            int bidx = Arrays.binarySearch(B,target);
            if(bidx<0)continue;
            else{
                return new int[]{A[i],B[bidx]};
            }

        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        lc888 sl= new lc888();
        int[] A = {1,1};
        int[] B = {2,2};
//        System.out.println(Arrays.binarySearch(B, 3));

        System.out.println(Arrays.toString(sl.fairCandySwap(A, B)));
    }
}
