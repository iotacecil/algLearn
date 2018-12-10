//package niuke.dianwoda;
//
//import leetcode.TreeNode;
//
//public class pre_in_tree {
//    class TNode{
//        public TNode left;
//        public TNode right;
//        char val;
//
//        public TNode(char ele) {
//            this.val = ele;
//        }
//    }
//
//    public TNode pre_in_Tree(String pre,String in,int len){
//        if(len < 1){
//            return null;
//        }
//        TNode root = new TNode(pre.charAt(0));
//        int rootidx = 0;
//        while (rootidx < len && in.charAt(rootidx) != root.val){
//            rootidx ++;
//        }
//        String preleft = pre.substring(1 );
//        String prerigt = pre.substring(, )
//        root.left = pre_in_Tree(pre.substring(1),in ,rootidx);
//        root.right = pre_in_Tree(pre.substring(, ),in , )
//
//    }
//    public static void main(String[] args) {
//        String pre = "ACDEFHGB";
//        String in = "DECAHFBG";
//
//    }
//}
