package ltc;

import gfg.SegmentTree;

import java.util.ArrayDeque;
import java.util.Queue;

public class lt439 {
class SegmentTreeNode {
    public int start, end, max;
    public SegmentTreeNode left, right;
    public SegmentTreeNode(int start, int end, int max) {
    this.start = start;
    this.end = end;
    this.max = max;
    this.left = this.right = null; }
    @Override
    public String toString() {
        Queue<SegmentTreeNode> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        q.add(this);
        while (!q.isEmpty()) {
            SegmentTreeNode top = q.remove();
            sb.append("["+top.start+","+top.end+", max="+top.max+"]");
            if (top.left != null) {
                q.add(top.left);}
            if (top.right != null) {
                q.add(top.right);
            }
        }
        sb.append("]");
        return sb.toString();

    }
}

    public SegmentTreeNode build(int[] A){

        return build(A,0,A.length-1);
    }
    private SegmentTreeNode build(int[] A,int start,int end){
        if(start==end){return new SegmentTreeNode(start,end,A[start]);}
        SegmentTreeNode root = new SegmentTreeNode(start,end,Integer.MIN_VALUE);
        int left = (start+end)/2;
        root.left = build(A,start ,left );
        root.right = build(A,left+1,end);
        root.max = Math.max(root.left.max, root.right.max);
        return root;

    }
    public static void main(String[] args) {
        lt439 sl = new lt439();
        System.out.println(sl.build(new int[]{3, 2, 1, 4}));
    }
}
