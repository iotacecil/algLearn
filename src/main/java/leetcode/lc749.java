package leetcode;

public class lc749 {
//    private int findbigreturnwall(int[][]grid){
//        int n = grid.length;
//        int m = grid[0].length;
//        for (int i = 0; i <n ; i++) {
//            for (int j = 0; j < m; j++) {
//                if(grid[i][j] == 1){
//
//                }
//
//            }
//
//        }
//
//        return 0;
//    }
    int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
    private void simulate(int[][]grid){
        int n = grid.length;
        int m = grid[0].length;
        int dayup = 0;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 1){
                    for (int k = 0; k < dirs.length; k++) {
                        int nx = i + dirs[k][0];
                        int ny = j + dirs[k][1];
                        if(ny <0 ||nx <0 ||ny >=m ||nx >=n ||
                                grid[nx][ny] == -1||grid[nx][ny] == 1){
                            continue;
                        }
                        grid[nx][ny] = 1;
                        dayup++;
                    }
                }

            }

        }
    }

    public int containVirus(int[][] grid) {
        return 1;
    }
}
