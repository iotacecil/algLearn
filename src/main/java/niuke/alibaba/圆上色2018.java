package niuke.alibaba;

import java.util.Scanner;

/*
一个圆，被分成N个部分，用K种颜色给每个部分上色，要求相邻区域颜色不能相同。有多少种上色方案？
n=1 k种
n!=1有k*(k-1)^(n-1)种方法
但是最后一个区域不能与第一个区域相同，所以这里需要减去一些东西。
An = m*(m-1)^(n-1)  -  A_{n-1}

https://www.cnblogs.com/ranjiewen/p/8539095.html
 */
public class 圆上色2018 {
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        System.out.print(helper(N, M));
    }

    private static int helper(int N, int M) {
        if (N == 0)
            return M;
        return M * (int) Math.pow(M - 1, N - 1) - helper(N - 1, M);
    }
}
