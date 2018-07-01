package leetcode;

public class lc110 {
    public static boolean isBalanced(TreeNode root) {
        int level=0;
        return height(root)==-1?false:true;

    }
    public static int height (TreeNode node){
        if (node == null) return 0;
        int left = height(node.left);
        int right = height(node.right);
        if(left==-1||right==-1||Math.abs(left-right)>1)return -1;
        return 1+Math.max(left,right);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        TreeNode a =lc108right.sortedArrayToBST(nums);
        System.out.println(isBalanced(a));
    }

}
