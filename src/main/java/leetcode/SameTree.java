package leetcode;

public class SameTree {
    public static boolean isSameTree(TreeNode p,TreeNode q){
        if(p == null &&q == null) return true;
        if(p == null || q == null) return false;
        if(p.val==q.val){
            return isSameTree(p.left,q.left)&&
                    isSameTree(p.right,q.right);
        }
        return false;
    }

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

        System.out.println(isSameTree(d,a));

    }
}
