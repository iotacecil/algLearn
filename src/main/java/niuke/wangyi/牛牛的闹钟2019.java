package niuke.wangyi;

import java.util.Arrays;
import java.util.Scanner;

public class 牛牛的闹钟2019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] clock = new int[n][2];
        for (int i = 0; i < n; i++) {
            clock[i] = new int[]{sc.nextInt(), sc.nextInt()};

        }
        int x = sc.nextInt();

        int A = sc.nextInt();
        int B = sc.nextInt();
        Arrays.sort(clock, (a, b) -> a[0] * 60 + a[1] - b[0] * 60 - b[1]);
        for (int i = 0; i < n - 1; i++) {
            int time1 = clock[i][0] * 60 + clock[i][1];
            int time2 = clock[i + 1][0] * 60 + clock[i + 1][1];
            if (time1 + x <= A * 60 + B && time2 + x > A * 60 + B) {
                System.out.println(clock[i][0] + " " + clock[i][1]);
                return;
            }


        }
        System.out.println(clock[n - 1][0] + " " + clock[n - 1][1]);
    }
}
