package niuke.nowcode;

import java.util.Arrays;
import java.util.Scanner;

public class 老师分糖果2019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();

        }
        int[] left = new int[n];
        Arrays.fill(left, 1);


        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        int[] right = new int[n];
        Arrays.fill(right, 1);
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }
        int rst = 0;

        for (int i = 0; i < n; i++) {
            rst += Math.max(left[i], right[i]);

        }
        System.out.println(rst);
    }
}
