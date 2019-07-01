package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc99 {
    // 肯定是中序遍历的前一个和后一个
    public void recoverTree(TreeNode root) {
        TreeNode pre = null;
        TreeNode first = null;
        TreeNode second = null;
        Deque<TreeNode> stk = new ArrayDeque<>();
        TreeNode p = root;
        while (p!=null || !stk.isEmpty()) {
            while (p != null) {
                stk.push(p);
                p = p.left;
            }
            p = stk.pop();
            if (pre != null) {
                if (pre.val > p.val) {
                    if (first == null) first = pre;
                    second = p;
                }
            }
            pre = p;
            p = p.right;
        }
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;

    }
}
