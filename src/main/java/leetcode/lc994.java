package leetcode;

public class lc994 {
    public int orangesRotting(int[][] grid) {
        int cnt = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (true) {
            boolean cg = false;
            int[][] clone = new int[n][m];
            for(int i = 0;i<n;i++)
                for(int j = 0;j<m;j++)
                    clone[i][j] = grid[i][j];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (clone[i][j] == 2) {
                        for (int[] dir : dirs) {
                            if (i + dir[0] >= n || i + dir[0] < 0 || j + dir[1] >= m || j + dir[1] < 0) continue;
                            if (grid[i + dir[0]][j + dir[1]] == 1) {
                                cg = true;
                                grid[i + dir[0]][j + dir[1]] = 2;
                            }
                        }
                    }
                }
            }
           // System.out.println(Arrays.deepToString(grid));
            if (!cg) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (grid[i][j] == 1) return -1;
                    }
                }
                return cnt;

            }
            cnt++;

        }
    }

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        lc994 sl =new lc994();
        System.out.println(sl.orangesRotting(grid));
    }
}
