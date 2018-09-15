package gfg;

public class jumpGame {
    /** 超时
     *  reach the end of the array
     * @param arr
     * @return
     */
    public int minJumpRecur(int[] arr){
        int n = arr.length;
        memo = new int[n][n];
        return jump(arr, 0, n-1);
    }
    int[][] memo;
    private int jump(int[] steps,int from,int end){
//        System.out.println(from+" "+end);
        if(from==end)return 0;
        //不可达
        if(memo[from][end]!=0)return memo[from][end];
        if(steps[from]==0)return Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        //当前可以到达的范围是[from,from+step[from]]
        for(int i = from+1;i<=end&&i<=from+steps[from];i++){
            int jumps = jump(steps,i , end);
            if(jumps!=Integer.MAX_VALUE&&jumps+1<min){
                min = jumps+1;
                memo[from][end] = min;
            }
        }
        return min;
    }
    private int jumpdp(int[] nums){
        int n = nums.length;
        int[] dp =  new int[n];
        if(n == 0||nums[0] ==0)return 0;
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j <i ; j++) {
                if(i<=j+nums[j]&&dp[j]!= Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i],dp[j]+1);
                    break;
                }
            }
        }
        return dp[n-1];
    }
    public static void main(String[] args) {
        int[] steps = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
        int[] steps2 = {2,3,1,1,4};
        jumpGame sl = new jumpGame();
        System.out.println(sl.jumpdp(steps2));
    }
}
