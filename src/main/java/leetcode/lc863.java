package leetcode;

import java.util.Map;

public class lc863 {
    public static void main(String[] args) {
        lc863 sl = new lc863();

        System.out.println(sl.getClass().getClassLoader().getResource("").toString());
    }
    Map<TreeNode,TreeNode> map;
//    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
//        map = new HashMap<>();
//        // parent map
//        dfs(root,null);
//
//    }

    public void dfs(TreeNode node,TreeNode par){
        if(node != null){
            map.put(node, par);
            dfs(node.left,node);
            dfs(node.right,node);
        }
    }

}
