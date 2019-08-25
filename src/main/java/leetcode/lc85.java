package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc85 {
    public int maximalRectangle2(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int n = matrix.length, m = matrix[0].length;
        int[] row = new int[m];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    row[j]++;
                } else {
                    row[j] = 0;
                }
            }
            max = Math.max(max, largestRectangleArea(row));
        }
        return max;
    }

    // 直方图最大矩形
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stk = new ArrayDeque<>();
        int n = heights.length;
        int rst = 0;
        stk.push(-1);
        for (int i = 0; i < n; i++) {
            while (stk.peek() != -1 && heights[i] <= heights[stk.peek()]) {
                int h = heights[stk.pop()];
                int left = stk.peek();
                int w = i - 1 - left;
                rst = Math.max(rst, w * h);
            }
            stk.push(i);
        }

        while (stk.peek() != -1) {
            int h = heights[stk.pop()];
            int left = stk.peek();
            int w = n - 1 - left;
            rst = Math.max(rst, w * h);
        }
        return rst;
    }
}
