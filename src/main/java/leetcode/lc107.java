package leetcode;

import java.util.*;

/***********************
 3
/ \
9  20
  /  \
 15   7
[
 [15,7],
 [9,20],
 [3]
 ]
***********************/

public class lc107 {
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null){return Collections.emptyList();}
        List<List<Integer>> list = new LinkedList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            List<Integer> sub = new LinkedList<>();
            for(int i =0;i<size;++i){
                TreeNode node = q.remove();
                sub.add(node.val);
                if(node.left!=null){q.add(node.left);}
                if(node.right!=null){q.add(node.right);}
            }
            list.add(0,sub);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode l = new TreeNode(9);
        TreeNode r = new TreeNode(20);
        TreeNode rl = new TreeNode(15);
        TreeNode rr = new TreeNode(7);
        root.left=l;
        root.right=r;
        r.left=rl;
        r.right=rr;
        System.out.println(levelOrderBottom(root));
    }
}
