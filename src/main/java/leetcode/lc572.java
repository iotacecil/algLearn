package leetcode;

import org.junit.jupiter.api.Test;

public class lc572 {
    public boolean isSubtree2(TreeNode s, TreeNode t) {
        if (s == null) return false;
        // 以根为子树相等
        //左子树或者右子树 为子树相等
        if (isSame(s, t)) return true;
        return isSubtree2(s.left, t) || isSubtree2(s.right, t);


    }

    // 两棵树是不是每个节点都相等
    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }


    private String tree2string(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append("#" + root.val + "#");
        if (root.left == null) sb.append("l_");
        else
            sb.append(tree2string(root.left));
        if (root.right == null) sb.append("r_");
        else
            sb.append(tree2string(root.right));
        return sb.toString();
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        String s1 = tree2string(s);
        String s2 = tree2string(t);
        if (s1.contains(s2)) {
            return true;
        }
        return false;
    }

    @Test
    public void test1() {
        TreeNode t1 = new TreeNode(12);
        System.out.println(tree2string(t1));
        TreeNode t2 = new TreeNode(2);
        System.out.println(tree2string(t2));

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        root.left = four;
        root.right = five;
        four.left = one;
        four.right = two;

        System.out.println((new lc572()).tree2string(root));
    }
}
