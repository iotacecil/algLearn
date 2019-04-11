package luogu;

import java.util.Arrays;
import java.util.Scanner;

//每一次都要在找到比当前该凑数钱小的最大面值数
/*
20 4
1 2 5 10
 */
public class p1658 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        Arrays.sort(coins);
        if (coins[0] != 1) System.out.println(-1);
        else {
            int cnt = 0;
            //凑最大面值
            int sum = 0;
            while (sum < x) {
                int i;
                for (i = n - 1; i >= 0; i--) {
                    if (coins[i] <= sum + 1) break;
                }
                cnt++;
                sum += coins[i];
            }
            System.out.println(cnt);
        }
    }

}
