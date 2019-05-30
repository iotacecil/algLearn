package leetcode;

public class lc778 {
    int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
    boolean dfs(int[][] grid,boolean[][] visited,int max,int x,int y){
        visited[x][y] = true;
        for(int[] dir:dirs){
            int nx = x+dir[0];
            int ny = y+dir[1];

            if(nx>=0&&nx<grid.length&&ny>=0&&ny<grid[0].length && !visited[nx][ny]&& max>= grid[nx][ny]){
                if(max == 14){
                    System.out.println(nx+" "+ny);
                }
                if(nx ==grid.length-1 && ny==grid[0].length-1)return true;
                else
                // visited[nx][ny]  = true;
                if(dfs(grid,visited,max,nx,ny))return true;
            }
        }
        return false;

    }
    public int swimInWater(int[][] grid) {
        int max = 0;
        for(int[] row :grid){
            for(int i:row){
                max = Math.max(max,i);
            }
        }


        int l = grid[0][0];
        int h = max;
        //[l,h]
        while(l<h){
            int mid = l+(h-l)/2;
        if(mid==14){
            System.out.println(dfs(grid, new boolean[grid.length][grid[0].length], mid, 0, 0));
        }
            if(!dfs(grid,new boolean[grid.length][grid[0].length],mid,0,0)){
                l = mid+1;
            }else{

                h = mid;
            }
            System.out.println(h+" "+mid);
        }
        return h;


    }

    public static void main(String[] args) {

       int[][] water = new int[][] {{7,8,10,13},{2,4,15,11},{12,1,5,6},{9,3,0,14}};
       lc778 sl = new lc778();
        System.out.println(sl.swimInWater(water));
    }
}
