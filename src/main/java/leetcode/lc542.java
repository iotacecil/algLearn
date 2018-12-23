package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class lc542 {




    public static void main(String[] args) {
        int[][] matrix =
        {{1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
        {0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
        {0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
        {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
        {0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
        {0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
        {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
        {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}};
        lc542 sl = new lc542();
        sl.updateMatrixDFS(matrix);
    }
    int[][] ori = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};


    public int[][] updateMatrixDFS(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] !=0 )matrix[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    dfs(matrix,i,j,0);
                }
            }
        }
        return matrix;


    }

    private void dfs(int[][] matrix,int x,int y,int d){
        int n = matrix.length;
        int m = matrix[0].length;
        if(matrix[x][y] > d || d == 0){
            matrix[x][y] = d;
            for(int i = 0;i < ori.length;i++){
                int nx = x + ori[i][0];
                int ny = y + ori[i][1];
                if(nx <0 || nx >= n || ny <0 ||ny >= m)continue;
                dfs(matrix,nx,ny,d+1);
            }
        }
    }

    public int[][] updateMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
//                    System.out.println(find(matrix, i, j));
                    matrix[i][j] = find(matrix, i, j);
                }
            }
        }
        return matrix;
    }

    private int find(int[][] matrix, int x, int y) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] marked = new boolean[n][m];
        marked[x][y] = true;

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x, y});
        int step = 0;

        while (!que.isEmpty()) {
            int size = que.size();
            while (size > 0) {
                int[] top = que.poll();
                size --;
                int curx = top[0];
                int cury = top[1];

                for (int i = 0; i < ori.length; i++) {
                    int newx = curx + ori[i][0];
                    int newy = cury + ori[i][1];

                    if (newx < 0 || newx >= n || newy < 0 || newy >= m || marked[newx][newy]
                            )
                        continue;


                    if (matrix[newx][newy] == 0) {
                        return step + 1;
                    }

                    que.add(new int[]{newx, newy});
                    marked[newx][newy] = true;
                }
            }
            step++;
        }
        return -1;
    }

    private void print2d(int[][] matrix){
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[0].length ; j++) {
                System.out.print(matrix[i][j] +" ");
            }
            System.out.println();
        }
    }

}
