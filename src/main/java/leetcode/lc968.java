package leetcode;

public class lc968 {
    int need = 0;
    public int minCameraCover(TreeNode root) {
        dfs(root);
        return need;
    }
    private int dfs(TreeNode root){

        if(root == null)return 2;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if(left == 0 || right == 0){
            need++;
            return 1;
        }
        if(left == 1 ||right == 1)return 2;
        else if(left == 2 &&right == 2)return 0;
        else return 2;
    }

    public int[]solve(TreeNode node){
        if(node == null)return new int[]{0,0,1};
        // left not cover , left cover , left parent covered
        int[] l = solve(node.left);
        int[] r = solve(node.right);
        return new int[]{l[1]+r[1],
                Math.min(l[0]+r[0]+1, Math.min(l[2]+r[1],l[1]+r[2])),
        Math.min(l[0],l[1])+Math.min(r[0],r[1])+1};
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(0);
        node1.left = node2;
        node2.right = node3;
        node2.left = node4;

        lc968 sl = new lc968();
        System.out.println(sl.minCameraCover(node1));
    }
}
