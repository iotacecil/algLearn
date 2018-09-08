package gfg;

import leetcode.TreeNode;

import java.util.*;

public class SegmentTree {
    class SegmentTnode{
        public int start,end;
        public SegmentTnode left,right;

        public SegmentTnode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            Queue<SegmentTnode> q = new ArrayDeque<>();
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            q.add(this);
            while (!q.isEmpty()) {
                SegmentTnode top = q.remove();
               sb.append("["+top.start+","+top.end+"]");
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
    public SegmentTnode build(int start,int end){
        if(start>end)return null;
        SegmentTnode root = new SegmentTnode(start,end);
        int left = (start+end)/2;
        int right = left+1;
        if(start!=end){
            root.left = build(start,left );
            root.right = build(right,end);
        }
        return root;
    }

    public static void main(String[] args) {
        SegmentTree sl = new SegmentTree();
        System.out.println(sl.build(1, 4));
    }


}
