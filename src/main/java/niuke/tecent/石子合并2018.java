package niuke.tecent;

import java.util.Scanner;

public class 石子合并2018 {
    //合并将得到一堆x+y个石子的石子堆
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int rst = 0;
        for (int i = 0; i < n - 1; i++) {
            // rst = 2 arr[3,3] rst+=9 arr[6]
            rst += (arr[i] * arr[i + 1]);
            arr[i + 1] += arr[i];
        }
        System.out.println(rst);

    }
}
