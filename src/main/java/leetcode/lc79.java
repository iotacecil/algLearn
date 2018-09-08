package leetcode;

import java.util.Arrays;

public class lc79 {
//    boolean[][] marked;
    public boolean exist(char[][] board, String word) {
        int n  = board.length;
        int m = board[0].length;
//        marked = new boolean[n][m];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                if(word.charAt(0)!=board[i][j])continue;
                if(dfs(board,0,i,j,word))return true;

            }

        }
        return false;
    }

    private boolean dfs(char[][] board,int idx,int i,int j,String word){
        if(i>board.length-1||i<0||j>board[0].length-1||j<0||word.charAt(idx)!=board[i][j])return false;

        if(idx==word.length()-1)return true;
        char tmp = board[i][j];
//        marked[i][j] = true;
    board[i][j]='0';

        boolean ans = dfs(board,idx+1,i+1,j,word)||
                dfs(board,idx+1,i,j+1,word)||dfs(board,idx+1,i-1,j,word)
                ||dfs(board,idx+1,i,j-1,word);
//        marked[i][j]=false;
        board[i][j]=tmp;
        return ans;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
                };
        String word = "ABCCED";
        lc79 sl = new lc79();
//        System.out.println(sl.exist(board, word));
        System.out.println(sl.exist(board, "SEE"));
        System.out.println(sl.exist(board, "ABCB"));
    }

}
