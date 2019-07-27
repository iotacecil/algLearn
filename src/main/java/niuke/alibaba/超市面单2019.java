package niuke.alibaba;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*


https://www.cnblogs.com/mfrank/p/10816837.html


作者：宇智波若兰
链接：https://www.nowcoder.com/discuss/177358?type=2
来源：牛客网


享受在一个包裹内最大体积V，最大重量M内免单
假设商品i,体积Vi,重量Mi,库存Si,价格Pi
目前天猫超市的商品分为生鲜水产(1)、食品酒水(2),美妆个护(3),居家生活(4)四大类
[生鲜水产(1)不与美妆个护(3)同包裹\
请你帮助小明在购物车里添置商品使得总价值最大
输入:
商品总种类n,包裹限定总体积v,包裹限定总重量m(接下来会有n行)
商品1体积,商品1重量,商品1库存,商品1价格,商品1类型
商品2体积,商品2重量,商品2库存,商品2价格,商品2类型
商品3体积,商品3重量,商品3库存,商品3价格,商品3类型
输出:
购物车里商品的总价值
输入范例:
输入范例:
3,40,30
10,10,10,10,1
13,10,12,11,3
3,4,6,5,3


3,40,30
10,10,10,10,1

2:26,20,val:22 left:14,10
3:39,30 val:33
13,10,12,11,3
3,4,6,5,3   5*5=25  3*5=15 4*5=20 left:25,10


3,40,30
10,10,10,10,1
v  m  st p    13 10 11  3 4 5  4->12,14,+20  left:22,6
13,10,12,11,3
3, 4, 6, 5,3
输出范例:
33
 */
public class 超市面单2019 {
    private static int dpway(Good[] goods, int V, int M) {
        //  System.out.println(V+ " "+M);
        //dp[i][j] 用前i个物品
        int[][][] dp = new int[goods.length + 1][V + 1][M + 1];
        for (int i = 1; i <= goods.length; i++) {
            for (int j = 1; j <= V; j++) {
                for (int k = 1; k <= M; k++) {
                    if (j < goods[i - 1].v || k < goods[i - 1].m) {
                        dp[i][j][k] = dp[i - 1][j][k];
                    } else {
                        for (int l = 0; l <= goods[i - 1].stock && l * goods[i - 1].v <= j && l * goods[i - 1].m <= k; l++) {
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - l * goods[i - 1].v][k - l * goods[i - 1].m] + l * goods[i - 1]
                                    .price);
                            System.out.println("i:" + i + " l:" + l + " price " + dp[i][j][k]);

                        }
                    }

                }

            }

        }
        return dp[goods.length][V][M];
    }


    //    只能有一个包裹
    private static int dfs(Good[] goods, int V, int M, int n) {
//        System.out.println(n);
        int rst = 0;
        if (n == 0) {
            if (goods[0].v <= V && goods[0].m <= M) return goods[0].price;
            else return 0;
        }
        if (goods[n].m > M || goods[n].v > V) {
            rst = dfs(goods, V, M, n - 1);
        } else {
            // 装得下
            for (int k = 0; k <= goods[n].stock && k * goods[n].v <= V && k * goods[n].m <= M; k++) {
                Good[] tmp = goods.clone();
                tmp[n].stock -= k;
                rst = Math.max(k * goods[n].price + dfs(tmp, V - goods[n].v, M - goods[n].m, n - 1),
                        rst);
            }

        }
        return rst;

//        dfs(goods,V,M,)

    }

    static class Good {
        int v;
        int m;
        int stock;
        int price;
        int type;

        public Good(String[] in) {
            this.v = Integer.parseInt(in[0]);
            this.m = Integer.parseInt(in[1]);
            this.stock = Integer.parseInt(in[2]);
            this.price = Integer.parseInt(in[3]);
            this.type = Integer.parseInt(in[4]);
        }

        @Override
        public String toString() {
            return "Good{" +
                    "v=" + v +
                    ", m=" + m +
                    ", stock=" + stock +
                    ", price=" + price +
                    ", type=" + type +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] in = sc.next().split(",");
        //商品总种类n
        int n = Integer.parseInt(in[0]);
        int V = Integer.parseInt(in[1]);
        int M = Integer.parseInt(in[2]);
        List<Good> goods1 = new ArrayList<>();
        List<Good> goods2 = new ArrayList<>();
        List<Good> goods = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] str = sc.next().split(",");
            if (str[str.length - 1].equals("1")) {
                goods1.add(new Good(str));
            } else if (str[str.length - 1].equals("3")) {
                goods2.add(new Good(str));
            } else {
                goods.add(new Good(str));
            }
        }
        goods1.addAll(goods);
        Good[] gd1 = goods1.toArray(new Good[0]);


        goods2.addAll(goods);
        Good[] gd2 = goods2.toArray(new Good[0]);

        System.out.println(Arrays.toString(gd1));
        System.out.println(Arrays.toString(gd2));
//        System.out.println(Math.max(dfs(gd1, V, M, gd1.length - 1), dfs(gd2, V, M, gd2.length - 1)));
        System.out.println(Math.max(dpway(gd1, V, M), dpway(gd2, V, M)));


    }
}
