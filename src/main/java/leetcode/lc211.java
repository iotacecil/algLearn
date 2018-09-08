//package leetcode;
//
//public class lc211 {
//    class TrieNode{
//        char val;
//        boolean isEnd;
//        TrieNode[] link = new TrieNode[26];
//        TrieNode(char c){
//            this.val = c;
//        }
//    }
//
//    class WordDictionary {
//        TrieNode root;
//        /** Initialize your data structure here. */
//        public WordDictionary() {
//            root  = new TrieNode(' ');
//        }
//
//        /** Adds a word into the data structure. */
//        public void addWord(String word) {
//            TrieNode cur = root;
//            for(int i=0;i<word.length();i++){
//                char c = word.charAt(i);
//                if(cur.link[c-'a']==null){
//                    cur.link[c-'a'] = new TrieNode(c);
//                }
//                cur = cur.link[c-'a'];
//            }
//            cur.isEnd = true;
//        }
//
//        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
//        public boolean search(String word) {
//            TrieNode cur = root;
//            for(int i=0;i<word.length();i++){
//                char c = word.charAt(i);
//                if(c=='.'){
//                    for(int i =0;i<26;i++){
//                        if(cur.link[i]==null)
//                            continue;
//                        cur = cur.link[i];
//                    }
//                }
//
//            }
//            cur.isEnd = true;
//        }
//        private boolean dfs(String word,TrieNode cur,int idx){
//            if(cur.link[word.charAt(idx)-'a']==null)return false;
//            if(idx==word.length()-1&&cur[word.charAt()])
//        }
//    }
//}
