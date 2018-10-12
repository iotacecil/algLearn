package other_oj;

import java.util.Arrays;
import java.util.Scanner;

public class poj2559 {
    //7184K	1579MS
    public static long maxRec(int[] histo){
        int n = histo.length;
        int[] stack = new int[n];
        // j<=i hj-1<hi 的最大j
        //栈顶j<i j+1
        int[] L = new int[n];
        //j>i 并且hj>hi的最小j
        int[] R = new int[n];
        //栈顶+1
        int t =0;
        for (int i = 0; i < n ; i++) {
            //栈顶>=当前 弹出
            while (t>0&&histo[stack[t-1]]>=histo[i])t--;
            L[i] = t ==0?0:(stack[t-1]+1);
            stack[t++] = i;
        }
        t = 0;
        stack = new int[n];
        for (int i = n-1; i >=0 ; i--) {
            while (t>0&&histo[stack[t-1]]>=histo[i])t--;
            R[i] = t ==0?n:(stack[t-1]);
            stack[t++] = i;
        }
        System.out.println(Arrays.toString(L));
        System.out.println(Arrays.toString(R));
        long res = 0;
        for (int i = 0; i <n ; i++) {
            res = Math.max(res,(long)histo[i]*(R[i]-L[i]));
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n ;
        while ((n=sc.nextInt())!=0){
            int[] histo = new int[n];
            for (int i = 0; i <n ; i++) {
                histo[i] = sc.nextInt();
            }
            System.out.println(maxRec(histo));

        }
    }
}
