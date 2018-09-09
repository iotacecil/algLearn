package ltc;

class SegmentTreeNode {
    public int start, end;
    public SegmentTreeNode left, right;

    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.left = this.right = null;
    }
}
public class lintcode201 {


    public static SegmentTreeNode build(int start, int end) {
        if(start>end)return null;

        SegmentTreeNode st = new SegmentTreeNode(start, end);


        int childl = (start + end) / 2;
        int childr = childl + 1;
        if(start!=end) {
            st.left = build(start, childl);
            st.right = build(childr, end);
        }
        return st;
    }

    public static void main(String[] args) {
        build(0,6);
    }
}
