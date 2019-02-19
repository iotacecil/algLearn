package leetcode;

import java.util.ArrayList;
import java.util.List;

public class lc316 {

    public String removeDuplicateLetters(String s) {
        int[] cnt = new int[26];
        List<Character> arr = new ArrayList<>();

        for(char c : s.toCharArray()){
            if(cnt[c-'a'] == 0){
                arr.add(c);
            }else if(cnt[c-'a'] >0)
            {
                int idx = arr.indexOf(c);
                if(idx<arr.size()-1 && arr.get(idx+1)<c){
                    arr.remove(idx);
                    arr.add(c);
                }else continue;
            }

                cnt[c-'a']++;

        }
        StringBuilder sb = new StringBuilder();
        for(Character c: arr){
           sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "bcabc";
        lc316 sl = new lc316();
        System.out.println(sl.removeDuplicateLetters(str));
    }
}
