package niuke.wangyi;

import java.util.Scanner;

/*
一种双核CPU的两个核能够同时的处理任务，现在有n个已知数据量的任务需要交给CPU处理，
假设已知CPU的每个核1秒可以处理1kb，每个核同时只能处理一项任务。
n个任务可以按照任意顺序放入CPU进行处理，现在需要设计一个方案让CPU处理完这批任务所需的时间最少，求这个最小的时间。

输入描述:
输入包括两行： 第一行为整数n(1 ≤ n ≤ 50) 第二行为n个整数length[i](1024 ≤ length[i] ≤ 4194304)，
表示每个任务的长度为length[i]kb，每个数均为1024的倍数。

输出描述:
输出一个整数，表示最少需要处理的时间

输入例子1:
5 3072 3072 7168 3072 1024

输出例子1:
9216

 */
public class cpu2017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] tasks = new int[n];
        long[] a = new long[n];
        long[] b = new long[n];
        int m = 0;
        for (int i = 0; i < n; i++) {
            tasks[i] = sc.nextInt() / 1024;
            m += tasks[i];
        }

        boolean[][] dp = new boolean[n + 1][m / 2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m / 2; j++) {
                if (j - tasks[i - 1] >= 0)
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - tasks[i - 1]];
                else dp[i][j] = dp[i - 1][j];
            }
        }
        for (int x = m / 2; x >= 0; x--) {
            if (dp[n][x]) {
                System.out.println((m - x) * 1024);
                break;
            }
        }
    }
}
/*

case通过率为80.00%

用例:
5
2253824 3233792 668672 3116032 1232896

对应输出应该为:

5369856

你的输出为:

5368832
 */