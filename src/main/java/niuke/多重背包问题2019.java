package niuke;

import java.util.Scanner;

//多重背包还可以把每个库存拆成不同的单个物品 直接01背包
public class 多重背包问题2019 {
    private static class Good {
        int v;
        int w;
        int s;

        public Good(int v, int w, int s) {
            this.v = v;
            this.w = w;
            this.s = s;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        Good[] goods = new Good[N];

        for (int i = 0; i < N; i++) {
            goods[i] = new Good(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        int[][] rst = new int[N + 1][V + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= V; j++) {
                if (goods[i - 1].v > j) rst[i][j] = rst[i - 1][j];
                else {
                    for (int k = 0; k * goods[i - 1].v <= j && k <= goods[i - 1].s; k++) {
                        rst[i][j] = Math.max(rst[i][j], rst[i - 1][j - k * goods[i - 1].v] + k * goods[i - 1].w);

                    }
                }

            }

        }
        System.out.println(rst[N][V]);
    }
}
