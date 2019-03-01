package leetcode;

import java.util.HashMap;

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

    public int pathSum(TreeNode root, int sum) {
        // key:前缀和 value：有多少种方式可以得到这个值
        HashMap<Integer,Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        return helper(root,0,sum,preSum);
    }
    int helper(TreeNode root,int currSum,int target,HashMap<Integer,Integer> preSum){
        if(root == null)return 0;
        currSum += root.val;
        int rst = preSum.getOrDefault(currSum - target,0);
        preSum.put(currSum, preSum.getOrDefault(currSum,0)+1);
        rst += helper(root.left,currSum,target,preSum)+helper(root.right,currSum,target,preSum);
        preSum.put(currSum,preSum.get(currSum)-1);
        return rst;
    }

}
