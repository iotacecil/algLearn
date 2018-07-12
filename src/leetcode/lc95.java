package leetcode;

import java.util.ArrayList;
import java.util.List;


public class lc95 {
    private TreeNode clone(TreeNode n,int offset){
        if(n==null) return null;
        TreeNode node =new TreeNode(n.val+offset);
        System.out.println(node);
        node.left = clone(n.left,offset);
        node.right = clone(n.right,offset);
        return node;
    }
//    public List<TreeNode> generateTrees(int n) {
//        List<TreeNode>[] dp = new List[n+1];
//        dp[0] = new ArrayList<>();
//        if(n==0)return dp[0];
//        dp[0].add(null);
//        //节点个数
//        for (int len = 1; len <=n ; len++) {
//            dp[len]=new ArrayList<>();
//            for(int j = 0;j<len;j++){
//                for(TreeNode left:dp[j]){
//                    for(TreeNode right:dp[len-j-1]){
//                        TreeNode node = new TreeNode(j+1);
//                        node.left = left;
//                        node.right = clone(right,j+1);
//                        dp[len].add(node);
//                    }
//                }
//            }
//        }
//        return dp[n];
//    }
    public List<TreeNode> generateTrees(int n) {
        return help(1,n);
    }
    public List<TreeNode> help(int min,int max){
        List<TreeNode> list = new ArrayList<>();
        //i=5,[0,4][5,5]
        if(min>max){
            list.add(null);
            return list;
        }
        if(min==max){
            list.add(new TreeNode(min));
            return list;
        }
        List<TreeNode> left,right;
        for (int i = min; i <=max ; i++) {
            left = help(min,i-1);
            right = help(i+1,max);
            for(TreeNode lnode:left){
                for(TreeNode rnode:right){
                    System.out.println("before");
                    System.out.println(list);
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    list.add(root);
                    System.out.println("after:");
                    System.out.println(list);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        lc95 sl = new lc95();
        System.out.println(sl.generateTrees(3));
    }
}
