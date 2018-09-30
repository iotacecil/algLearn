package courseBook.acmbook;

public class p51 {

    public int maxbag(int n,int w,int[][]wv){
        int[][] dp = new int[n+1][w+1];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <=w ; j++) {
                dp[i+1][j] = Math.max(dp[i+1][j],dp[i][j]);
                if(j+wv[i][0]<=w)
                    dp[i+1][j+wv[i][0]] = Math.max(dp[i+1][j+wv[i][0]],dp[i][j]+wv[i][1]);
            }
        }
        return dp[n][w];
    }

    public int frontDp(int n,int W,int[][] wv){
        int[][] dp = new int[n+1][W+1];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <=W ; j++) {
                if(wv[i][0]>j)
                    dp[i+1][j] = dp[i][j];
                else
                    dp[i+1][j] = Math.max(dp[i][j-wv[i][0]]+wv[i][1],dp[i][j]);
            }
        }
        return dp[n][W];
    }
    /**
     * 逆向dp
     * @param n
     * @param W
     * @param wv
     * @return
     */
    public int bagdp(int n,int W,int[][]wv){
        int[][] dp = new int[n+1][W+1];
        for (int i = n-1; i >=0 ; i--) {
            for (int j = 0; j <=W ; j++) {
                if(j<wv[i][0])
                    dp[i][j] = dp[i+1][j];
                else
                    dp[i][j] = Math.max(dp[i+1][j],dp[i+1][j-wv[i][0]]+wv[i][1]);
            }
        }
        return dp[0][W];
    }

    //另一种写法
    public int bagsum(int i,int n,int w,int[][]wv,int sum){
        int res;
        if(i == n)res = sum;
        else if(w<wv[i][0])
            res = bagsum(i+1,n,w ,wv ,sum );
        else{
            res = Math.max(bagsum(i+1,n , w,wv , sum),bagsum(i+1, n, w-wv[i][0],wv  ,sum+wv[i][1] ) );
        }
        return res;
    }

    int[][] dp;
    //参数组合一共nW种 只需要O(nW)复杂度
    public int bagmemo(int i,int n,int[][]wv,int w){
        dp = new int[n+1][w+1];
        return memo(i, n, wv, w);
    }
    public int memo(int i,int n,int[][]wv,int w){
        if(dp[i][w]>0)return dp[i][w];
        int res;
        if(i==n)return 0;
        else if(w<wv[i][0]){
            //不选这个
            res = bagrec(i+1,n,wv,w);
        }else{
            //选和不选
            res = Math.max(bagrec(i+1,n ,wv ,w ),bagrec(i+1, n,wv ,w-wv[i][0])+wv[i][1]);
        }
        dp[i][w] = res;
        return res;
    }
    //2^n复杂度
    public int bagrec(int i,int n,int[][]wv,int w){
        int res;
        if(i==n)return 0;
        else if(w<wv[i][0]){
            //不选这个
            res = bagrec(i+1,n,wv,w);
        }else{
            //选和不选
            res = Math.max(bagrec(i+1,n ,wv ,w ),bagrec(i+1, n,wv ,w-wv[i][0])+wv[i][1]);
        }
        return res;

    }

    public static void main(String[] args) {
        int n = 4;
        int[][] wv = new int[][]{{2,3},{1,2},{3,4},{2,2}};
        int W = 5;
        p51 sl = new p51();
        System.out.println(sl.maxbag(n, W, wv));
        System.out.println(sl.bagsum(0, n,W, wv,0));
    }
}
