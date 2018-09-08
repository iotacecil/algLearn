package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class lc226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            TreeNode cur = que.poll();
            TreeNode tmp = cur.left;
            cur.left=cur.right;
            cur.right = tmp;
            if(cur.left!=null)que.add(cur.left);
            if(cur.right!=null)que.add(cur.right);

        }
        return root;
    }
}
