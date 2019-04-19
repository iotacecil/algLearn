package niuke;

import java.util.Scanner;

/*
???
链接：https://ac.nowcoder.com/acm/contest/186/C
来源：牛客网

需要将所选武器分别放在天平的两端，
若天平平衡则可以将天平上的所有武器拿走，
只要两端重量相差小于等于m就会保持平衡，
Alice傻傻的认为越重的武器越好，求Alice最多能拿走的武器总重量。
5 4
1 5 61 65 100
 */
public class contest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();


        int maxdif = 10000;
        int[][] dp = new int[n + 1][maxdif + 1];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            for (int j = 0; j <= maxdif; j++) {
                dp[i + 1][j] = dp[i][j];
                if (j + x <= maxdif)
                    dp[i + 1][j + x] = Math.max(dp[i + 1][j + x], dp[i][j] + x);
                //if(Math.abs(j-x) <=maxdif)
                dp[i + 1][Math.abs(j - x)] = Math.max(dp[i + 1][Math.abs(j - x)], dp[i][j] + x);
            }
        }

        int rst = 0;
        for (int j = 0; j <= m; j++) {
            rst = Math.max(dp[n][j], rst);
        }


        System.out.println(rst);

    }
}
