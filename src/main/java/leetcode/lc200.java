package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class lc200 {
    //union find模板
    class UnionFind{
        int [] parent;
        int m,n;
        int count = 0;
        UnionFind(char[][] grid){
            m = grid.length;
            n = grid[0].length;
            parent = new int[m*n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(grid[i][j] == '1'){
                        int id = i*n+j;
                        parent[id] = id;
                        count++;
                    }

                }
            }
//            System.out.println(Arrays.toString(parent));
//            System.out.println("初始化完成");
        }
        public void union(int node1,int node2){
            int find1 = find(node1);
            int find2 = find(node2);
            System.out.println("int union:"+node1+" "+node2);
            System.out.println("find1,find2:"+find1+" "+find2);
            if(find1 != find2){
                parent[find1] = find2;
                count--;
            }
        }
        public int find (int node){
            if(parent[node] == node)return node;
            parent[node] = find(parent[node]);
            return parent[node];
        }
    }
    int[][] distance = {{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid){
        //
        if(grid==null||grid.length<1||grid[0].length<1)
            return 0;
        UnionFind uf = new UnionFind(grid);
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <cols ; j++) {
                if(grid[i][j] == '1'){
                    for(int[] d :distance){
                        int x = i+d[0];
                        int y = j+d[1];
                        if(x>=0&&x<rows&&y>=0&&y<cols&&grid[x][y] == '1'){
                            int id1 = i*cols+j;
                            int id2 = x*cols+y;
                            uf.union(id1,id2);
                            System.out.println("count"+uf.count);
                            System.out.println(Arrays.toString(uf.parent));
                        }
                    }
                }

            }

        }
        return uf.count;
        }

    public int numIslandsBFS(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] marked = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!marked[i][j] && grid[i][j] == '1') {
                    count++;
                    bfs(grid,marked, i, j);

                }
            }
        }
        return count;
    }
    public void bfs(char[][] grid,boolean[][] marked,int x,int y){
        int[][] dxy = {{1,0},{-1,0},{0,1},{0,-1}};
        Deque<int[]> que = new ArrayDeque<>();
        que.push(new int[]{x,y});
        marked[x][y] = true;

        while (!que.isEmpty()){
            int[] xy = que.poll();
            for (int i = 0; i <4 ; i++) {
                int newx = xy[0] + dxy[i][0];
                int newy = xy[1] + dxy[i][1];



                if(newx < 0 || newx > marked.length || newy <0 || newy > marked[0].length){
                    continue;
                }

                if(!marked[newx][newy] && grid[newx][newy] == '1'){
                    que.add(new int[]{newx,newy});
                    marked[newx][newy] = true;

                }

            }
        }
    }

        public static void main(String[] args) {
        char[][] island = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'},

        };
        lc200 sl = new lc200();
        System.out.println(sl.numIslandsBFS(island));
    }
}
