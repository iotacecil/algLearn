package ltc;

import java.util.LinkedList;
import java.util.Queue;

public class ltc803 {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int shortestDistance(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] res = new int[n][m][2];
        // 城市的数量
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    count++;
                    bfs(grid, i, j, res);
                }
//                System.out.println();
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                if(res[i][j][1] == count)
                    min = Math.min(min, res[i][j][0]);
        return min;
    }

    void bfs(int[][] grid, int i, int j, int[][][] res) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        boolean[][] v = new boolean[n][m];

        int step = 1;
        while(!q.isEmpty()) {
            int size = q.size();
           while (size-- > 0){
                int[] cur = q.poll();
                for(int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    // 四个方向继续找空地
                    if(x < 0 || x >= n || y < 0 || y >= m || grid[x][y] != 0 || v[x][y]) continue;
                    q.offer(new int[]{x, y});
                    res[x][y][0] += step;
                    res[x][y][1] += 1;
                    v[x][y] = true;
                }
            }
//            System.out.println(Arrays.deepToString(res));
            step++;
        }
    }

    public static void main(String[] args) {
        int[][] grid =
                {{1,2,1},
                {0,0,0},
                {0,1,0}};
        ltc803 sl = new ltc803();
        System.out.println(sl.shortestDistance(grid));
    }

}
