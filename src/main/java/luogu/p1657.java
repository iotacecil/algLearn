package luogu;

import java.util.Scanner;

/*
有1,2,3……x本书，
要分给参加培训的x个人，每人只能选一本书，但是每人有两本喜欢的书。
希望设计一个程序帮助老师求出所有可能的分配方案，使每个学生都满意。
 */
public class p1657 {
    static int cnt = 0;

    private static void dfs(int i, boolean[][] like, boolean[] marked) {
        for (int j = 0; j < like.length; j++) {
            if (!marked[j] && like[i][j]) {
                marked[j] = true;
//                book[i] = j;
                // 关键只有最后一个人成功找到数才计数
                if (i == like.length - 1) cnt++;
                else {
                    dfs(i + 1, like, marked);
                }
                marked[j] = false;
//                book[i] = -1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean[][] like = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            like[i][sc.nextInt() - 1] = true;
            like[i][sc.nextInt() - 1] = true;
        }
        dfs(0, like, new boolean[N]);
        System.out.println(cnt);
    }
}
