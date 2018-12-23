package leetcode;

import java.util.Arrays;

public class lc567 {


    public boolean checkInclusion(String s1, String s2) {
        int[] s1cnt = new int[26];
        for(char c : s1.toCharArray()){
            s1cnt[c - 'a'] ++;
        }

        for (int i = 0; i <s2.length()-s1.length()+1 ; i++) {
            String s2tmp = s2.substring(i, i + s1.length());
            if(cntmatch(s1cnt, s2tmp)){
                return true;
            }

        }
        return false;

    }

    boolean cntmatch(int[] s1cnt,String s2){
        int[] s2cnt = new int[26];
        for(char c : s2.toCharArray()){
            int idx = c - 'a';
            s2cnt[idx] ++;
            if(s2cnt[idx] > s1cnt[idx])return false;
        }
        for (int i = 0; i <26 ; i++) {
            if(s2cnt[i] != s1cnt[i])return false;
        }
        return true;
    }

    String sort(String s1){
        char[] s11 = s1.toCharArray();
        Arrays.sort(s11);
        s1 = new String(s11);
        return s1;
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "bbbca";
        char[] s11 = s1.toCharArray();
        Arrays.sort(s11);
        char[] s22 = s2.toCharArray();
        Arrays.sort(s22);

String n1 = "123";
String n2 = "45";
        lc567 sl = new lc567();
//        System.out.println(sl.checkInclusion(s1, s2));

    }
}
