package ltc;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
//超时
public class lt205 {
    class segMinNode {
        public int start, end, min;
        public segMinNode left, right;
        public segMinNode(int start, int end, int min) {
            this.start = start;
            this.end = end;
            this.min = min;
            this.left = this.right = null; }
        @Override
        public String toString() {
            Queue<segMinNode> q = new ArrayDeque<>();
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            q.add(this);
            while (!q.isEmpty()) {
                segMinNode top = q.remove();
                sb.append("["+top.start+","+top.end+", min="+top.min+"]");
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

    private segMinNode build(int[] A){

        return build(A,0,A.length-1);
    }
    private segMinNode build(int[] A, int start, int end){
        if(start>end)return null;
        if(start==end){return new segMinNode(start,end,A[start]);}
        segMinNode root = new segMinNode(start,end,A[0]);
        int left = (start+end)/2;
        root.left = build(A,start ,left );
        root.right = build(A,left+1,end);
        root.min = Math.min(root.left.min, root.right.min);
        return root;

    }

    private int query(segMinNode root, int start, int end) {
        if(start>end)return Integer.MAX_VALUE;
        if(root.start == root.end)return root.min;
        int mid = (root.start+root.end)/2;
        int left = query(root.left,start,Math.min(mid,end));
        int right  =query(root.right,Math.max(start,mid+1),end);
        return Math.min(left,right);
    }

    public List<Integer> intervalMinNumber(int[] A, List<Interval> queries) {
        segMinNode root = build(A);
        System.out.println(root);
        List<Integer> rst = new ArrayList<>(queries.size());
        System.out.println(query(root,0 ,0 ));
        for(Interval in:queries){
            rst.add(query(root, in.start,in.end ));
        }
        return rst;

    }

    public static void main(String[] args) {
        lt205 sl = new lt205();
//        List<Interval> queries = new ArrayList<>();
//
//        queries.add(new Interval(1,2));
//        queries.add(new Interval(0,4));
//        queries.add(new Interval(2,4));
//        System.out.println(sl.intervalMinNumber(new int[]{1, 2, 7, 8, 5}, queries));
        List<Interval> queries2 = new ArrayList<>();
        queries2.add(new Interval(0,4));
        queries2.add(new Interval(0,0));
        queries2.add(new Interval(3,4));
        queries2.add(new Interval(0,3));
        System.out.println(sl.intervalMinNumber(new int[]{2,3,1,4,5}, queries2));
    }
}
class Interval {
    int start, end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}