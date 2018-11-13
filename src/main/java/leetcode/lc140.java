package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class lc140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = wordDict.stream().distinct().collect(Collectors.toSet());
        return dfs(s,wordSet,new HashMap<>());

    }

    List<String> dfs (String s, Set<String> wordDict, Map<String,List<String>> map){
        if(map.containsKey(s)){
            return map.get(s);
        }

        List<String> rst = new ArrayList<>();
        if(s.length() == 0){
            rst.add("");
            return rst;
        }

        for(String word : wordDict){
            if(s.startsWith(word)){
                List<String> sublist = dfs(s.substring(word.length()),wordDict,map);
                for(String sub : sublist){
                    rst.add(word+(sub.isEmpty()?"":" ") + sub);
                }
            }
        }
        map.put(s, rst);
        return rst;
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict= Arrays.asList("cat", "cats", "and", "sand", "dog");
        lc140 sl = new lc140();
        System.out.println(sl.wordBreak(s, wordDict));
    }
}
