package niuke.wangyi;

import java.util.Scanner;

public class 交错012018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = str.length();

        int max = 1;
        int len = 1;
        //101 //i=0 j = 2
        for (int i = 1; i < n; i++) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                len++;
                max = Math.max(max, len);
            } else {
                len = 1;
            }


        }
//        while (s<n&&e<n){
//            while (e<n&&str.charAt(e)!=str.charAt(e-1))e++;
//            max = Math.max(max,e-s);
//            s = e+1;
//        }
        System.out.println(max);


//        int[][] dp = new int[n+1][2];
//        int max = 0;
//        for (int i = 1; i <=n ; i++) {
//            for (int j = 0; j <i ; j++) {
//                if(str.charAt(i-1)=='0'){
//                    dp[i][0] = Math.max(dp[i][0],dp[j][1]+1);
//                }else {
//                    dp[i][1] = Math.max(dp[i][0],dp[j][0]+1);
//                }
//                max = Math.max(Math.max(dp[i][0],dp[i][1]),max);
//
//            }
//        }
//        System.out.println(Arrays.deepToString(dp));
//        System.out.println(max);

    }
}
