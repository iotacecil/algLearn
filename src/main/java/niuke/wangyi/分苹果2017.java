package niuke.wangyi;

import java.util.Scanner;

public class 分苹果2017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        //5 7 9 15 sum = 36 -> 9  [-4,-2,0,6]
        if (sum % n != 0) {
            System.out.println(-1);
            return;
        }
        int avg = sum / n;
        int rst = 0;
        for (int i = 0; i < n; i++) {
            arr[i] -= avg;
            if (arr[i] % 2 != 0) {
                System.out.println(-1);
                return;
            }
            if (arr[i] > 0) {
                rst += arr[i] / 2;
            }
        }
        System.out.println(rst);
    }
}
