package leetcode;
///是DFS
import java.util.LinkedList;
import java.util.List;

public class lc107dfs {
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        level(list,root,0);
        return list;
    }
    public static void level(List<List<Integer>> list,TreeNode root ,int level){
        if(root ==null)return;
        if(level>=list.size()){
            list.add(0,new LinkedList<Integer>());

        }
        level(list,root.left,level+1);
        level(list,root.right,level+1);
        System.out.println(list.size()+" "+level);
        list.get(list.size()-level-1).add(root.val);
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
