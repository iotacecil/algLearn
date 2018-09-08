package gfg;

public class knapasack {
//    private void back(int idx,int cv,int cw){
//        if(i>=n)
//    }
    private void storeResult(int W,int[] val,int[] wt,int n){
        int[][] dp = new int[n+1][W+1];
        int i,w;
        for (i = 0; i <=n ; i++) {
            for ( w = 0; w <=W ; w++) {
                if(i ==0||w==0)dp[i][w] = 0;
                else if(wt[i-1]<=w)
                    dp[i][w]=Math.max(val[i-1]+dp[i-1][w-wt[i-1]],dp[i-1][w]);
                else
                    dp[i][w] = dp[i-1][w];
            }
        }
       int res = dp[n][W];
        System.out.println(res);
        w = W;
        for (i = n;  i>0&&res>0 ; i--) {
            if(res ==dp[i-1][w])continue;
            else{
                System.out.println(wt[i-1]+" ");
                res-= val[i-1];
                w-= wt[i-1];
            }
        }
    }
//    private int back(int W,int curval,int[] val,int[] wt,int idx,int n){
//
//        for (int i = 0; i < ; i++) {
//            W-=wt[idx];
//            curval+=val[idx];
//            back(W,curval,val,wt,idx+1,n);
//            curval-=val[idx];
//            W+=wt[idx];
//        }
//
//
//    }

    private int zoknap(int W,int[] val,int[] wt,int n){
        if(n == 0||W == 0){
            return 0;
        }
        //这个物品超重了
        if(wt[n-1]>W)return zoknap(W, val, wt,n-1 );
        else return Math.max(val[n-1]+zoknap(W-wt[n-1],val ,wt ,n-1 ),zoknap(W,val ,wt ,n-1) );
    }

    private int zoknapdp(int W,int[] wt,int[] val,int n){
        int[][] dp = new int[n+1][W+1];
        for (int i = 0; i <=n ; i++) {
            for (int w = 0; w <=W ; w++) {
                if(i ==0||w==0)dp[i][w] = 0;
                else if(wt[i-1]<=w)
                    dp[i][w]=Math.max(val[i-1]+dp[i-1][w-wt[i-1]],dp[i-1][w]);
                else
                    dp[i][w] = dp[i-1][w];
            }
        }
        return dp[n][W];
    }

    private int zoknapdp1d(int W,int[] wt,int[] val,int n){

        int[] dp = new int [W+1];
        for (int i = 0; i <n ; i++) {
            for (int j = W; j >=wt[i] ; j--) {
                dp[j] = Math.max(dp[j],dp[j-wt[i]]+val[i]);
            }
        }
        return dp[W];
    }
    public static void main(String[] args) {
        int[] val = new int[]{60,100,120};
        int[] wt = new int[]{10,20,30};
        int W = 50;
        int n = val.length;
        knapasack sl = new knapasack();
        System.out.println(sl.zoknap(W,val ,wt ,n ));
        System.out.println(sl.zoknapdp(W,wt ,val,n ));
        System.out.println(sl.zoknapdp1d(W,wt ,val,n ));
       sl.storeResult(W,val ,wt,n);


    }
}
