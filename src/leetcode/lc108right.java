package leetcode;

public class lc108right {
    public static TreeNode sortedArrayToBST(int[] num) {
    if(num.length==0){
        return null;
        }else {
        return put(num,0,num.length-1);
    }
    }
    public static TreeNode put(int[] num,int low,int high){
        if(low>high){
            return null;
        }
        int mid = low+(high-low)/2;// if low and high are all big integers, low+high will cause integer overflow.
        System.out.println(low+" "+mid+" "+high);
        TreeNode node = new TreeNode(num[mid]);
        node.left=put(num,low,mid-1);
        node.right=put(num,mid+1,high);
        return node;
    }

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        TreeNode root = sortedArrayToBST(nums);
        System.out.println(root.left.val);

    }
}
