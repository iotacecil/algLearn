package leetcode;

import java.util.HashMap;
import java.util.TreeMap;

public class lc767 {
    /**
     * Wrong Answer
     * @param S
     * @return
     */
    public String reorganizeString(String S) {
        HashMap<Character,Integer> map = new HashMap<>();

        int n = S.length();
        int[] cnt = new int[26];
        for (int c : S.toCharArray()) {
            cnt[c - 'a']++;
            if (cnt[c - 'a'] > (n % 2 == 0 ? n / 2 : (n / 2 + 1))) return "";
        }
        for(int i=0;i<26;i++)
        map.put((char)('a'+i), cnt[i]);

        char[] rst = new char[n];
        int i=0;
        while (i<n){
            System.out.println(i);
            for (int j = 0; j < 26; j++) {
                if (cnt[j] > 0) {

                    rst[i] = (char) (j + 'a');

                    cnt[j]--;
                    i++;

                }
            }
        }

        return new String(rst);
    }

    public static void main(String[] args) {
        lc767 sl = new lc767();
        System.out.println(sl.reorganizeString("vvvlo"));
    }
}
