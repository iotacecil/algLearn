package niuke.duxiaoman;

import java.util.Scanner;

/*
桌面上有a0个不同盒子和b0个不同的物品，每个回合，
两个人可以选择增加一个新的盒子或者一个新的物品(所有物品和盒子都不同)，
记当前桌子上的盒子数量为a，物品数量为b，当把b个物品放入a个盒子的方案数不小于n时


给出a0，b0，n，如果小A先手，两个人都采用最优策略，

谁能获胜，如果A获胜输出“A”，如果B获胜，输出“B”，如果是平局，输出“A&B”。

n个不同的球，放入m个不同的盒子，允许为空m^n


答案错误:您提交的程序没有通过所有的测试用例
case通过率为6.67%

答案错误:您提交的程序没有通过所有的测试用例
case通过率为6.67%

用例:
10
1 27 6235
2 8 1138
2 8 4780
1 8 9392
1 24 707
61 1 3073
1 15 725
4 3 396
1 28 1559
1 26 1343

对应输出应该为:

A&B
A
A
A
A&B
B
A&B
B
A&B
A&B

你的输出为:

A&B
A
A
A&B
A&B
A
A&B
B
A&B
A&B
 */
public class 小游戏2019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int n = sc.nextInt();
            switch (judge(a, b, n)) {
                case 1:
                    System.out.println("B");
                    break;
                case -1:
                    System.out.println("A");
                    break;
                case 0:
                    System.out.println("A&B");
                    break;
            }

        }
    }

    //1 赢 -1 输
    public static int judge(int a0, int b0, int n) {
        if (a0 == 1) return 0;
        if (Math.pow(a0, b0) >= n) return 1;
        // judge对方
        if (judge(a0 + 1, b0, n) == 1 || judge(a0, b0 + 1, n) == 1) return -1;
        return 1;
    }


}
