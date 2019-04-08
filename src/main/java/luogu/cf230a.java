package luogu;

import java.util.Arrays;
import java.util.Scanner;

// 有一个wa
public class cf230a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int n = sc.nextInt();
        int[][] lo = new int[n][2];
        for (int i = 0; i < n; i++) {
            lo[i][0] = sc.nextInt();
            lo[i][1] = sc.nextInt();
        }
        Arrays.sort(lo, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            if (v < lo[i][0]) {
                System.out.println("NO");
                break;
            }
            v += lo[i][1];
            if (i == n - 1) System.out.println("YES");
        }
    }
}
