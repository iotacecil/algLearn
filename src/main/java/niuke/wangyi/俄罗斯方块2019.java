package niuke.wangyi;

import java.util.Scanner;

public class 俄罗斯方块2019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] fk = new int[n];
        for (int i = 0; i < m; i++) {
            int idx = sc.nextInt();
            fk[idx - 1]++;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(fk[i], min);

        }
        System.out.println(min);
    }
}
