package courseBook.acmbook;

public class p56 {
    public int lcs(String s,String t){
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                if(s.charAt(i)==t.charAt(j)){
                    dp[i+1][j+1] = dp[i][j]+1;
                }else
                    dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j]);
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        int n = 4;
        int m = 4;
        String s = "abcd";
        String t = "becd";
        p56 sl = new p56();
        System.out.println(sl.lcs(s, t));
    }
}
