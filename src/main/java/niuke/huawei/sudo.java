package niuke.huawei;

import java.util.HashSet;
import java.util.Set;

/*
9*9
1-9 每行每列每个数字出现一次
3*3里面只出现1次
 */
public class sudo {
    public static void main(String[] args) {
        sudo sl = new sudo();
        char[][] board =
                {
                        {'.','.','4','.','.','.','6','3','.'},
                        {'.','.','.','.','.','.','.','.','.'},
                        {'5','.','.','.','.','.','.','9','.'},
                        {'.','.','.','5','6','.','.','.','.'},
                        {'4','.','3','.','.','.','.','.','1'},
                        {'.','.','.','7','.','.','.','.','.'},
                        {'.','.','.','5','.','.','.','.','.'},
                        {'.','.','.','.','.','.','.','.','.'},
                        {'.','.','.','.','.','.','.','.','.'}};
        System.out.println(sl.isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> line = new HashSet<>();
            Set<Character> col = new HashSet<>();
            // [0][0]  [1][0]...[n-1][0]
            for (int j = 0; j < 9; j++) {

                if (line.contains(board[i][j])) {
//                    System.out.println("row" + (i) + ' ' + (j));
//                    System.out.println(line);
                    return false;
                }
                if (board[i][j] != '.')
                line.add(board[i][j]);

                if (col.contains(board[j][i])) {
//                    System.out.println("col" + (j) + ' ' + (i));
//                    System.out.println(col);
                    return false;
                }
                if (board[j][i] != '.')

                    col.add(board[j][i]);
            }
//            System.out.println(col);

        }
        int[][] sxy = {
                {0, 0}, {0, 3}, {0, 6},
                {3, 0}, {3, 3}, {3, 6},
                {6, 0}, {6, 3}, {6, 6}};
        for (int i = 0; i < 9; i++) {
            Set<Character> block = new HashSet<>();
            int[] start = sxy[i];
            int x = sxy[i][0];
            int y = sxy[i][1];
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (board[x + j][y + k]== '.') continue;

                    if (block.contains(board[x + j][y + k])) {
//                        System.out.println("block"+(x + j) + ' ' + (y + k));
//                        System.out.println(block);
                        return false;
                    }
                    block.add(board[x + j][y + k]);
                }
            }
//            System.out.println(block);
        }
        return true;


    }


}
