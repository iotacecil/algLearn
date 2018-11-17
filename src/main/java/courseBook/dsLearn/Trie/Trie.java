package courseBook.dsLearn.Trie;

import java.util.TreeMap;

public class Trie {
    private class Node{
        public boolean isWord;
        public TreeMap<Character,Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            this.next = next;
        }

        public Node() {
            this(false);
        }
    }
    private Node root;

    public void add(String word){
        Node cur = root;
        for (int i = 0; i <word.length() ; i++) {
            char c = word.charAt(i);
            if(cur.next.get(c) == null){
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        cur.isWord = true;
    }
}
