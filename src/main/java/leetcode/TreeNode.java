package leetcode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode implements Cloneable{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x){
        val = x;
    }
//    StringBuilder str = new StringBuilder(val+" ");

//    public String toString(){
//        try{
//        while (left!=null||right!=null) {
//            str.append(left.val+" ");
//            str.append(right.val+" ");
//            if(left!=null) {
//                left = left.left;
//                right = left.right;
//            }else if(right!=null){
//                left=right.left;
//                right=left.right;
//            }
//        }
//        }
//        catch (Exception ex){
//            //全局日志记录器
////            Logger.getGlobal().info(()->ex.getMessage());
//            Logger logger = Logger.getLogger("getLogger");
//            logger.info(()->ex.toString());
////            try {
////                FileHandler handler = new FileHandler();
////                logger.addHandler(handler);
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
//
//        }
//        return str.toString();

//    }

//    public Iterable levelOrder() {
//        Queue keys = new ArrayDeque<>();
//
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        queue.add(this);
////        System.out.println(queue);
//        while (!queue.isEmpty()) {
//            TreeNode x = queue.remove();
//            if (x == null) {
//                continue;
//            }
//            keys.add(x.val);
//            if (x.left != null)
//                queue.add(x.left);
//            if (x.right != null)
//                queue.add(x.right);
//        }
//        return keys;
//    }
    @Override
    public String toString(){
        Queue<TreeNode> q = new ArrayDeque<>();
        List<Integer> list = new LinkedList<>();
        q.add(this);
        while (!q.isEmpty()) {
            TreeNode top = q.remove();
            list.add(top.val);
            if (top.left != null) {
                q.add(top.left);}
                if (top.right != null) {
                    q.add(top.right);
                }
            }

        return list.toString();
    }
    @Override
    public Object clone(){
        TreeNode newT = null;
        try{
            newT = (TreeNode)super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return newT;
    }

}
