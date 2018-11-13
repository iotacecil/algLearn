package niuke.wangyi;

import java.util.*;

/*


6 7
.......
X.X.X..
XXX...X
....X..
X....X.
.......
5 0
6
1 0
0 -1
-1 0
0 1
-2 3
1 0


 */
public class dilaotaotuo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] map = new char[n][m];

        for (int i = 0; i <n ; i++) {
            String row = sc.next();
            for (int j = 0; j <m ; j++) {
                map[i][j] = row.charAt(j);
                if(map[i][j] == '.' ){

                }
            }
        }
        int x0 = sc.nextInt();
        int y0 = sc.nextInt();
        int stepn = sc.nextInt();
        int[][] steps = new int[stepn][2];
        for (int i = 0; i <stepn ; i++) {
            steps[i][0] = sc.nextInt();
            steps[i][1] = sc.nextInt();
        }


        System.out.println(howstep(n, m, x0, y0, map, steps));

    }
    //地牢的出口可能在任意某个可以通行的位置上。牛牛想知道最坏情况下，他需要多少步才可以离开这个地牢。

    public static int howstep(int n,int m ,int x0,int y0,char[][] map,int[][] steps){
        boolean[][] marked = new boolean[n][m];
        int[][] stepmap = new int[n][m];
        marked[x0][y0] = true;
        Deque<int[]> que= new ArrayDeque<>();
        que.add(new int[]{x0,y0});
        int layer = 0;
        while (!que.isEmpty()){
            int layerSize = que.size();
            for (int i = 0; i <layerSize ; i++) {
                int[] top = que.poll();
                for(int[] step : steps){
                    int nx = top[0] + step[0];
                    int ny = top[1] + step[1];
                    if(nx>=n || nx<0 || ny >=m || ny <0 ||map[nx][ny] !='.' || marked[nx][ny]){
                        continue;
                    }
                    stepmap[nx][ny] = layer+1;
//                    if(nx == ex && ny == ey){
//                        return layer+1;
//                    }
                    que.add(new int[]{nx,ny});
                    marked[nx][ny] = true;
                }
            }
            layer++;
        }
//        System.out.println(Arrays.deepToString(stepmap));
        int ans = -1;
//        System.out.println(n+" "+m);
        for (int i = n-1; i >=0; i--) {
            for (int j = m-1; j >=0 ; j--) {
              if(i==x0&&j==y0)continue;
                if( map[i][j]=='.' ){


                    if(stepmap[i][j] == 0)return -1;
                    ans = Math.max(ans, stepmap[i][j]);
                }

            }

        }
        return ans;
    }
}
