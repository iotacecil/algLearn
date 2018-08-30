package leetcode;

import javax.swing.table.TableModel;
import java.util.*;
//todo
public class lc127 {
    public static void main(String[] args) {
        char[] a = {1,2,3,4,5,6};
        char[] b = {1,2,3,4,5,6};
        System.out.println(new String(a).equals(new String(b)));


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
