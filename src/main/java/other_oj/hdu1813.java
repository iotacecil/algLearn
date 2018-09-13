package other_oj;

import java.util.Scanner;

/**
 * ：不论Lele被扔在哪里，Lele按照序列里的方向命令一个一个地走，每个命令走一格，如果走的时候会碰到坏的格子，则忽略这条命令。
 * 当然，如果已经逃脱了，就可以不考虑序列中剩下的命令了。
 * 4
 1101
 0001
 1100
 1001
 */
public class hdu1813 {
    static int dx[] = { 0, -1, 1, 0 }, dy[] = { 1, 0, 0, -1 };
    static int n;
    static int[][] grid;
    int t =0;
    static void init(){
        int i,j;

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }


    }
}
