package gfg;

public class nqueenback {
    int N = 4;

    public nqueenback(int n) {
        this.N = n;
    }
    void printSolution(int board[][])
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j]
                        + " ");
            System.out.println();
        }
    }
    boolean isSafe(int board[][], int row, int col) {
        int i, j;
        //这一行是不是已经有了
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;
        //左上对角线
        for (i=row, j=col; i>=0 && j>=0; i--, j--)
            if (board[i][j] == 1)
                return false;
        //左下对角线
        for (i=row, j=col; j>=0 && i<N; i++, j--)
            if (board[i][j] == 1)
                return false;
        return true;
    }
    //一列一列放
    //不返回true/false 每次col==N打印 可以输出所有解
        void solverUtil(int[][] board,int col){
        if(col>=N){
//            printSolution(board);
//            System.out.println();
return;
//            return true;
        }
        for (int i = 0; i < N; i++) {
            if(isSafe(board, i, col)){
                board[i][col] = 1;
                solverUtil(board,col+1 );
//                if(solverUtil(board,col+1))
//                    return true;
                //不safe 换一行
                board[i][col] = 0;
            }

        }
//        return false;
    }
    boolean solver(){
        int[][] board = new int[N][N];
        solverUtil(board,0 );
//        if(!solverUtil(board,0 ))
//            System.out.println("false");
//        printSolution(board);
        return true;
    }


    public static void main(String[] args) {
//        37136 15个用时
        nqueenback sl = new nqueenback(15);

        long start = System.currentTimeMillis();
        sl.solver();

        long end = System.currentTimeMillis();
        System.out.println(end-start);

    }
}
