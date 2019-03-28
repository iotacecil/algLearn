package leetcode;
//Input: S = "ADOBECODEBANC", T = "ABC"
//Output: "BANC"
public class lc76 {

    public String minWindow2(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        int st = 0;
        int e = 0;
        int[] cnt = new int[256];

        for(char c:t.toCharArray()){
            cnt[c]++;
        }
        int[] cnt2 = new int[256];
        int match = 0;
        //

        int minlen = n1+1;
        int rl = 0;
        int rr = 0;
        String rst = "";
        // ABDC   ABC
        //1 1 1
        //
        // boolean match = false;

        while(e<n1){
            while(e<n1 && match < n2){
                char c = s.charAt(e);
                if(cnt[c] >0){
                    if(cnt[c] > cnt2[c]){
                        match++;
                    }
                    cnt2[c]++;
                }
                e++;
            }
            // e = 4
            //match == n2
            //  if(match <n2)return "";
            while(st <n1 && match == n2){
                char c = s.charAt(st);
                // ABC
                //
                if(cnt[c] < cnt2[c]){
                    cnt2[c]--;
                }
                else if(cnt[c]>0 && cnt[c] == cnt2[c]){
                    cnt2[c]--;
                    match--;
                }
                st++;
            }

            if(e-st+1 < minlen){
                rl = st-1;
                rr = e;
                rst = s.substring(rl,rr);
                minlen = e-st+1;
                //   e++;
            }

        }
        return rst;

    }


    //84%
    public String minWindow(String s, String t) {
        int[] ch = new int[128];
        for(char c:t.toCharArray()){
            ch[c]++;
        }
        int begin = 0,end = 0;
        int d = Integer.MAX_VALUE;
        int head=0;
        int count = t.length();
        while (end<s.length()){
            if(ch[s.charAt(end++)]-->0)count--;
            while (count==0){
                if(end-begin<d)d = end-(head=begin);
                if(ch[s.charAt(begin++)]++==0)count++;
            }
        }
        return d == Integer.MAX_VALUE?"":s.substring(head,head+d );

    }

    public static void main(String[] args) {
        lc76 sl = new lc76();
//        System.out.println(sl.minWindow2("ADOBECODEBANC", "ABC"));
        System.out.println(sl.minWindow2("a", "a"));
    }
}
