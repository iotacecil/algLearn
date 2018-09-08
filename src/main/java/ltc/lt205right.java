package ltc;

import java.util.ArrayList;
import java.util.List;

public class lt205right {

        /*
         * @param A: An integer array
         * @param queries: An query list
         * @return: The result list
         */

        class SegmentTreeNode {
            public int start;
            public int end;
            public int min;
            SegmentTreeNode left;
            SegmentTreeNode right;
            public SegmentTreeNode(int start, int end, int min) {
                this.start = start;
                this.end = end;
                this.min = min;
                this.left = null;
                this.right = null;
            }
        }

        public SegmentTreeNode build(int start, int end, int[] A) {
            if (start > end) {
                return null;
            }

            if (start == end) {
                return new SegmentTreeNode(start, end, A[start]);
            }

            SegmentTreeNode root = new SegmentTreeNode(start, end, A[0]);
            int mid = start + (end - start) / 2;
            root.left = build(start, mid, A);
            root.right = build(mid + 1, end, A);

            root.min = Math.min(root.left.min, root.right.min);
            return root;
        }

        public int query(SegmentTreeNode root, int start, int end) {
            if (start <= root.start && end >= root.end) {
                return root.min;
            }

            int mid = root.start + (root.end - root.start) / 2;
            int ans = Integer.MAX_VALUE;
            if (start <= mid) {
                ans = Math.min(ans, query(root.left, start, end));
            }
            if (end > mid) {
                ans = Math.min(ans, query(root.right, start, end));
            }

            return ans;
        }

        SegmentTreeNode root;
        public List<Integer> intervalMinNumber(int[] A, List<Interval> queries) {
            root = build(0, A.length - 1, A);
            List<Integer> list = new ArrayList<>();

            for (Interval num : queries) {
                int res = query(root, num.start, num.end);
                list.add(res);
            }

            return list;
        }
    }

