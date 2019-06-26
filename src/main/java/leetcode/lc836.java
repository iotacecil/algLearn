package leetcode;

public class lc836 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // 2在1 左边 rec2的最大x<=rec1的最小x
        // 2在1 右边 rec2 minx >= rec1 maxx
        // 2在1 上面  rec2 miny >= rec1 maxy
        // 2在1 下面
        boolean b = rec1[2] <= rec1[0] || rec2[0] >= rec1[0]
                || rec2[1] >= rec1[3] || rec2[3] <= rec1[1];
        return !b;
    }

    public static void main(String[] args) {

    }
}
