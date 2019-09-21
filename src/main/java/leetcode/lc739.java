package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc739 {
    public int[] dailyTemperatures2(int[] T) {
        int n = T.length;
        int[] rst = new int[n];
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && T[i] > T[stk.peek()]) {
                stk.pop();
            }
            rst[i] = stk.isEmpty() ? 0 : stk.peek() - 1;
            stk.push(i);
        }
        return rst;

    }


    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] rst = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j += rst[j]) {
                if (T[j] > T[i]) {
                    rst[i] = j - 1;
                    break;
                } else if (rst[j] == 0) {
                    // j后面没有比j大的，并且j比i小
                    rst[j] = 0;
                    break;
                }
            }

        }
        return rst;
    }
}
