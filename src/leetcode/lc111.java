package leetcode;

public class lc111 {
    public static int minDepth(TreeNode root) {
        if(root == null){return 0;}
        //否则如果左子树为空或者右子树为空或者两者都为空，那么就是 1 加上非空子树高度
        int right = minDepth(root.right);
        int left = minDepth(root.left);
        if(right==0||left==0){return 1+right+left;}
        return 1+Math.min(left,right);
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        TreeNode a =lc108right.sortedArrayToBST(nums);
        System.out.println(minDepth(a));
    }

}
