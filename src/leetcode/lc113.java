package leetcode;

import java.util.ArrayList;
import java.util.List;

public class lc113 {
    List<List<Integer>> rst = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null)return rst;
        List<Integer> path = new ArrayList<>();
        preorder(sum,path,root);

        return rst;

    }
    private void preorder(int sum,List<Integer> path,TreeNode node){
        if(node == null)return;
        path.add(node.val);
        if(sum == node.val &&node.left==null&&node.right==null){
            rst.add(new ArrayList<>(path));
        }
        if(node.left!=null)preorder(sum-node.val,path,node.left);
        if(node.right!=null)preorder(sum-node.val,path,node.right);
        path.remove(path.size()-1);

    }
}
