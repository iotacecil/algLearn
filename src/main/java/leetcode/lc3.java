package leetcode;

import java.util.HashSet;
import java.util.Set;

public class lc3 {
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
