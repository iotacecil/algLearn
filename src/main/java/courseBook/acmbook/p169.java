package courseBook.acmbook;

import java.util.ArrayDeque;
import java.util.Queue;
class segMaxTree {



    class SegmentTreeNode {
        public int start, end, max;
        public SegmentTreeNode left, right;

        SegmentTreeNode(int start, int end, int max) {
            this.start = start;
            this.end = end;
            this.max = max;
            this.left = this.right = null;
        }

        @Override
        public String toString() {
            Queue<SegmentTreeNode> q = new ArrayDeque<>();
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            q.add(this);
            while (!q.isEmpty()) {
                SegmentTreeNode top = q.remove();
                sb.append("[" + top.start + "," + top.end + ", max=" + top.max + "]");
                if (top.left != null) {
                    q.add(top.left);
                }
                if (top.right != null) {
                    q.add(top.right);
                }
            }
            sb.append("]");
            return sb.toString();

        }
    }

    public SegmentTreeNode build(int[] A) {

        return build(A, 0, A.length - 1);
    }

    private SegmentTreeNode build(int[] A, int start, int end) {
        if (start == end) {
            return new SegmentTreeNode(start, end, A[start]);
        }
        SegmentTreeNode root = new SegmentTreeNode(start, end, Integer.MIN_VALUE);
        int left = (start + end) / 2;
        root.left = build(A, start, left);
        root.right = build(A, left + 1, end);
        root.max = Math.max(root.left.max, root.right.max);
        return root;

    }
    public int query(SegmentTreeNode root,int start,int end){
        if(start>end)return 0;
        if(root.start==root.end)return root.max;
        int mid = (root.start+root.end)/2;
        //分割当前查询区间，如果和左边有交集，则查找左边最大值
        int left = query(root.left,start,Math.min(mid,end));
        //mid = 4,query(5,4)
        int right = query(root.right,Math.max(start,mid+1),end);
        return Math.max(left,right);
    }
}

public class p169 {

    public static void main(String[] args) {
        int[] num = {5,3,7,9,6,4,1,2};
        segMaxTree st = new segMaxTree();

        System.out.println(st.query(st.build(num), 0, num.length));

    }
}
