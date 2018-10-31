package leetcode;

import java.util.*;

public class lc127 {
    class Pair{
        String word;
        int step;

        public Pair(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }
    public int ladderLengthcharGraph(String beginWord, String endWord, List<String> wordList) {
        Map<String,List<String>> map = new HashMap<>();
        List<String> words = new ArrayList<>(new HashSet<>(wordList));
        words.add(beginWord);
        if(!words.contains(endWord)){
            return 0;
        }
        // graph build
        for(int i = 0;i<words.size();i++){
            String word1 = words.get(i);
            List<String> word1List = map.getOrDefault(word1, new ArrayList<>());
            for (int j = i+1; j <words.size() ; j++) {
                String word2 = words.get(j);
                if(dif(word1,word2 )){
                    List<String> word2List = map.getOrDefault(word2, new ArrayList<>());
                    word2List.add(word1);
                    map.put(word2,word2List);
                    word1List.add(word2);
                }
                map.put(word1,word1List );
            }
        }
        // bfs
        Deque<Pair> que = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        que.add(new Pair(beginWord,1));
        visited.add(beginWord);

        while (!que.isEmpty()){
            Pair top = que.poll();
            int step = top.step;
            List<String> neib = map.get(top.word);
            for(String next : neib){
                if(!visited.contains(next)){
                    if(next.equals(endWord)){
                        return step + 1;
                    }
                    que.add(new Pair(next,step+1));
                    visited.add(next);
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
//        char[] a = {1,2,3,4,5,6};
//        char[] b = {1,2,3,4,5,6};
//        System.out.println(new String(a).equals(new String(b)));
//        HashSet<String> set = new HashSet<>();
//        set.add("hit");
//        String hit = "hit";
//        System.out.println(set.contains(hit));
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        lc127 ls = new lc127();
        System.out.println(ls.ladderLengthcharGraph(beginWord, endWord, wordList));

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

        HashSet<String> words = new HashSet<>(wordList);
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
