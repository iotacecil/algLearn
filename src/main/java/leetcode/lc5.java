package leetcode;



public class lc5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return s;
        StringBuilder sb = new StringBuilder("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i)).append("#");
        }
        int n = sb.length();
        int[] p = new int[n];
        int c = -1, R = -1;
        int rR = 0, rc = 0;
        for (int i = 0; i < n; i++) {
            p[i] = R > i ? Math.min(p[2 * c - i], R - i) : 1;
            while (i - p[i] >= 0 && i + p[i] < n && sb.charAt(i + p[i]) == sb.charAt(i - p[i]))
                p[i]++;
            if (R < i + p[i]) {
                R = i + p[i];
                c = i;
            }
            if (rR < p[i]) {
                rR = p[i];
                rc = i;
            }
        }
        int start = (rc - rR + 1) / 2;
        return s.substring(start, start + rR - 1);
    }
    public static void main(String[] args) {
     lc5 sl = new lc5();
        System.out.println(sl.longestPalindrome("a"));

//        System.loadLibrary();
//        System.out.println((3-1)/2);

    }
}
