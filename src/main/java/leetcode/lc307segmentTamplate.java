package leetcode;

public class lc307segmentTamplate {
    class SegmentTreeNode {
        int start, end;
        SegmentTreeNode left, right;
        int sum;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }

    SegmentTreeNode root = null;
    private SegmentTreeNode build(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        } else {
            SegmentTreeNode ret = new SegmentTreeNode(start, end);
            if (start == end) {
                ret.sum = nums[start];
            } else {
                int mid = start  + (end - start) / 2;
                ret.left = build(nums, start, mid);
                ret.right = build(nums, mid + 1, end);
                ret.sum = ret.left.sum + ret.right.sum;
            }
            return ret;
        }
    }
    public int query(SegmentTreeNode root, int start, int end) {
        if (root.end == end && root.start == start) {
            return root.sum;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (end <= mid) {
                return query(root.left, start, end);
            } else if (start >= mid+1) {
                return query(root.right, start, end);
            }  else {
                return query(root.right, mid+1, end) + query(root.left, start, mid);
            }
        }
    }
    void modify(SegmentTreeNode root, int pos, int val) {
        if (root.start == root.end) {
            root.sum = val;
        } else {
            int mid = (root.end + root.start) / 2;
            if (pos <= mid) {
                modify(root.left, pos, val);
            } else {
                modify(root.right, pos, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }

    public lc307segmentTamplate(int[] nums) {
        root = build(nums, 0, nums.length-1);
    }
    void update(int i, int val) {
        modify(root, i, val);
    }
    public int sumRange(int i, int j) {
        return query(root, i, j);
    }

}
