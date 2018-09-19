package ltc;

import leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class lt1577 {
    public int sumLeafNode(TreeNode root) {
        // Write your code here
        if(root == null)return 0;
        if(root.left==null&&root.right==null)return root.val;
        int sum = 0;
        sum+=sumLeafNode(root.left);
        sum+=sumLeafNode(root.right);
        return sum;
        }

}
