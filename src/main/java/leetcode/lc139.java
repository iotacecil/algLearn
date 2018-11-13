package leetcode;

import java.util.*;

public class lc139 {
//    public boolean wordBreakBFS(String s,List<String> wordDict){
//        Deque<String> que = new ArrayDeque<>();
//        que.add("");
//        while (!que.isEmpty()){
//
//        }
//    }
    public boolean wordBreakDP(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int len = 1; len <s.length() ; len++) {
            for (int start = 0; start <len ; start++) {
                if(dp[start] && wordDict.contains(s.substring(start,len ))){
                    dp[start] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        HashSet<String> wd = new HashSet<>(wordDict);
        return canBreak(s,wd,set);
    }
    private boolean canBreak(String s,Set<String> wordDict,Set<String> set){
       if(s.isEmpty()){
           return true;
       }

        if(set.contains(s)){
            return false;
        }
        set.add(s);
       for(String word : wordDict){
           if(s.startsWith(word) && canBreak(s.substring(word.length()), wordDict, set)){
               return true;
           }
       }
//        for(int i = 1;i < s.length();i++){
//            String prefix = s.substring(0,i);
//            if(wordDict.contains(prefix) ){
//            if(canBreak(i,s.substring(idx),wordDict,set)){
//                return true;
//            }else{
//                set.add(s);
//            }
//        }
//        set.add();
        return false;
    }

}
