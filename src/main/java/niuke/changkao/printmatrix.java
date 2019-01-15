package niuke.changkao;

public class printmatrix {

        public int[] clockwisePrint(int[][] mat, int n, int m) {
        int[] rst = new int[n*m];
        if(n == 0)return rst;
        boolean[][] seen = new boolean[n][m];
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

        int r = 0,c = 0,di = 0;
        for (int i = 0; i <n*m ; i++) {
            rst[i] = mat[r][c];
            seen[r][c] = true;
            int cr = r+dirs[di][0];
            int cc = c+dirs[di][1];
            if(0 <= cr && cr < n&&0 <= cc&&cc < m && !seen[cr][cc]){
                r = cr;
                c = cc;
            }else {
                di = (di+1)%4;
                r += dirs[di][0];
                c += dirs[di][1];
            }
        }
        return rst;
    }
}
