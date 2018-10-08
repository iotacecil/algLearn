package leetcode;

import java.util.*;

//words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
public class lc890 {
    //tow maps
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (match(word, pattern)) {
                ans.add(word);
            }
        }
        return ans;
    }

    private boolean match(String word, String pattern) {
        Map<Character, Character> m1 = new HashMap<>();
        Map<Character, Character> m2 = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            if (!m1.containsKey(w)) m1.put(w, p);
            if (!m2.containsKey(p)) m2.put(p, w);
            //有一个没放成功
            if (m1.get(w) != p || m2.get(p) != w)
                return false;

        }
        return true;
    }

    //one map
    private boolean math2(String word,String pattern){
        Map<Character,Character> map = new HashMap<>();
        for (int i = 0; i <word.length() ; i++) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            if(!map.containsKey(w))map.put(w,p );
            System.out.println(map);
            if(map.get(w)!=p)return false;
        }
        boolean[] seen = new boolean[26];
        for(char p:map.values()){
            //每个pattern的字母只能匹配一次 如果mee匹配上abb map里只有m:a,e:b
        if(seen[p-'a']) return false;
        seen[p-'a'] = true;
            System.out.println(Arrays.toString(seen));

        }
        return true;
    }

    public static void main(String[] args) {
        lc890 sl = new lc890();
        sl.math2("abc","abb" );
    }

}
