package leetcode;

import java.util.Arrays;

public class lc773 {
//    private boolean isEnd(int[][] board){
//        int cnt = 1;
//        for (int i = 0; i <board.length ; i++) {
//            for (int j = 0; j <board[0].length ; j++) {
//                if(i==board.length-1 && j == board[0].length-1){
//                    if(board[i][j] != 0)return false;
//                    break;
//                }
//                if(board[i][j] != i*(board[0].length)+j+1)return false;
//            }
//        }
//        return true;
//    }
//    public int slidingPuzzle(int[][] board) {
//        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
//        int step = 0;
//        Deque<int[]> que = new ArrayDeque<>();
//        int n = board.length;
//        int m = board[0].length;
//        Set<String> states = new HashSet<>();
////        boolean[][] marked = new boolean[n][m];
//
//        b:
//        for (int i = 0; i <n ; i++) {
//            for (int j = 0; j <m ; j++) {
//                if(board[i][j] == 0){
//                    que.add(new int[]{i,j});
//                    states.add(Arrays.deepToString(board));
////                    marked[i][j] = true;
//                    break b;
//                }
//            }
//        }
//
//        while (!que.isEmpty()){
//            int size = que.size();
//            while (size-->0){
//                int[] xy = que.poll();
//                for (int i = 0; i < dirs.length; i++) {
//                    int nx = xy[0]+dirs[i][0];
//                    int ny = xy[1]+dirs[i][1];
//                    if(nx<0||nx>=n||ny<0||ny>=m)continue;
//                    board[xy[0]][xy[1]] = board[nx][ny];
//                    board[nx][ny] = 0;
//                    System.out.println(nx+" "+ny);
//                    if(isEnd(board)){
//                        return step+1;
//                    }
//                    que.add(new int[]{nx,ny});
////                    marked[nx][ny] = true;
//                }
//            }
//            step++;
//        }
//
////        System.out.println(Arrays.deepToString(marked));
//        return -1;
//
//    }

    public static void main(String[] args) {
        int[][] board = {{4,1,2},{5,0,3}};
        lc773 sl = new lc773();
//        System.out.println(sl.slidingPuzzle(board));
        System.out.println(Arrays.deepToString(board));
        System.out.println(Arrays.deepToString(board).replaceAll("\\[|\\]|,|\\s", ""));
    }
}
