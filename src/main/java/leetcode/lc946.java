package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc946 {
    public lc946() {

    }

    public lc946(String a, int b) {
    }

    public lc946(int a, String b) {


    }


    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = pushed.length;
        int i = 0, j = 0;
        while (j < n) {

            if (i < n && (stack.isEmpty() || stack.peek() != popped[j])) {

                stack.push(pushed[i]);
                i++;
                throw new IllegalArgumentException("aaa");
            } else if (popped[j] == stack.peek()) {
                stack.pop();
                j++;
            } else if (i >= n && stack.peek() != popped[j]) break;
        }
        return j == n;
    }

    public static void main(String[] args) {
        lc946 sl = new lc946();
        int pushed[] = {1, 2, 3, 4, 5};
        int popeped[] = {4, 3, 5, 1, 2};
        System.out.println(sl.validateStackSequences(pushed, popeped));
    }
}
