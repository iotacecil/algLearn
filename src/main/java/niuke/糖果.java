package niuke;

import org.junit.jupiter.api.Test;

import java.util.Scanner;


public class 糖果 {

    @Test
    public void testgcd() {
        System.out.println(maxDiv(10, 5));
        System.out.println(maxDiv(2, 10));
    }

    private static int maxDiv(int a, int b) {
        // a 大
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        while (a % b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return b;

    }

    static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] candy = new int[n];
        for (int i = 0; i < n; i++) {
            candy[i] = sc.nextInt();
        }
        boolean[][] map = new boolean[n][n];
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (maxDiv(candy[i], candy[j]) > 1) {
                    map[i][j] = true;
                    map[j][i] = true;
                }
            }
        }
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                dfs(map, used, i, 1);
            }
        }
        System.out.println(max);

    }

    private static void dfs(boolean[][] map, boolean[] used, int idx, int cnt) {
        max = Math.max(max, cnt);
        used[idx] = true;
        for (int i = 0; i < used.length; i++) {
            if (map[idx][i] && !used[i]) {
                dfs(map, used, i, cnt + 1);
            }

        }
    }
}
