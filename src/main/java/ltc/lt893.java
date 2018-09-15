package ltc;

public class lt893 {
    /** 234ms 54%
     * Manacher?
     * @param s "abcdzdcab"，
     * @return 它的最长回文子串为 "cdzdc"。
     */
    public String longestPalindrome2(String s) {
        StringBuilder sb = new StringBuilder("^#");
        for (int i = 0; i !=s.length() ; i++)
            sb.append(s.charAt(i)).append("#");
        sb.append("$");
        final int N = sb.length();
        int[] p = new int[N];
        //id是长度为mx的回文串的中心(?
        int id = 0,mx = 0;
        int maxLen = 0,maxId= 0;
        for (int i = 1; i <N-1 ; i++) {
            //注意
//            System.out.println(2*id-i);

            p[i] = mx > i ? Math.min(p[2 * id - i], mx - i ) : 1;

            while(sb.charAt(i+p[i])==sb.charAt(i-p[i]))
                p[i]++;
            if(mx < i+p[i]){
                mx = i+p[i];
                id = i;
            }
            if(maxLen < p[i]){
                maxLen = p[i];
                maxId = i;
            }
        }
        int start = (maxId-maxLen)/2;
        return s.substring(start,start+maxLen-1);
    }

    /**
     * 99% 更简单的一种写法
     * //todo
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0){
            return s;
        }
        char[] ca = s.toCharArray();
        int rs = 0, re = 0;
        int max = 0;
        for(int i = 0; i < ca.length; i++) {
            if(isPalindrome(ca, i - max - 1, i)) {
                rs = i - max - 1; re = i;
                max += 2;
            } else if(isPalindrome(ca, i - max, i)) {
                rs = i - max; re = i;
                max += 1;
            }
        }
        return s.substring(rs, re + 1);
    }

    private boolean isPalindrome(char[] ca, int s, int e) {
        if(s < 0) return false;

        while(s < e) {
            if(ca[s++] != ca[e--]) return false;
        }
        return true;
    }

    /**
     * 219ms
     */
    int max = 0;
    int left = 0;
    char[] chars;
    public String longestPalindrome2fromLC(String s) {



        if (s == null || s.length() == 0){
            return s;
        }
        chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++){
            i = longestPalindrome(i);
        }
        return s.substring(left, left + max);
    }

    private int longestPalindrome(int index){
        int ll = index, rr = index;
        while (rr + 1 < chars.length && chars[rr] == chars[rr + 1]){
            rr++;
        }
        int temp = rr;
        while (ll - 1 >= 0 && rr + 1 < chars.length && chars[ll - 1] == chars[rr + 1]){
            ll--;
            rr++;
        }
        if (rr - ll  + 1 > max){
            max = rr - ll + 1;
            left = ll;
        }
        return temp;

    }
    public String longestPalindrome22(String s) {
        int start = 0;
        int maxLength = 1;
        // One by one consider every character as center point of even and length palindromes
        for (int i = 1; i < s.length(); ++i) {
            // Find the longest even length palindrome with center points as i-1 and i.
            int low = i - 1;
            int high = i;
            while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }
            // Find the longest odd length palindrome with center point as i
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }
        }
        return s.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        lt893 sl = new lt893();
        System.out.println(sl.longestPalindrome2("abcdzdcab"));
    }
}

















