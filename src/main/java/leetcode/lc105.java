package leetcode;

public class lc105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int rootval = preorder[0];
        int i;
        for (i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootval) break;
        }
        // [3,  9,  20,15,7]
        // [9,  3,  15,20,7]
        TreeNode root = new TreeNode(rootval);
        root.left = build(preorder, inorder, 1, 1 + i, 0, i);
        root.right = build(preorder, inorder, i + 1, preorder.length, i + 1, inorder.length);
        return root;

    }

    private TreeNode build(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
        if (pl >= pr || il >= ir) return null;
        int rootval = preorder[pl];
        int i;
        for (i = il; i < ir; i++) {
            if (inorder[i] == rootval) break;
        }
        // [3,  9,  20,15,7]
        // [9,  3,  15,20,7]
        //
        TreeNode root = new TreeNode(rootval);
        root.left = build(preorder, inorder, pl + 1, i, il, il + i);
        root.right = build(preorder, inorder, i, pr, i + 1, ir);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{3, 9, 20, 15, 7};
        int[] in = new int[]{9, 3, 15, 20, 7};
        lc105 sl = new lc105();
        sl.buildTree(pre, in);

    }
}
