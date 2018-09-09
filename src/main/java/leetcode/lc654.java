package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

//[3,2,1,6,0,5]
//stack:3
//3->2 stack:3,2
//3->2->1 stack:3,2,1
//6->1,stack:3,2 6->2 6->3 stack:6 6left->3right->2->1
//6->0 stack:6,0
//5left->0 stack:6 6right->5

public class lc654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        for(int i = 0; i < nums.length; i++) {
            TreeNode curr = new TreeNode(nums[i]);
            while(!stack.isEmpty() && stack.peek().val < nums[i]) {
                curr.left = stack.pop();
            }
            if(!stack.isEmpty()) {
                stack.peek().right = curr;
            }
            stack.push(curr);
        }

        return stack.isEmpty() ? null : stack.removeLast();
    }

    public static void main(String[] args) {
        lc654 sl = new lc654();
        System.out.println(sl.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5}));
    }
}
