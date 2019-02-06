package leetcode;

public class lc985 {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] rst = new int[queries.length];
        int ans = 0;
        for (int i : A) {
            if ((i & 1) == 0) {
                ans += i;
            }
        }
        int ridx = 0;
        for (int[] query : queries) {
            int val = query[0];
            int idx = query[1];
            // 奇数
            if (((val + A[idx]) & 1) != 0) {
                ans -= A[idx];
                A[idx] += val;
            } else {
                ans += val;
                A[idx] += val;
            }
            rst[ridx++] = ans;

        }
        return rst;
    }
}
