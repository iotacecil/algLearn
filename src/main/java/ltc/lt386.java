package ltc;
/*
输入: S = "eceba" 并且 k = 3
输出: 4
解释: T = "eceb"
 */
public class lt386 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        int e = 0;int ss = 0;
        int[] ch = new int[256];
        if(k == 0)return 0;
        int cnt = 0;
        int rst = 0;
        while (e<n){
            char c = s.charAt(e);
            if(ch[c]==0){
                cnt++;
                ch[c]++;
                while (ss <e && cnt > k) {
                    rst = Math.max(rst,e-ss);
                    char cs = s.charAt(ss);
                    ch[cs]--;
                    if (ch[cs] == 0) cnt--;
                    ss++;
                }
            }else{
                ch[c]++;
            }
            if(cnt<=k){
                rst = Math.max(rst,e-ss+1);
            }
            e++;
        }
        return rst;
    }

    public static void main(String[] args) {
        lt386 sl = new lt386();
        String str = "nfhiexxjrtvpfhkrxcutexxcodfioburrtjefrgwrnqtyzelvtpvwdvvpsbudwtiryqzzy";
        System.out.println(str.length());
        System.out.println(sl.lengthOfLongestSubstringKDistinct("nfhiexxjrtvpfhkrxcutexxcodfioburrtjefrgwrnqtyzelvtpvwdvvpsbudwtiryqzzy", 25));
    }
}
