package leetcode;

public class lc451 {
    public String frequencySort(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            int max = 0;
            char maxc = 'a';

            for (int i = 0; i < 26; i++) {
                if (cnt[i] > max) {
                    max = cnt[i];
                    maxc = (char) ('a' + i);
                }
            }
            if (max == 0) break;
            while (max-- > 0) {
                sb.append(maxc);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        lc451 sl = new lc451();
        System.out.println(sl.frequencySort("tree"));
    }
}
