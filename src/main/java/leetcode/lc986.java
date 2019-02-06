package leetcode;

import java.util.ArrayList;
import java.util.List;

public class lc986 {
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        List<Interval> ans = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            int lo = Math.max(A[i].start, B[j].start);
            int hi = Math.min(A[i].end, B[j].end);
            if (lo < hi) {
                ans.add(new Interval(lo, hi));
            }
            if (A[i].end < B[j].end) i++;
            else j++;
        }
        return ans.toArray(new Interval[0]);
    }
}
