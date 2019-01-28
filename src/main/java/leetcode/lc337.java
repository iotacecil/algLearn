package leetcode;

import java.util.HashMap;
import java.util.Map;

public class lc337 {

    //dp

    private int[] robdp(TreeNode root){
        if(root == null)return new int[2];
        int[] left = robdp(root.left);
        int[] right = robdp(root.right);
        int[] rst = new int[2];
        // 不偷root
        rst[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        // 偷root
        rst[1] = root.val + left[0] +right[0];
        return rst;
    }

    Map<TreeNode,Integer> map = new HashMap<>();
    public int rob(TreeNode root) {

        if(root == null )return 0;
        if(map.containsKey(root))return map.get(root);
        int sum = 0;


        if(root.left!= null)
            sum+= rob(root.left.left)+rob(root.left.right);

        if(root.right!= null)
            sum+=rob(root.right.left)+rob(root.right.right);
        map.put(root, Math.max(sum + root.val, rob(root.left)+rob(root.right)));
        System.out.println(map.size());
        return Math.max(sum + root.val, rob(root.left)+rob(root.right));
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        System.out.println((new lc337()).rob(root));
    }
}
