package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class lc94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        if(root == null){
            return rst;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(true){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            if(stack.isEmpty())
                break;
            root = stack.pop();
            rst.add(root.val);
            root = root.right;

        }
        return rst;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode one= new TreeNode(1);
        TreeNode four = new TreeNode(4);

        root.left = one;
        root.right = three;
        one.right = four;

        lc94 sl = new lc94();
        System.out.println(sl.inorderTraversal(root));
    }
}
