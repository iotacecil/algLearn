package luogu;

import java.util.Scanner;

public class p1420 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int cnt = 0;
        int rst = 0;
        for (int i = 1; i < N; i++) {
            if (arr[i] - arr[i - 1] == 1) {
                cnt++;
            } else {
                rst = Math.max(cnt + 1, rst);
                cnt = 0;
            }

        }
        System.out.println(rst);
    }
}
