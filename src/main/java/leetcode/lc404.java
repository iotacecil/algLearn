package leetcode;

public class lc404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null || (root.left==null&&root.right==null))return 0;
        int sum = 0;
        if(root.left !=null )
        {
            if(root.left.left == null && root.left.right ==null){
                sum+=root.left.val;
            }
            sum+=sumOfLeftLeaves(root.left);
        }
        System.out.println(sum);
        if(root.right!=null){


            sum+=sumOfLeftLeaves(root.right);
        }

        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        System.out.println(new lc404().sumOfLeftLeaves(root));
    }
}
