package niuke;

public class yanmo {
    public int yanmo (int[][] land,int water){
        int count = 0;
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if(land[i][j]>water){
                    dfs(land,water,i,j);
                    ++count;
                }

            }

        }
        return count;
    }
    private void dfs(int[][] land,int water,int x,int y){
        if(x<0||x>land.length-1||y<0|y>=land[0].length-1||land[x][y]<=water){
            return ;
        }
        land[x][y] = -1;
        int cnt =0;
        dfs(land,water,x-1,y);
        dfs(land,water,x+1,y);
        dfs(land,water,x,y+1);
        dfs(land,water,x,y-1);


    }
    public static void main(String[] args) {
        int water = 3;
        int[][] land = {
                {3,3,3},
                {4,3,3},
                {4,3,4}};
        yanmo sl = new yanmo();
        System.out.println(sl.yanmo(land, water));

    }
}
