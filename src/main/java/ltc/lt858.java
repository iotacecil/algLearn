package ltc;

import java.util.ArrayList;
import java.util.List;

public class lt858 {
    public int[][] candyCrush(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        while (true){
            List<int[]> del = new ArrayList<>();
            for (int i = 0; i <n ; i++) {
                for (int j = 0; j <m ; j++) {
                    if(board[i][j] == 0)continue;
                    // 只向上2格// 1 1 [0-2]
                    int x0 = i,x1 = i,y0 = j,y1 = j;
                    while (x0 >= 0 && x0 > i-3 && board[x0][j] == board[i][j]) --x0;
                    while (x1 < n && x0 < i+3 && board[x0][j] == board[i][j]) ++x1;
                    while (y0 >= 0 && y0 > j-3 && board[i][y0] == board[i][j]) --y0;
                    while (y1 < m && y1 < j+3 && board[i][y1] == board[i][j]) ++y1;
                    // 关键
                    if(x1 - x0 >3 || y1 - y0 > 3){
                        del.add(new int[]{i,j});
                    }
                }
            }
            if(del.size()==0)break;
            for(int[] p : del){
                board[p[0]][p[1]] = 0;
            }
            //下落 数组中的0都移动到开头
            for (int j = 0; j <m ; j++) {
                int cnt = n-1;
                for (int i = n-1; i >=0 ; i--) {
                    if(board[i][j] != 0){
                        board[cnt--][j] = board[i][j];
                    }
                }
                while (cnt>=0){
                    board[cnt--][j] = 0;
                }
            }

        }
        return board;
    }

    public static void main(String[] args) {

    }
}
