package leetcode;

import sun.reflect.generics.tree.Tree;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class lc104 {
    public static int simuStack(TreeNode root){
        if(root==null)return 0;
        Map<TreeNode,Integer> depthMap = new HashMap<>();
        depthMap.put(root, 1);
        int max = 1;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()){
            root = stack.pop();
            int depth = depthMap.get(root);
            max = Math.max(depth+1, max);
            if(root.left!=null){
                stack.push(root.left);
                depthMap.put(root.left,depth+1 );
            }
            if (root.right != null) {
                depthMap.put(root.right, depth + 1);
                stack.push(root.right);
            }
            depthMap.remove(root);
        }
        return max;
    }

    public static int maxDepthDFS(TreeNode root) {
        if(root==null)return 0;
        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<Integer> value = new ArrayDeque<>();
        stack.push(root);
        value.push(1);
        int max = 0;
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            int tmp = value.pop();
            max = Math.max(tmp, max);
            if(node.left!=null){
                stack.push(node.left);
                value.push(tmp+1);
            }
            if(node.right!=null){
                stack.push(node.right);
                value.push(tmp+1);
            }

        }
        return max;
    }
    public static int maxDepth(TreeNode root) {
       if(root == null)return 0;
        Deque<TreeNode> que = new ArrayDeque<>();
        que.add(root);
        int cnt = 0;
        while (!que.isEmpty()){
            int size = que.size();
            while (size-->0){
                TreeNode cur = que.poll();
                if(cur.left!=null)que.add(cur.left);
                if(cur.right!=null)que.add(cur.right);
            }
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(Double.parseDouble("1E2"));

        Map<Integer,Integer> map = new HashMap<>();
        TreeNode root = new TreeNode(2);
        TreeNode l2l  = new TreeNode(3);
        TreeNode l2r  = new TreeNode(3);
        TreeNode l3   = new TreeNode(4);
        TreeNode l4   = new TreeNode(3);
        TreeNode l5   = new TreeNode(3);
        TreeNode l6   = new TreeNode(4);
        root.left=l2l;
        root.right=l2r;
        l2l.left=l3;
        l2l.right=l4;
        l2r.left=l5;
        l2r.right=l6;

        System.out.println(maxDepth(root));
    }
}
