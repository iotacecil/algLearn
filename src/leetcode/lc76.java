package leetcode;
//Input: S = "ADOBECODEBANC", T = "ABC"
//Output: "BANC"
public class lc76 {

    //todo nexttime
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
        System.out.println(sl.minWindow("ADOBECODEBANC", "ABC"));
    }
}
