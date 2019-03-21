package leetcode;

import java.util.HashSet;
import java.util.Set;

public class lc36 {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j]!='.'){
                    String b = "("+board[i][j]+")";
                    //(4)7表示[7,4]  7(4) 表示[4,7] 第0个block是0(4)0
                    if(!set.add(b+i) || !set.add(j+b) || !set.add(i/3+b+j/3)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
