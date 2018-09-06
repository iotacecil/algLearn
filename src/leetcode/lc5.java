package leetcode;



public class lc5 {
//    private void ss(String s){
//        if(s.charAt(0)==s.charAt(s.length()-1)){
//                ss(s.substring(1,s.length()-2 ));
//        }
//    }
//    public String longestPalindromeDP(String s) {
//    int n = s.length();
//    int[][] dp = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j =n-1; j >=0 ; j--) {
//                if(s.charAt(i)==s.charAt(j)){
//                    dp[]
//                }
//
//
//            }
//
//        }
//    }

//    public String longestPalindromeLCS(String s) {
//        int n =s.length();
//        int[][] dp = new int[n+1][n+1];
//        int left=0;
//        int max=0;
//        int maxleft =0;
//        int maxright = 0;
//        String str="";
//        for(int i=n-1;i>=0;i--) {
//            for (int j = n - 1; j >= 0; j--) {
//                if (s.charAt(left) == s.charAt(j)) {
//                    dp[i][j] = 1 + dp[i + 1][j + 1];
//                    if (dp[i][j] > max) {
//                        maxleft = left;
//                        maxright = j;
//                        System.out.println(j+" "+maxright);
//                    }
//
//                }
//
//            }
//            left++;
//        }
//        return s.substring(maxleft, maxright);
//    }


    //2% 1028ms O(3)
    private boolean aba(String s){
        int j = s.length()-1;
        int i = 0;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }else{
                i++;j--;
            }
        }
        return true;
    }
    public String longestPalindrome(String s) {
        int len = 0;
        String rst="";
        for (int i = 0; i <s.length() ; i++) {
            for (int j = s.length(); j >=i+1&&j>=i+len ; j--) {
                String substring = s.substring(i, j);
                if(aba(substring)){
                    len = Math.max(len,substring.length());
                    rst = substring;
                }

            }

        }
        return rst;
    }
    public static void main(String[] args) {
     lc5 sl = new lc5();
        System.out.println(sl.longestPalindrome("abab"));

//        System.loadLibrary();
//        System.out.println((3-1)/2);

    }
}
