package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc114 {
    Deque<TreeNode> stk = new ArrayDeque<TreeNode>();

    public void flatten2(TreeNode root) {
        if (root == null) return;
        stk.push(root);
        while (!stk.isEmpty()){
            TreeNode cur = stk.pop();
            if(cur.right!=null)
                stk.push(cur.right);
            if(cur.left!=null)
                stk.push(cur.left);
            cur.right = stk.peek();
            cur.left = null;
        }
    }
    public void flatten(TreeNode root) {
        if(root == null)return ;
        flatten(root.left);
        flatten(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left= null;
        root.right = root.left;
        while(root.right!=null){
            root= root.right;
        }
        root.right = right;

    }
}
