package leetcode;

import java.util.Arrays;

abstract class c12 {
    int a;

}

interface c123 {
    int a = 0;

}

public class lc10 implements c123 {
    public boolean isMatch2(String s, String p) {

        int n1 = s.length();
        int n2 = p.length();
        boolean[][] dp = new boolean[n1 + 1][n2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(i - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    //aaa   ac
                    //aaa*  ab*c
                    /*
                     t c * a * b
                     a     t
                     a
                     b

                    */
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i - 1][j - 2];
                    }
                }
                //1 p = 1 pp = 1
                //
                System.out.println(Arrays.deepToString(dp));
            }
        }
        return dp[n1][n2];

    }

    public boolean isMatch(String s, String p) {
        if(s==null||p==null)return false;
        int slen = s.length();
        int plen = p.length();
        //取i,j长度匹配
        boolean [][] dp  = new boolean[slen+1][plen+1];
        dp[0][0]=true;
        int j =1;
        int i=1;
        //a-. ->
        //
        while(i<slen){

            if(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j)=='.'){

                dp[i][j++]=dp[i-1][j-1];

            } else if(j>0&&p.charAt(j-1)=='*'){
                char last=p.charAt(j-2);
                while(i<=plen&&s.charAt(i-1)==last||p.charAt(i-1)=='.'){
                    dp[i++][j]=dp[i][j-2];

                }
                j++;

            }
        }
        if(i>slen&&j<plen)return false;
        return  dp[slen][plen];


    }

    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
        lc10 sl = new lc10();
        System.out.println(sl.isMatch2(s, p));
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
