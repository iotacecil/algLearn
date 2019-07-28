package leetcode;


import java.util.ArrayList;
import java.util.List;

public class lc662 {
    public int widthOfBinaryTree(TreeNode root){
        return dfs(root,0,1,new ArrayList<Integer>(),new ArrayList<Integer>());
    }
    // leftmost node and rightmost node in each level,
    public int dfs(TreeNode root, int level, int num, List<Integer> start, List<Integer> end){
        if(root == null)return 0;
        // 同一行更左的肯定先访问，先记录到start和end
        if(start.size() == level){
            start.add(num);
            end.add(num);
        }else end.set(level,num);
        int cur = end.get(level) - start.get(level)+1;
        int left = dfs(root.left,level+1,2*num,start,end);
        int right = dfs(root.right,level+1,2*num + 1,start,end);
        return Math.max(cur, Math.max(left, right));
    }

    public static void main(String[] args) {

    }
}
