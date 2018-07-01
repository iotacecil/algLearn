package leetcode;

public class lc437 {
    private int helper(TreeNode root,int sum){
        int res = 0;
        if(root==null) return res;
        if(sum==root.val) return res++;
        res+=helper(root.left,sum-root.val)+helper(root.right,sum-root.val);
        return res;
    }
    public int count(TreeNode root,int num){
        if(root == null) return 0;
        return helper(root,num)+count(root.left,num)+count(root.right,num);
    }

}
