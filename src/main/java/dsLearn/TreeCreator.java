package dsLearn;

import java.util.*;

class TreeNodeT<T>{
    public T val;
    public TreeNodeT<T> left;
    public TreeNodeT<T> right;
    public TreeNodeT(T x){
        val = x;
    }
    TreeNodeT root = this;

    @Override
    public String toString(){
        Queue<TreeNodeT> q = new ArrayDeque<>();
        List<T> list = new LinkedList<>();
        q.add(this);
        while (!q.isEmpty()) {
            TreeNodeT top = q.remove();
            list.add((T)top.val);
            if (top.left != null) {
                q.add(top.left);}
            if (top.right != null) {
                q.add(top.right);
            }
        }

        return list.toString();
    }
    @Override
    public Object clone(){
        TreeNodeT newT = null;
        try{
            newT = (TreeNodeT) super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return newT;
    }
}
class TreeTraversal<T>{


    public List<T> post(TreeNodeT root){
        List<T> list = new ArrayList<>();
        if(root==null)return list;
        List<T> left = post(root.left);
        List<T> right = post(root.right);
        list.addAll(left);
        list.addAll(right);
        list.add((T)root.val);
        return list;
    }
}
public class TreeCreator {
    public TreeNodeT<Character> createSampleTree(){
        TreeNodeT<Character> root = new TreeNodeT<Character>('A');

        return root;
    }
    //A BDEG CF
    //DBGE A CF
    public TreeNodeT<Character> createTree(String preOrder,String inOrder){
        if(preOrder.isEmpty())return null;
        char rootVal = preOrder.charAt(0);
        int leftLen = inOrder.indexOf(rootVal);
        TreeNodeT<Character> root = new TreeNodeT<Character>(rootVal);
        root.left = createTree(
                preOrder.substring(1,1+leftLen),
                inOrder.substring(0,leftLen));

        root.right = createTree(
                preOrder.substring(1+leftLen),
                inOrder.substring(leftLen+1));
        return root;
    }
//    public TreeNode buildTreePostIn(int[] inorder, int[] postorder) {
//
//    }
//    private TreeNode buildTreePostIn(int[] inorder, int[] postorder,int )

    public static void main(String[] args) {
        TreeCreator sl = new TreeCreator();
        System.out.println(sl.createTree("ABDEGCF", "DBGEACF"));
        TreeNodeT<Character> tree = sl.createTree("ABDEGCF", "DBGEACF");
        TreeTraversal<Character> traversal = new TreeTraversal();
        System.out.println(traversal.post(tree));
//        Preorder traversal of binary tree is
//        1 2 4 5 3
//        Inorder traversal of binary tree is
//        4 2 5 1 3
//        Postorder traversal of binary tree is
//        4 5 2 3 1
        TreeNodeT<Character> tree2 = sl.createTree("12453", "42513");
        System.out.println(traversal.post(tree2));


    }
}
