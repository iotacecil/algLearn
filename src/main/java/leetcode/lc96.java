package leetcode;

import sun.java2d.SurfaceDataProxy;

public class lc96 {
    //dfs

    public int numTreesDfs(int n) {
        int[] memory = new int[n+1];
        return dfs(n,memory);
    }
    public int dfs(int n,int[] memroy){
        if(n==0||n==1)return 1;
        if(memroy[n-1]!=0)return memroy[n-1];
        int sum = 0;
        for (int i = 1; i <=n ; i++) {
            sum+=dfs(i-1,memroy)*dfs(n-i,memroy);
        }
        memroy[n-1] = sum;
        return sum;
    }

    //n^2
    public int numTrees(int n){
        int[] dp = new int[n+1];
        dp[0] = 1   ;
        dp[1] =1;
        for (int i = 2; i <=n ; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j]*dp[i-j-1];
            }

        }
        return dp[n];
    }
    //复杂度n^2
    public int catalan(int n){
        if(n<=1)return 1;
        int res = 0;
        for (int i =0;i<n;i++){

            res+=catalan(i)*catalan(n-1-i);}
        return res;
    }

    private int C(int a,int b){
        long res = 1;
        for(int i =0;i<Math.min(b,a-b);i++){
            res=res*(a-i)/(i+1);
        }
        return (int)res;
    }
    //C(2n,n)/(n+1)
    public int catalen2(int n){
        int c =C(2*n,n);
        return c/(n+1);
    }

    public static void main(String[] args) {
        lc96 sl = new lc96();
        System.out.println(sl.numTrees(5));
        System.out.println(sl.catalen2(3));
        System.out.println(sl.numTreesDfs(3));
    }
}
