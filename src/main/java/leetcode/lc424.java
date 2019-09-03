package leetcode;

public class lc424 {
    public int characterReplacement(String str,int k){
        int n = str.length();
        int[] cnt = new int[26];
        int s = 0;
        int maxcnt = 0;
        int maxlen = 0;
        int e = 0;


        while (e<n){
            char c = str.charAt(e);
            // 这个范围里出现最多的字符 关键
            maxcnt = Math.max(maxcnt,++cnt[c-'A']);
            //其他字符>k个,不用管左边是什么字符，只要长度保证就ok了
            while (e-s+1-maxcnt>k){
                cnt[str.charAt(s)-'A']--;
                s++;
            }
        //    System.out.println(s+" "+e);
            maxlen= Math.max(maxlen,e-s+1 );
            e++;
        }
        return maxlen;
    }
    public static void main(String[] args) {
        String str = "ABABAB";
        int k = 1;
        lc424 sl = new lc424();
        sl.characterReplacement(str,k );

    }
}
