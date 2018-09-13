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
}
