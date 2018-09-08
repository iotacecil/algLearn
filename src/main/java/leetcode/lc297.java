package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc297 {
    StringBuilder sb = new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        sb.append("[");
        Deque<TreeNode> que = new ArrayDeque<>();
        que.add(root);
        while(!que.isEmpty()){
            TreeNode cur = que.poll();
            if(cur.val==-1)sb.append("null");
            sb.append(cur.val);
            if(cur.left==null)
                que.push(new TreeNode(-1));
            else que.push(cur.left);
            if(cur.right==null)
                que.push(new TreeNode(-1));
            else que.push(cur.right);

        }
        return "";
    }

    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//
//    }
    public static void main(String[] args) {

    }
}
