package niuke;

/*
如果一个字符串S是由两个字符串T连接而成,即S = T + T, 我们就称S叫做平方串,例如"","aabaab","xxxx"都是平方串.
frankfurt
请你帮助牛牛从s中移除尽量少的字符,让剩下的字符串是一个平方串。

输入例子1:
frankfurt

输出例子1:
4
 */

import java.util.Scanner;

public class squarestr {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int n = str.length();
        if (n == 0 || n == 1) System.out.println(0);
        int max = 0;
        for (int i = 1; i <n-1 ; i++) {
            int len = LCS(str.substring(0, i),str.substring(i,n ));
            max = Math.max(max, len);
        }
        System.out.println(max*2);

    }
    // 最长公共子序列
    private static int LCS(String s,String t){
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
}
