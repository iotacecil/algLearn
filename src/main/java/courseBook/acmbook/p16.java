package courseBook.acmbook;

import java.util.Arrays;

public class p16 {
    public int maxC(int[] A){
        Arrays.sort(A);
        int n = A.length;
        for (int i = n-1; i >=2 ; i--) {
            if(A[i]<A[i-1]+A[i-2])return A[i]+A[i-1]+A[i-2];
        }
        return 0;
    }
    public static void main(String[] args) {
        int n = 5;
        int[] a = {2,3,4,5,10};
        p16 sl = new p16();
        System.out.println(sl.maxC(a));

    }
}
