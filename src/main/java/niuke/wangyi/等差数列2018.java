package niuke.wangyi;

import java.util.Arrays;
import java.util.Scanner;

public class 等差数列2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();

        }
        Arrays.sort(arr);
        int dif = arr[1] - arr[0];
        for (int i = 2; i < n; i++) {
            if (arr[i] - arr[i - 1] != dif) {
                System.out.println("Impossible");
                return;
            }
        }
        System.out.println("Possible");
    }
}
