package ltc;

import leetcode.TreeNode;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class lt66 {
//    Logger logger = LoggerFactory.getLogger(lt66.class);
    public List<Integer> preorderTraversalIt2(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        if(root == null){
            return rst;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (true) {
            while (root != null) {
                rst.add(root.val);
                if(root.right != null)
//                    logger.info(root.right.toString());
//                System.out.println(root.right);
                    stack.push(root.right );
                root = root.left;
            }
            if(stack.isEmpty())break;
            System.out.println(stack);
            root = stack.pop();
        }
        return rst;
    }

    public List<Integer> preorderTraversalIt(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        if(root == null){
            return rst;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();

        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode pop = stack.pop();
            rst.add(pop.val);
            if(pop.right != null){
                stack.push(pop.right);
            }
            if(pop.left != null){
                stack.push(pop.left);
            }
        }
        return rst;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode one= new TreeNode(1);
        TreeNode four = new TreeNode(4);

        root.left = one;
        root.right = three;
        one.right = four;
        lt66 sl = new lt66();
        System.out.println(sl.preorderTraversalIt2(root));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        if(root == null){
            return rst;
        }
        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);

        rst.add(root.val);
        rst.addAll(left);
        rst.addAll(right);
        return rst;
    }
}
