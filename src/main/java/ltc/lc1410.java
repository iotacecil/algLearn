package ltc;

public class lc1410 {
    // AC  86%
    public String waterInjection(int[][] matrix, int R, int C) {
        marked = new boolean[matrix.length][matrix[0].length];
        marked[R][C] = true;

        if (dfs(matrix, R, C, matrix[R][C])) return "YES";
        else return "NO";
    }

    boolean[][] marked;
    int[] xx = {-1, 0, 1, 0};
    int[] yy = {0, -1, 0, 1};

    private boolean dfs(int[][] mat, int x, int y, int last) {
        if (mat[x][y] <= last&&(x==0||x==mat.length-1||y==0||y==mat[0].length-1)) return true;

        for (int i = 0; i < 4; i++) {
            int nextx = x + xx[i];
            int nexty = y + yy[i];
            if (nextx >= 0 && nextx < mat.length && nexty >= 0 && nexty < mat[0].length&&mat[nextx][nexty]<=mat[x][y]) {
                marked[nextx][nexty] = true;
                if(dfs(mat, nextx, nexty, mat[x][y]))return true;
                marked[nextx][nexty] = false;

            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {10, 18, 13},
                {9, 8, 7},
                {1, 2, 3}};
        lc1410 sl = new lc1410();
        System.out.println(sl.waterInjection(mat, 1, 1));
    }
}
