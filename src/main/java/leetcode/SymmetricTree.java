package leetcode;

public class SymmetricTree {
//    public static boolean isSymmetric(TreeNode root) {
//        StringBuilder a = new StringBuilder();
//    }
    public static void main(String[] args) {
        TreeNode a= new TreeNode(10);
        TreeNode b= new TreeNode(5);
        TreeNode c= new TreeNode(15);
        a.left=b;
        a.right=c;
        TreeNode d = new TreeNode(10);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(15);
        d.left=e;

//        System.out.println(isSymmetric(a));

    }
}
