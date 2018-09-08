package leetcode;

import java.util.Arrays;

public class lc392 {
    public boolean isSubsequence(String s, String t) {
        int slen = s.length();
        for (int i = 0; i <slen ; i++) {
            char c = s.charAt(i);
            int index = t.indexOf(c);
            if(index<0)return false;
            t = t.substring(index+1);
            System.out.println(t);
        }
        return true;
    }

    public static void main(String[] args) {
        lc392 sl = new lc392();
        System.out.println(sl.isSubsequence("abc", "ahbgdc"));

    }
}
