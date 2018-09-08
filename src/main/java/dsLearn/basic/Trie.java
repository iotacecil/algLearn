package dsLearn.basic;

public class Trie<Value> {
    private static final int R = 256;
    private Node root = new Node();
    private  static  class Node{
        private Object value;
        private  Node[] next = new Node[R];

    }
    public void put(String key,Value val){
        root = put(root,key,val,0);
    }
    private Node put(Node x,String key,Value val, int d){
        if(x == null) x= new Node();
        if(d == key.length()){
            x.value= val;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = put(x.next[c],key,val,d+1);
        return x;
    }

}
