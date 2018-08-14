package leetcode;

public class lc543 {
    int rst=0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return rst;
    }
    private int height(TreeNode root){
        if(root==null)return 0;
        int left =1+height(root.left);
        int right = 1+height(root.right);
        rst = Math.max(rst,left+right);
        return Math.max(left,right);

    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        lc543 sl = new lc543();
        System.out.println(sl.diameterOfBinaryTree(t));
    }
}
