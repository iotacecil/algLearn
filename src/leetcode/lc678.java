package leetcode;

public class lc678 {
    int len = 0;
    public int longestUnivaluePath(TreeNode root) {
    if(root==null)return 0;
    getLen(root,root.val);
    return len;


    }
    private int getLen(TreeNode root,int val){
        if(root ==null) return 0;
        int left = getLen(root.left,root.val);
        int right = getLen(root.right,root.val);
        len = Math.max(len,left+right);
        if(val == root.val)return Math.max(left,right)+1;
        return 0;
    }
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(2);

        node.left=node2;
        node2.right=node3;
        node2.left=node4;
        lc678 sl = new lc678();
        int i = sl.longestUnivaluePath(node);
        System.out.println(i);
    }
}
