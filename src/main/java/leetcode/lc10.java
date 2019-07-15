package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class lc10 {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                    dp[i][j] = true;
                } else if (p.charAt(j - 1) == '*') {

                    //aa a*
                    if (j >= 2 && (dp[i - 1][j - 1] || dp[i - 1][j]) && (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.'))
                        dp[i][j] = true;
                    if (j >= 2 && dp[i - 1][j - 2])
                        dp[i - 1][j] = true;
                    if (j >= 2 && dp[i][j - 2])
                        dp[i][j] = true;
                    if (j >= 2 && dp[i][j - 1])
                        dp[i][j] = true;
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n][m];
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        lc10 sl = new lc10();


        // [1][3]=[1][1]
        System.out.println(sl.isMatch("a",
                "ab*"));
//        String s = "/a/./b/../../c/";
//        System.out.println(Arrays.toString(s.split("/")));
//        System.out.println(s.replace("/", ""));
//        String s = "aab";
//        String p = "c*a*b";
//        lc10 sl = new lc10();
//        System.out.println(sl.isMatch2(s, p));
//        System.out.println(s.matches());
//            boolean dp [][] = new boolean[3][3];
//            System.out.println(Arrays.toString(dp));
//            int []test = new int[2];
//            int two = 1;
////        test[two++]=1;
//        dp[0][0]=true;
//        int one = 1;
//        dp[one][two]=dp[one-1][two-1];
//        System.out.println('a'^'a');
//        //ENUM 可以用{}初始化都是object
//
//        //1,1 = 0,0
//        System.out.println(Arrays.toString(dp[1]));
//        System.out.println(Arrays.toString(test));
    }


}
