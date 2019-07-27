package niuke.pdd;

import java.util.Arrays;
import java.util.Scanner;

//
public class 两两匹配差最小2019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int i = 0;
        int j = n - 1;
        int max = arr[0] + arr[n - 1];
        int min = arr[0] + arr[n - 1];
        while (i < j) {
            int tmp = arr[i] + arr[j];
            max = Math.max(tmp, max);
            min = Math.min(tmp, min);
            i++;
            j--;
        }


        //int min = arr[n / 2 - 1] + arr[n / 2];
//        System.out.println(max);
//        System.out.println(min);
        System.out.println(max - min);
    }
}
