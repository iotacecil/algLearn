package ltc;

public class lt440 {
    int[][] memo;
    public int backPackIII(int[] A, int[] V, int m) {
        if(A==null||V==null||A.length<1||V.length<1)return 0;

        int n = A.length;
        memo = new int[n+1][m+1];
        return backrec(n-1,m,A,V);
    }

    private int backrec(int n,int w,int[] A,int[] V){
        if(memo[n][w]>0)return memo[n][w];
        if(w==0)return 0;
        if(n==0&&w<A[0])return 0;
        else if(n==0&&w>=A[0])return memo[n][w] = backrec(0,w-A[0],A,V)+V[0];
        else if(n>0){
            if(A[n]>w)return memo[n][w] = backrec(n-1,w,A,V);
            else return memo[n][w] = Math.max(backrec(n-1,w,A,V),backrec(n,w-A[n],A,V)+V[n]);
        }
        return 0;

    }

    /**
     * 奇偶性？
     *
     */
    public int backpackdp2(int[] A, int[] V, int m){
        //只需要计算dp[i+1]和dp[i]
        int[][] dp = new int[2][m+1];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j <=m ; j++) {
                if(j<A[i])
                dp[(i+1)&1][j]= dp[i&1][j];
                else
                    dp[(i+1)&1][j] = Math.max(dp[i&1][j],dp[(i+1)&1][j-A[i]]+V[i]);
            }
        }
        return dp[A.length&1][m];
    }

    public static void main(String[] args) {
        int n = 1;
        int w = 10;
        int[] A={1};
        int[] V ={1};
        lt440 sl = new lt440();
        System.out.println(sl.backpackdp2(A, V, w));
    }
}
