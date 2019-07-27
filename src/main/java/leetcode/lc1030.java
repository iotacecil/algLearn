package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc1030 {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] rst = new int[R * C][2];
        rst[0][0] = r0;
        rst[0][1] = c0;
        int step = 0;
        Deque<int[]> que = new ArrayDeque<>();
        que.add(new int[]{r0, c0});
        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        boolean[][] visited = new boolean[R][C];
        visited[r0][c0] = true;
        int idx = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            step++;
            while (size-- > 0) {
                int[] cur = que.poll();
                rst[idx][0] = cur[0];
                rst[idx][1] = cur[1];
                idx++;
                System.out.println(idx);
                for (int[] dir : dirs) {
                    int nx = cur[0] + dir[0];
                    int ny = cur[1] + dir[1];
                    if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny]) {
                        que.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }

            }
        }
        return rst;
    }

    public static void main(String[] args) {
        lc1030 sl = new lc1030();
        sl.allCellsDistOrder(2, 2, 0, 1);
    }
}
