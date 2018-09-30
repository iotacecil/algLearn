package courseBook.acmbook;

public class p57 {
    public int completeBagDP2(int n,int W,int[][] wv){
        int[][] dp = new int[n+1][W+1];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <=W ; j++) {
                if(wv[i][0]>j)
                dp[i+1][j] = dp[i][j];
                else
                    // 01背包的递推
                    // dp[i+1][j] = Math.max(dp[i][j],dp[i][j-wv[i][0]]+wv[i][1]);
                    dp[i+1][j] = Math.max(dp[i][j],dp[i+1][j-wv[i][0]]+wv[i][1]);
            }
        }
        return dp[n][W];
    }
    /*
    有重复计算
     */
    public int completeBagDP(int n,int W,int[][] wv){
        //dp[i+1][j]从前i种物品中总重<=j的最大值
        int[][] dp = new int[n+1][W+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <=W ; j++) {
                for (int k = 0; k*wv[i][0] <=j ; k++) {
                    dp[i+1][j] = Math.max(dp[i+1][j],dp[i][j-k*wv[i][0]]+k*wv[i][1]);
                }
            }
        }
        return dp[n][W];
    }

//    public int compbagRe(int i,int n,int W,int[]wv){
//        if(i==n)return compbagRe();
//    }
    /**
     * 有问题的递归
     * @param n
     * @param W
     * @param wv
     * @return
     */
    public  int completebag(int n,int W,int[][] wv){
        if(n==0||W==0)return 0;

        if(wv[n][0]>W) return completebag(n-1, W,wv );
        else return Math.max(completebag(n-1,W ,wv ), completebag(n, W-wv[n][0],wv )+wv[n][1]);

    }
    public static void main(String[] args) {
        int n = 3;
        int[][] wv = new int[][]{{3,4},{4,5},{2,3}};
        int n01 = 4;
        int[][] wv01 = new int[][]{{2,3},{1,2},{3,4},{2,2}};
        int W01 = 5;
        int[][] wa = new int[][]{{2,1},{3,5},{5,2},{7,4}};
        int waW = 10;

        int W = 7;
        p57 sl = new p57();
        System.out.println(sl.completebag(n-1, W, wv));
        System.out.println(sl.completebag(3, waW, wa));
        System.out.println(sl.completeBagDP(n, W, wv));
        System.out.println(sl.completeBagDP2(n, W, wv));
        System.out.println(sl.completeBagDP2(n01, W01, wv01));
    }
}
