package gfg;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LCA {
    TreeNode lcaBST(TreeNode root,TreeNode p,TreeNode q){
        if(root== null)return null;
        if(root.val>p.val&&root.val>q.val)return lcaBST(root.left,p ,q );
        if(root.val<p.val&&root.val<q.val)return lcaBST(root.right,p ,q );
        return root;
    }
    boolean v1 = false;
    boolean v2 = false;
    TreeNode findLCAnoab(TreeNode root,TreeNode p,TreeNode q) {
        if(root == null)return null;
        if(root.val==p.val){
            v1 = true;
            return root;
        }
        if(root.val == q.val){
            v2 = true;
            return root;
        }
        TreeNode left = findLCAnoab(root.left, p, q);
        TreeNode right = findLCAnoab(root.right, p, q);
        return (left!=null)?left:right;
    }
    boolean find(TreeNode root,TreeNode k){
        if(root == null)return false;
        if(root.val==k.val||find(root.left,k )||find(root.right,k ))return true;
        return false;
    }
    TreeNode findLCAnoAbsent(TreeNode root,TreeNode p,TreeNode q) {
        TreeNode lcAnoab = findLCAnoab(root, p, q);
        if(v1&&v2||v1&&find(lcAnoab,q )||v2&&find(lcAnoab, p))return lcAnoab;
        return null;
    }


    TreeNode findLCA(TreeNode root,TreeNode p,TreeNode q){
        if(root==null)return null;
        if(root.val ==p.val||root.val ==q.val)return root;
        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);
        if(left!=null&&right!=null)return root;
        return (left!=null)?left:right;



    }
    int findLCA(TreeNode root,int a,int b){
        List<Integer> patha = new ArrayList<>();
        List<Integer> pathb = new ArrayList<>();
        if(!findPath(root,a ,patha)||!findPath(root,b ,pathb)){
            return -1;
        }
        System.out.println(patha);
        System.out.println(pathb);
        int i;
        //root->1->3
        //root->1->3->6
        for(i=0;i<patha.size()&&i<pathb.size();i++){
            if(!patha.get(i).equals(pathb.get(i)))break;
        }
        return patha.get(i-1);
    }
    private boolean findPath(TreeNode root,int n,List<Integer> path){
        if(root== null)return false;
        path.add(root.val);
        if(root.val==n)return true;
        if(root.left!=null&&findPath(root.left, n,path ))return true;
        if(root.right!=null&&findPath(root.right, n,path ))return true;
        path.remove(path.size()-1);
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        root.left = two;
        root.right = three;
        root.left.left = four;
        root.left.right = five;
        root.right.left = six;
        root.right.right = seven;
        LCA sl = new LCA();
        TreeNode eight = new TreeNode(8);
        System.out.println(sl.findLCA(root, 4, 5));
        System.out.println(sl.findLCA(root, four, five).val);
        System.out.println(sl.findLCAnoAbsent(root, four, eight));

    }
}
