package gfg;

/**
 * The knight is placed on the first block of an empty board and,
 * moving according to the rules of chess,
 * must visit each square exactly once.
 */
public class KnightTour {
    //棋盘大小
    static int N = 8;

    //在棋盘内
    static boolean isSafe(int x, int y, int sol[][]) {
        return (x >= 0 && x < N && y >= 0 &&
                y < N && sol[x][y] == -1);
    }

    static void printSolution(int sol[][]) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++)
                System.out.print(sol[x][y] + " ");
            System.out.println();
        }
    }

    //马跳的8个方向
    static int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
    static int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};

    static boolean solver() {
        int sol[][] = new int[8][8];
        for (int x = 0; x < N; x++)
            for (int y = 0; y < N; y++)
                sol[x][y] = -1;

        //起点
        sol[0][0] = 0;
        if (!solveKTUtil(0, 0, 1, sol)) {
            System.out.println("Solution does not exist");
            return false;
        } else
            printSolution(sol);

        return true;
    }

    static boolean solveKTUtil(int x, int y, int movei,
                               int sol[][]) {
        int k, next_x, next_y;
        //肯定跳64步
        if (movei == N * N)
            return true;
        for (k = 0; k < 8; k++) {
            next_x = x + xMove[k];
            next_y = y + yMove[k];
            if (isSafe(next_x, next_y, sol)) {
                sol[next_x][next_y] = movei;
                //如果这个格子能到达终点
                if (solveKTUtil(next_x, next_y, movei + 1,
                        sol))
                    return true;
                else {
                    //如果不能 不走这个格子
                    sol[next_x][next_y] = -1;// backtracking

                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        solver();

    }
}
