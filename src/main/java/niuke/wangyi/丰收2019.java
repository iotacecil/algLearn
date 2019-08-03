package niuke.wangyi;

import java.util.Arrays;
import java.util.Scanner;

public class 丰收2019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] presum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            presum[i + 1] = presum[i] + arr[i];
        }
        int m = sc.nextInt();
        //0 2 9 12 16 25
        //1 25 11
//        System.out.println(Arrays.toString(presum));
        for (int i = 0; i < m; i++) {
            int idx = Arrays.binarySearch(presum, sc.nextInt());
//            System.out.println(idx);
            if (idx < 0) {
                idx = -(idx + 1);
            }
            System.out.println(idx);
//            System.out.println();


        }
    }
}
