package leetcode;

public class lc1105 {
    public int minHeightShelves(int[][] books, int shelf_width) {
        int n = books.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int w = books[i - 1][0];
            int h = books[i - 1][1];
            // 放下一层
            dp[i] = dp[i - 1] + h;
            for (int j = i - 1; j > 0; j--) {
                w += books[j - 1][0];
                h = Math.max(h, books[j - 1][1]);
                if (w > shelf_width) break;
                dp[i] = Math.min(dp[i], dp[j - 1] + h);
            }

        }
        return dp[n];
    }
}
