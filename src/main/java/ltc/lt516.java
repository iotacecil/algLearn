package ltc;

public class lt516 {

    public int minCostII(int[][] costs) {
        if(costs == null || costs.length <1)return 0;
       int n = costs.length;
       int m = costs[0].length;
       dp = new int[n][m+1];
//        for (int i = 0; i <n ; i++) {
//            for (int j = 0; j <m ; j++) {
//
//                dp[i][j] = Math.min(costs[i][j] + dp[i][j], )
//
//            }
//
//        }

        return dfs(costs, 0, -1);

    }
    int[][] dp;
    private int dfs(int[][] costs,int idx,int chose){
        if(idx == costs.length)return 0;
        if( dp[idx][chose+1]!=0)return dp[idx][chose+1];
        int rst = Integer.MAX_VALUE;
        for (int i = 0; i <costs[0].length ; i++) {
            if(chose==-1 || chose != i)
            rst = Math.min(rst,costs[idx][i] + dfs(costs, idx+1,i));

        }
        dp[idx][chose+1] = rst;
        return rst;
    }

    public static void main(String[] args) {
        lt516 sl = new lt516();
        int[][] costs = {{14,2,11},{11,14,5},{14,3,10}};
        System.out.println(sl.minCostII(costs));
    }
}
