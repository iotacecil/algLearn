package leetcode;

import java.util.ArrayList;
import java.util.List;

public class lc145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null)return list;


        List<Integer> left = postorderTraversal(root.left);
        List<Integer> right = postorderTraversal(root.right);
        list.addAll(left);
        list.addAll(right);
        list.add(root.val);
        return list;

    }
}
