package ltc;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class lt663 {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        int[][] grid = {{2147483647, -1, 0, 2147483647},{2147483647, 2147483647, 2147483647, -1},{
        2147483647, -1, 2147483647, -1},{0, -1, 2147483647, 2147483647}};

        lt663 sl = new lt663();
        sl.wallsAndGatesDFS(grid);

        System.out.println(Arrays.deepToString(grid));
    }


//    private void dfs(int[][] rooms, int i, int j, int d){
//        int n = rooms.length,m = rooms[0].length;
//        if(i<0 ||i>=n||j<0||j>=m||rooms[i][j]==-1) return;
//        if(rooms[i][j] > d || d == 0){
//            rooms[i][j]=d;
//            int[] dx = {0,0,-1,1};
//            int[] dy = {-1,1,0,0};
//            for(int k=0;k<4;k++){
//                int x= i+dx[k], y = j +dy[k];
//                dfs(rooms, x, y, d+1);
//            }
//        }
//    }
//    public void wallsAndGatesDFS(int[][] rooms) {
//        int n = rooms.length;   if(n==0) return;
//        int m = rooms[0].length;    if(m==0) return;
//        for(int i = 0 ; i< n;i++){
//            for(int j = 0 ; j< m;j++){
//                if(rooms[i][j]==0)
//                    dfs(rooms, i,j,0);
//            }
//        }
//    }
    public void wallsAndGatesDFS(int[][] rooms) {
        int n = rooms.length;
        int m = rooms[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms,i,j,0);
                }
            }
        }

    }

    /**
     * -1 - 墙壁或障碍物。
        0 - 门。

     */
    private void dfs(int[][] rooms,int i,int j,int d){
        int n = rooms.length,m = rooms[0].length;
        if(i <0 ||i >=n ||j <0 || j >=m  || rooms[i][j] == -1)return;
        // 可以更新
        if(rooms[i][j] > d || d == 0){
            rooms[i][j] = d;
            for (int k = 0; k <dirs.length ; k++) {
                dfs(rooms,i+dirs[k][0],j+dirs[k][1],d+1);
            }
        }

    }


        public void wallsAndGates(int[][] rooms) {
        int n = rooms.length;
        int m = rooms[0].length;
        Queue<int[]> que = new ArrayDeque<>();


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rooms[i][j] == 0) {
                    que.add(new int[]{i, j});
                }
            }
        }

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int curx = cur[0];
            int cury = cur[1];

            for (int i = 0; i < dirs.length; i++) {
                int newx = curx + dirs[i][0];
                int newy = cury + dirs[i][1];
                if (newx < 0 || newx >= n || newy < 0 || newy >= m
                        || rooms[newx][newy] == -1 || rooms[newx][newy] < rooms[curx][cury] + 1) {
                    continue;
                }
                rooms[newx][newy] = rooms[curx][cury] + 1;
                que.add(new int[]{newx,newy});
            }
        }
    }
//    private int bfs(int[][] rooms,int x,int y){
//        int n = rooms.length;
//        int m = rooms[0].length;
//        int[][] marked = new int[n][m];
//        Queue<int[]> que = new ArrayDeque<>();
//        que.add(new int[]{x,y});
//
//        while (!que.isEmpty()){
//
//        }
//    }
}
