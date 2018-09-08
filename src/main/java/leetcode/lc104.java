package leetcode;

public class lc104 {
    public static int maxDepth(TNode root) {
        if(root == null){return 0;}
        int max=0;
        return Math.max(maxDepth(root.left)+1,maxDepth(root.right)+1);
    }

    public static void main(String[] args) {
        TNode root = new TNode(2);
        TNode l2l = new TNode(3);
        TNode l2r = new TNode(3);
        TNode l3 = new TNode(4);
        TNode l4 = new TNode(3);
        TNode l5 = new TNode(3);
        TNode l6 = new TNode(4);
        root.left=l2l;
        root.right=l2r;
        l2l.left=l3;
        l2l.right=l4;
        l2r.left=l5;
        l2r.right=l6;
        BST<Integer> bst = new BST(root);
        System.out.println(maxDepth(root));
    }
}
