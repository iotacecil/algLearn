package leetcode;

public class lc427 {
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
        }

        public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }

    ;

    public Node construct(int[][] grid) {
        return build(0, 0, grid.length - 1, grid.length - 1, grid);
    }

    private Node build(int x1, int y1, int x2, int y2, int[][] g) {
        if (x1 > x2 || y1 > y2) return null;
        boolean isLeaf = true;
        int val = g[x1][y1];
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j < y2; j++) {
                if (g[i][j] != val) {
                    isLeaf = false;
                    break;
                }
            }
        }

        if (isLeaf) {
            return new Node(val == 1, true, null, null, null, null);
        }
        int xmid = (x1 + x2) / 2;
        int ymid = (y1 + y2) / 2;
        return new Node(false, false,
                build(x1, y1, xmid, ymid, g),
                build(x1, ymid + 1, xmid, y2, g),
                build(xmid + 1, y1, xmid, ymid, g),
                build(xmid + 1, ymid + 1, xmid, y2, g));
    }

}
