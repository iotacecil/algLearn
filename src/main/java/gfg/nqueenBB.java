package gfg;

import java.util.Arrays;
//8只有92个互不相同的解。如果将旋转和对称的解归为一种的话，则一共有12个独立解
public class nqueenBB {

    //  / diagonal
    //  \ diagonal
//    The trick is to fill them in such a way that two queens
// sharing a same /­diagonal will have the same value in matrix slashCode,
// and if they share same \­diagonal, they will have the same value in backslashCode matrix.
    int N = 4;
    public nqueenBB(int n) {
        N = n;
    }
    void printSolution(int[][] board)
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.printf("%2d ", board[i][j]);
            System.out.printf("\n");
        }
    }
    int[][] slashCode, backslashCode;
    //记录这个code是不是已经占用了
    boolean[] rowocc;
    boolean[] slashocc,backslashocc;
    boolean isSafe(int[][] board,int row, int col)
    {
        if (slashocc[slashCode[row][col]] ||
                backslashocc[backslashCode[row][col]] ||
                rowocc[row])
            return false;

        return true;
    }
    int cnt = 0;
    void solverUtil(int[][] board,int col){
        if(col>=N){
            cnt++;
//            printSolution(board);
//            System.out.println();
            return;
//            return true;
        }
        for (int i = 0; i < N; i++) {
            if(isSafe(board,i,col )){
                board[i][col] = 1;
                rowocc[i] = true;
                slashocc[slashCode[i][col]] = true;
                backslashocc[backslashCode[i][col]] = true;
                solverUtil(board,col+1);
//                if(solverUtil(board,col+1))
//                    return true;
                board[i][col] = 0;
                rowocc[i] = false;
                slashocc[slashCode[i][col]] = false;
                backslashocc[backslashCode[i][col]] = false;
            }

        }

//        return false;
    }
    boolean solver(){
        int[][] board = new int[N][N];
        slashCode = new int[N][N];
        backslashCode = new int[N][N];
        rowocc = new boolean[N];
        //对角线数字一共有0~2N-2 一共2N-1个
        slashocc = new boolean[2*N-1];
        backslashocc = new boolean[2*N-1];


        for (int r = 0; r <N ; r++) {
            for (int c = 0; c <N ; c++) {
               slashCode[r][c]=r+c;
               backslashCode[r][c]=r-c+(N-1);
            }
        }
//        printSolution(slashCode);
//        printSolution(backslashCode);
        solverUtil(board,0 );
//        if(!solverUtil(board,0 )){
//            return false;
//
//        }
//        printSolution(board);

        return true;
    }
    public static void main(String[] args) {
//        28858 15个用时

    nqueenBB sl = new nqueenBB(15);

        long start = System.currentTimeMillis();
        sl.solver();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println(sl.cnt);

    }
}
