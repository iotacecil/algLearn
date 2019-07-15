package leetcode;


import java.util.ArrayDeque;
import java.util.Deque;

public class lc42 {

    public int trap(int[] A) {
        if (A == null) return 0;
        Deque<Integer> stk = new ArrayDeque<>();
        int i = 0, max = 0, tmp = 0;
        while (i < A.length) {
            if (stk.isEmpty() || A[i] <= A[stk.peek()]) {
                stk.push(i++);
            } else {
                // 取出每个坑，当前这个高的会在下一次入栈
                int top = stk.pop();
                if (stk.isEmpty())
                    tmp = 0;
                else {
                    tmp = (Math.min(A[stk.peek()], A[i]) - A[top]) * (i - stk.peek() - 1);
                    //if(i>3)
                    //System.out.println(stk.peek()+" "+A[stk.peek()]+" "+A[top]);
                    max += tmp;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        lc42 sl = new lc42();
        System.out.println(sl.trap(new int[]{2, 1, 0, 1, 3}));
    }


}
