package gfg;

public class unboundedKp {
    // we use 1D array here which is different from classical knapsack where we used 2D array.
    // Here number of items never changes. We always have all items available.
    private int multicnt(int W,int n,int[] val,int[] wt){
        int dp[] = new int[W+1];
        for (int i = 0; i <=W ; i++) {
            for (int j = 0; j < n ; j++) {
                if(wt[j]<=i){
                    dp[i] = Math.max(dp[i],dp[i-wt[j]]+val[j] );
                }

            }
        }
        return dp[W];
    }
    public static void main(String[] args) {
        int W = 100;
        int[] val = {10,30,20};
        int[] wt = {5,10,15};
        int n = val.length;
        unboundedKp sl = new unboundedKp();
        System.out.println(sl.multicnt(W, n, val, wt));
    }
}
