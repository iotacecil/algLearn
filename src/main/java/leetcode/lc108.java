package leetcode;
//？？？？？？

public class lc108 {
    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null||nums.length==0){ return null;}

        TreeNode root = null;

        root = putarr(root,nums,0,nums.length-1);
        return root;
    }
    public static TreeNode putarr(TreeNode node ,int[] nums,int low,int high){

        if(high<low){return null;}
        int mid = low+(high-low)/2;

        System.out.println(mid);
        TreeNode root = new TreeNode(nums[mid]);

        root.left =  putarr(root,nums,low,mid-1);
        root.right = putarr(root,nums,mid+1,high);
        return root;


    }
    private static TreeNode put(TreeNode node,int x){
        if(node==null){
            System.out.println(x);return new TreeNode(x);}
        if(node.val>x){put(node.left,x);}
        if(node.val<x){put(node.right,x);}
        if(node.val==x){node.val=x;}
        return node;


    }
    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        TreeNode root = sortedArrayToBST(nums);
        System.out.println(root.left.val);
    }
}
