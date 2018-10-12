package leetcode;

import java.util.*;

public class lc127 {
    public static void main(String[] args) {
        char[] a = {1,2,3,4,5,6};
        char[] b = {1,2,3,4,5,6};
        System.out.println(new String(a).equals(new String(b)));
        HashSet<String> set = new HashSet<>();
        set.add("hit");
        String hit = "hit";
        System.out.println(set.contains(hit));

    }
    private boolean dif(String difword,String cur){
        int cnt=0;
        for(int i =0;i<difword.length();i++){
            if(difword.charAt(i)!=cur.charAt(i)){
                cnt++;
                if(cnt>1)return false;
            }
        }
        return true;
    }
    public int ladderLengthchar(String beginWord, String endWord, List<String> wordList) {
        int cnt = 0;
        HashSet<String> words = new HashSet<>();
        for(String word:wordList){
            words.add(word);
        }
        Set<String> marked = new HashSet<>();
        Deque<String> que = new ArrayDeque<>();
        que.add(beginWord);
        marked.add(beginWord);
        while(!que.isEmpty()){
            cnt++;
            int size = que.size();
            while(size>0){
                size--;
                String cur = que.poll();
                char[] curr = cur.toCharArray();
                for(int i =0;i<curr.length;i++){
                    for(char c='a';c<='z';c++){
                        if(curr[i]!=c){
                            curr[i]=c;
                            String next = new String(curr);
                            if(words.contains(next)){
                                if(next.equals(endWord))return cnt+1;
                                if(!marked.contains(next)){
                                    que.add(next);
                                    marked.add(next);
                                }
                            }
                        }
                    }
                }

            }
        }
        return 0;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int cnt = 0;
        HashSet<String> words = new HashSet<>();
        for(String word:wordList){
            words.add(word);
        }
        Set<String> marked = new HashSet<>();
        Deque<String> que = new ArrayDeque<>();
        que.add(beginWord);
        marked.add(beginWord);
        while(!que.isEmpty()){
            cnt++;
            int size = que.size();
            while(size>0){
                size--;
                String cur = que.poll();

                //list.size()*cur.length()
                //cur.length()*25
                for(String difword:words){
                    if(dif(difword,cur)){
                        if(difword.equals(endWord))return cnt+1;
                        if(!marked.contains(difword)){
                        que.add(difword);
                        marked.add(difword);
                        }
                    }
                }
            }
        }
        return 0;
    }
//    private boolean diffone(String s1,String s2){
//        if(s1.length()!=s2.length())return false;
//        for (int i = 0; i <s1.length() ; i++) {
//            for (int j = 0; j <s2.length() ; j++) {
//
//            }
//
//        }
//    }
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        Deque<String> queue = new ArrayDeque<>();
//        HashSet<String> words = new HashSet<>(wordList);
//        if(!words.contains(endWord))return 0;
//        queue.push(beginWord);
//        //这个单词通过改第几位
//        Map<String,Integer> map = new HashMap<>();
//        map.put(beginWord,-1);
//        int step = 0;
//        while(!queue.isEmpty()){
//            step++;
//            String wordd = queue.poll();
//            char[] word = wordd.toCharArray();
//            int loc = map.get(word);
//            for (int idx = 0; idx < word.length; idx++) {
//
//                char ch = word[idx];
//                for (char i = 'a'; i <='z' ; i++) {
//                    word[idx] = i;
//                    String tmp = new String(word);
//                    if(tmp.equals(endWord)){
//                        return step+1;
//                    }
//                    if(!words.contains(tmp))continue;
//                    map.put(tmp,idx);
//                    words.remove(tmp)
//
//                }
//
//            }
//        }
//
//    }
}
