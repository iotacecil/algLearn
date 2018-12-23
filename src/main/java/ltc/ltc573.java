package ltc;

import java.util.ArrayDeque;
import java.util.Queue;

public class ltc573 {
    public int shortestDistance(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        int[][][] res = new int[n][m][2];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 1){
                    cnt ++;
                    bfs(grid,i,j,res);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i =0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(res[i][j][1] == cnt)
                    min = Math.min(min,res[i][j][0]);
            }
        }
        return min == Integer.MAX_VALUE? -1:min;
    }

    int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
    private void bfs(int[][] grid,int cx,int cy,int[][][] res){
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        visited[cx][cy] = true;
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{cx,cy});
        int step = 0;
        while(!que.isEmpty()){
            int size = que.size();
            while(size-- >0){
                int[] cur = que.poll();
                int x = cur[0];
                int y = cur[1];
                for(int i =0;i<dirs.length;i++){
                    int nx = x + dirs[i][0];
                    int ny = y + dirs[i][1];
                    if(nx >=0 || ny >=0 || ny<m||nx <n || grid[nx][ny] == 0 || visited[nx][ny]){
                        res[nx][ny][0] += (step+1);
                        res[nx][ny][1] += 1;
                        que.add(new int[]{nx,ny});
                        visited[nx][ny] = true;
                    }
                }

            }
            step ++;
        }
    }
}
