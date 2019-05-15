package leetcode;

public class lc37 {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0)
            return;
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) return true;
                            else board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) return false;
            if (board[row][i] == c) return false;
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false;
        }
        return true;
    }

    //    public int subarraysDivByK(int[] A, int K) {
//        int n = A.length;
//        int rst = 0;
//        int[] presum = new int[n+1];
//        //[1]-[0] = pre[0:1)
//        for(int i =0;i<n;i++){
//            presum[i+1] = presum[i]+A[i];
//        }
//        int[] mod = new int[K];
//        for(int p:presum){
//            mod[p%K]++;
//        }
//        for(int c:mod){
//            rst += (c*(c-1))/2;
//        }
//        return rst;
//    }
    public static void main(String[] args) {
        System.out.println((-2)%3);
        System.out.println(((-2)%3)+3);
        System.out.println((((-2)%3)+3)%3);
    }
}
