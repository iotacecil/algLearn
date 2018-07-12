package leetcode;


import java.util.Arrays;

public class lc97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        boolean[] dp = new boolean[s1.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s3.length(); i++) {
            boolean ct = true;
            //len1
            for (int j = Math.min(s1.length(), i + 1); j > 0; j--) {
                //与s2匹配
                //j是s1的长度
                System.out.println("i:"+i+" j；"+j);
                //i-j是s2的长度
                if (dp[j] && (i-j)<s2.length() &&s2.charAt(i - j) == s3.charAt(i)) {
                  //  System.out.println("i:"+i+ " i-j:"+(i-j)+s2.charAt(i-j)+" s3:"+s3.charAt(i));
                    ct = false;
                }
                else if (dp[j - 1] && s1.charAt(j- 1) == s3.charAt(i)){
                    dp[j] = true;
                    ct = false;
                }else {
                    System.out.println("else:"+i+" "+j);
                    dp[j] = false;}
            }
            if(dp[0]&&i<s2.length()&&s2.charAt(i)==s3.charAt(i))ct = false;
            if(ct)return false;
            System.out.println(Arrays.toString(dp));
            System.out.println(ct);
        }
        return true;
    }
    public static void main(String[] args) {
        lc97 sl = new lc97();
        System.out.println(sl.isInterleave("aabcc", "dbbca", "aadbbcbcac"));

    }
}
