package leetcode;

import java.util.ArrayList;
import java.util.List;

//todo
public class lc95 {

//    public List<TreeNode> generateTreesdfs(int n) {
//
//        return dfs(1,n);
//
//    }
//    private List<TreeNode> dfs(int l,int r){
//        List<TreeNode> rst = new ArrayList<>();
//        if(l>r){
//            rst.add(null);
//            return rst;
//        }
//        for (int i = l; i <r ; i++) {
//            List<TreeNode> left= dfs(l,i-1 );
//
//        }
//
//    }

    private TreeNode clone(TreeNode n,int offset){
        if(n==null) return null;
        TreeNode node =new TreeNode(n.val+offset);
        System.out.println(node);
        node.left = clone(n.left,offset);
        node.right = clone(n.right,offset);
        return node;
    }
    public List<TreeNode> generateTreesdp(int n) {
        List<TreeNode>[] dp = new List[n+1];
        dp[0] = new ArrayList<>();
        if(n==0)return dp[0];
        dp[0].add(null);
        //节点个数
        for (int i = 1; i <=n ; i++) {
            dp[i]=new ArrayList<>();
            for(int j = 0;j<i;j++){
                for(TreeNode left:dp[j]){
                    for(TreeNode right:dp[i-j-1]){
                        TreeNode node = new TreeNode(j+1);
                        node.left = left;
                        node.right = clone(right,j+1);
                        dp[i].add(node);
                    }
                }
            }
        }
        return dp[n];
    }
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
