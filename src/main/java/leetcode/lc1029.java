package leetcode;

import java.util.Arrays;

public class lc1029 {

    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> (a[1] - a[0]) - (b[1] - b[0]));
        int n = costs.length;
        int rst = 0;
        for (int i = 0; i < n / 2; i++) {
            rst += costs[i][0];
        }
        for (int i = n / 2; i < n; i++) {
            rst += costs[i][1];
        }
        return rst;
    }
}
