package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class BST<Key> {
    public TNode<Key> root;
    public BST(TNode<Key> root){
        this.root=root;
    }

//    private Node put(Key key){
//        if (key!=null){return new Node(key);}
//        else {throw new IllegalArgumentException("key");}
//    }
//    public void put()

    public Iterable<Key> levelOrder(){
        Queue<Key> keys = new ArrayDeque<>();

        Queue<TNode> queue = new ArrayDeque<>();
        queue.add(root);
//        System.out.println(queue);
        while(!queue.isEmpty()){
            TNode x = queue.remove();
            if(x == null){continue;}
            keys.add((Key)x.val);
            if(x.left!=null)
            queue.add(x.left);
            if(x.right!=null)
                queue.add(x.right);

        }

        return keys;
    }
    public void print(){
        for(Key k :levelOrder()){
            System.out.print(k+" ");
        }
    }

//    public void print(ListNode x){
//        if(x==null)return;
//        System.out.println(x.key);
//        print(x.left);
//        print(x.right);
//    }
}
