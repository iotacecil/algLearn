package leetcode;

import java.util.PriorityQueue;

public class lc407 {
    class state{
        int x;
        int y;
        int val;

        public state(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    public int trapRainWater(int[][] water) {

        int n = water.length;
        if(n<1)return 0;
        int m = water[0].length;
        PriorityQueue<state> que = new PriorityQueue<>((a,b)->a.val-b.val);
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i <n ; i++) {
            que.add(new state(i,0,water[i][0]));
            que.add(new state(i,m-1,water[i][m-1]));
            visited[i][0] = true;
            visited[i][m-1] = true;
        }
        for (int i = 1; i <m-1 ; i++) {
            que.add(new state(0,i,water[0][i]));
            que.add(new state(n-1,i,water[n-1][i]));
            visited[0][i] = true;
            visited[n-1][i] = true;
        }
        int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
        int rst = 0;
        int max = 0;
        while (!que.isEmpty()){
            state top = que.poll();

            for(int[] dir:dirs){
                int nx = top.x + dir[0];
                int ny = top.y + dir[1];
                if(nx<n&&nx>=0&&ny<m&&ny>=0&&!visited[nx][ny]){
                    System.out.println(water[nx][ny] + " " + top.val);

                    if(water[nx][ny] < top.val){
                        rst += top.val - water[nx][ny] ;
                    }
                    visited[nx][ny] = true;
                    que.add(new state(nx,ny,Math.max(water[nx][ny],top.val)));
                }
            }

        }
        return rst;


    }
    public static void main(String[] args) {
        int[][] water = {
  {1,4,3,1,3,2},
  {3,2,1,3,2,4},
  {2,3,3,2,3,1}
};
        lc407 sl = new lc407();
        System.out.println(sl.trapRainWater(water));
    }
}
