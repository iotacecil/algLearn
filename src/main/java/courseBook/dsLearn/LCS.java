package courseBook.dsLearn;

import java.util.Arrays;

public class LCS {

    public int findLength(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        int max =0;
        int[][] dp = new int[n+1][m+1];
        for(int i =n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                max = Math.max(max,dp[i][j]=A[i]==B[j]?1+dp[i+1][j+1]:0);
            }
            System.out.println(Arrays.deepToString(dp));
        }
        return max;
    }
    public int findLengthFast(int[] a, int[] b) {
        int m = a.length, n = b.length;
        if (m == 0 || n == 0) return 0;
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        for (int i = m - 1; i >= 0; i--)
            for (int j = n - 1; j >= 0; j--)
                max = Math.max(max, dp[i][j] = a[i] == b[j] ? 1 + dp[i + 1][j + 1] : 0);
        return max;
    }
    public int longCstr(String a,String b){
        char[] str1 = a.toCharArray();
        char[] str2 = b.toCharArray();
        int max = 0;
        int[][] dp = new int[str1.length][str2.length];
        for(int i =0;i<str1.length;i++){
            for (int j = 0; j <str2.length ; j++) {
                if (str1[i] == str2[j]) {
                    if (i == 0 || j == 0){ dp[i][j] = 1;}
                    else {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                max = Math.max(max, dp[i][j]);
                }else
                    dp[i][j] = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LCS sl = new LCS();
        System.out.println(sl.longCstr("abab", "baba"));
        System.out.println(sl.findLength(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7}));
        System.out.println(sl.findLengthFast(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7}));
    }
}
