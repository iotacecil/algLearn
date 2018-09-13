package leetcode;

public class lc289 {
    /**
     如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
     如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
     lives ==3||lives==4&&cell==1
     如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
     如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
     * 生命游戏
     * @param board
     */
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = m>0?board[0].length:board.length;
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j < n; j++) {
                int livecnt = 0;
                //扫描(i,j)周围[i-1,i+1] [j-1,j+1]的3x3的区间
                for(int y = Math.max(0,i-1);y<Math.min(m,i+2);y++){
                    for(int x = Math.max(0,j-1);x<Math.min(n,j+2);x++){
                        livecnt+=board[y][x]&1;
                    }
                }
                //第二位置1
                if(livecnt == 3||livecnt-board[i][j]==3)board[i][j] |=0b10;

            }
            
        }
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j]>>=1;
            }

        }
    }
}
