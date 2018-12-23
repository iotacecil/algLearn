package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class lc3 {
    public static void main(String[] args) {
        String s = "tmmzuxt";
        lc3 sl = new lc3();
        System.out.println(sl.lengthOfLongestSubstring2(s));
    }
    public int lengthOfLongestSubstring2(String s) {
        if(s==null || s.length() <1 )return 0;
        int n = s.length();
        int start = 0;
        int mlen = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i =0;i < n ;i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                start = Math.max(start,map.get(c) + 1);

            }
            System.out.println(c+" "+start);
            mlen = Math.max(mlen,i - start +1);
            map.put(c, i);
        }
        return mlen;
    }

    public int lengthOfLongestSubstring(String s){
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0,i=0,j=0;
        //维持一个窗口[i,j)， 放到set中，如果没重复继续向右扩展，如果重复，窗口向右移动
        while (i<n&&j<n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans,j-i);
            }else{
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
//    public int lengthOf(String s){
//        int n = s.length(),ans = 0;
//        int[] index = new int[128];
//        for (int i = 0,j=0; i <n ; i++) {
//            i = Math.max(index[s.charAt(j)],i);
//            ans =
//
//        }
//    }

}
