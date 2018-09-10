package leetcode;

public class lc413 {
    //at least three elements
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        int rst = 0;
        int cnt = 0;
        //当A[i]-A[i-1] == A[i-1]-A[i-2]时,dp[i] = dp[i-1]+1。
        for (int i = 2; i <n ; i++) {
            if(A[i]-A[i-1] == A[i-1]-A[i-2]){
                cnt++;
                rst += cnt;
            }else
                cnt = 0;
        }
        //sum = SUM(dp[0]...dp[i])
        return rst;
    }

}
