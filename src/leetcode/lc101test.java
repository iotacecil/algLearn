package leetcode;

import java.beans.BeanInfo;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

public class lc101test  {
    public static boolean isSymmetric(TNode root){
        if(root!= null){
            return islr(root.left,root.right);


        }
        else {return true;}
    }
    private static boolean islr(TNode left,TNode right){
        System.out.println(left+" "+right+" "+(left==right));

        if(left==null||right==null){return left==right;}
        if(left.val!=right.val){return false;}
        return islr(left.left,right.right)&&islr(left.right,right.left);
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
        bst.print();
        System.out.println(isSymmetric(root));



    }
}
