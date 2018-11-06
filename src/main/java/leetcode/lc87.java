package leetcode;

public class lc87 {
    public boolean isScramble(String s1, String s2) {
        if(s1.length()!=s2.length())return false;
        if(s1.equals(s2))return true;
        int[] cnt = new int[26];
        for (int i = 0; i <s1.length() ; i++) {
            cnt[s1.charAt(i)-'a']++;
            cnt[s2.charAt(i)-'a']--;
        }

        for (int i = 0; i <26 ; i++) {
            if (cnt[i]!=0) {
                return false;
            }

        }
        for (int i = 1; i <s1.length() ; i++) {
            System.out.println(s1.substring(0,i)+" "+s2.substring(0,i));
            System.out.println(s1.substring(i)+" "+s2.substring(i));
            if((isScramble(s1.substring(0,i), s2.substring(0,i))&&
                    isScramble(s1.substring(i), s2.substring(i)))||
                    (isScramble(s1.substring(0,i), s2.substring(s1.length()-i))&&
                    isScramble(s1.substring(i), s2.substring(0,s1.length()-i)))){
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        lc87 sl = new lc87();
        System.out.println(sl.isScramble("abb", "bba"));
    }

}
