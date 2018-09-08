package leetcode;

class TrieNode{
    public char val;
    public boolean end;
    public TrieNode[] children = new TrieNode[26];
    TrieNode(){}
    TrieNode(char c){
        TrieNode node = new TrieNode();
        node.val = c;
    }
}
class Trie {

    private TrieNode root;

    public Trie() {
       root = new TrieNode();
       root.val = ' ';

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c= word.charAt(i);
            if(cur.children[c-'a']==null){
                cur.children[c-'a'] = new TrieNode(c);
            }
            cur = cur.children[c-'a'];
        }
        cur.end = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length() ; i++) {
            char c = word.charAt(i);
            if(cur.children[c-'a']==null)return false;
            cur = cur.children[c-'a'];
        }
        return cur.end;
    }

//trie.startsWith("app"); // returns true
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length() ; i++) {
            char c = prefix.charAt(i);
            if(cur.children[c-'a']== null)return false;
            cur = cur.children[c-'a'];
        }
        return true;
    }
}
public class lc208 {


    public static void main(String[] args) {

    }
}
