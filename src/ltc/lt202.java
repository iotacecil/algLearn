package ltc;

public class lt202 {
    //90%
    public int query(lt439.SegmentTreeNode root, int start, int end) {
        if(root.start>=start&&root.end<=end)return root.max;
        int rst = Integer.MIN_VALUE;
        int mid = (root.start+root.end)/2;
        if(mid>=start)rst = Math.max(rst,query(root.left,start,end));
        if(mid+1<=end)rst = Math.max(rst,query(root.right,start,end));
        return rst;
    }

    //98% 927ms
    public int query2(lt439.SegmentTreeNode root, int start, int end) {
        if(start>end)return 0;
        if(root.start == root.end)return root.max;
        int mid = (root.start+root.end)/2;
        int left = query2(root.left,start,Math.min(mid,end));
        int right  =query2(root.right,Math.max(start,mid+1),end);
        return Math.max(left,right);
    }

        public static void main(String[] args) {
        lt439 sl = new lt439();
        lt439.SegmentTreeNode root = sl.build(new int[]{1, 3, 5, 7,9,11});
        lt202 sl202 = new lt202();
        System.out.println(sl202.query2(root, 0, 4));

    }
}
