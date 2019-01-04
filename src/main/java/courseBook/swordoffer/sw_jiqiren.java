package courseBook.swordoffer;

import java.util.ArrayDeque;
import java.util.Queue;

public class sw_jiqiren {
    private boolean bitsumlower(int th, int a, int b) {
        int sum = 0;
        while (a != 0) {
            sum += a % 10;
            a = a / 10;
            if (sum > th) return false;
        }
        while (b != 0) {
            sum += b % 10;
            b = b / 10;
            if (sum > th) return false;
        }
        System.out.println(sum);
        return true;
    }


    public int movingCount(int threshold, int rows, int cols)
    {
        if(threshold < 0)return 0;
        int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{0,0});

        boolean[][] marked = new boolean[rows][cols];
        marked[0][0] = true;
        int cnt = 1;
        while (!que.isEmpty()){
            int[] cur = que.poll();

            for (int i = 0; i <dirs.length ; i++) {
                int nx = cur[0] + dirs[i][0];
                int ny = cur[1] + dirs[i][1];
                if(nx < 0 ||nx >=rows || ny <0 ||ny >=cols ||marked[nx][ny]||!bitsumlower(threshold, nx, ny))continue;
                cnt++;
                que.add(new int[]{nx,ny});
                marked[nx][ny] = true;
            }

        }
        return cnt;
    }

    public static void main(String[] args) {
        sw_jiqiren sl = new sw_jiqiren();
        System.out.println(sl.movingCount(-10, 10, 10));
    }
}
