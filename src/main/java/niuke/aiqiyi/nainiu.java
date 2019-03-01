package niuke.aiqiyi;

import java.util.Arrays;
import java.util.Scanner;

public class nainiu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
//        int min = Integer.MAX_VALUE;
        long mod = 1_000_000_007;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            arr[i] = a;
//            min = Math.min(a, min);
            if(arr[i] >= n)flag = true;
        }

        if(!flag) System.out.println(0);
        else {

            long res = 1;
            Arrays.sort(arr);
            res = (res * arr[0]) %mod;
            for (int i = 1; i <arr.length ; i++) {
                res = (res * (arr[i] -i)) % mod;
            }
//            int cnt = 0;
//            for (int i = 0; i < n; i++) {
//                if (arr[i] == min) {
//                    res = (res * (arr[i] - cnt)) % mod;
//                    cnt++;
//                } else {
//                    res = (res * (arr[i] - 1)) % mod;
//                }
//            }
            System.out.println(res);
        }
    }
}
