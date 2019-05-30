package leetcode;

public class lc546 {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp  = new int[101][101][101];
        return dfs(boxes, 0, n-1, 0, dp);
    }
    private int dfs(int[] boxes,int l,int r,int k,int[][][] dp){
        if(r<l)return 0;
        while (l<r && boxes[r-1] == boxes[r]){--r;++k;}
        if(dp[l][r][k] > 0)return dp[l][r][k];
        dp[l][r][k] = (1+k)*(1+k) + dfs(boxes, l, r-1, 0, dp);
        for (int i = l; i < r ; i++) {
            if(boxes[i] == boxes[r]){
                dp[l][r][k] = Math.max(dp[l][r][k], dfs(boxes,l,i,k+1,dp) +dfs(boxes,i+1,r-1,0,dp));
            }
        }
        return dp[l][r][k];
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 2, 2, 3, 4, 3, 1};
        lc546 sl = new lc546();
        System.out.println(sl.removeBoxes(arr));
    }
}
