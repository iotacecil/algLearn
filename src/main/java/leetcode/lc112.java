package leetcode;

public class lc112 {
    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        System.out.println("node.val="+root.val);
        if(root.left==null&&root.right==null){

            if(sum==root.val) {
                System.out.println(sum);
                return true;
            }
            else {return false;}
        }
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        TreeNode a =lc108right.sortedArrayToBST(nums);
        System.out.println(a.toString());
        System.out.println(lc107.levelOrderBottom(a));
        System.out.println(hasPathSum(a,15));
    }
}
