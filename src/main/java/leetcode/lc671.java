package leetcode;

import java.util.HashSet;
import java.util.Set;

public class lc671 {
    int min;
    long ans = Long.MAX_VALUE;
    private void dfs(TreeNode root){
        if(root!=null){
            if(min<root.val&&root.val<ans){
                ans = root.val;
            }else if(min ==root.val){
                System.out.println(root.val);
                dfs(root.left);
                dfs(root.right);
            }
        }
    }
    public int findSecondMinimumValue(TreeNode root) {
        min = root.val;
        dfs(root);

        // Set<Integer> uniques = new HashSet<Integer>();
        // dfs(root,uniques);
        // int min1 = root.val;
        // long ans = Long.MAX_VALUE;
        // for(int v:uniques){
        //     if(min1<v&&v<ans)ans = v;
        // }
        return ans<Long.MAX_VALUE?(int) ans:-1;

    }
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        int min = 1;
        int ans = 999;
        for(int v:set){
            if(min<v&&v<ans) ans = v;
        }
        System.out.println(ans);
        lc671 sl = new lc671();
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(7);
        n1.left=n2;
        n1.right=n3;
        n3.left=n4;
        n3.right=n5;
        sl.findSecondMinimumValue(n1);
    }
}
