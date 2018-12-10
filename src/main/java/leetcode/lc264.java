package leetcode;

import java.util.PriorityQueue;

public class lc264 {
    //1, 2, 3, 4, 5, 6, 8, 9, 10, 12
    public int nthUglyNumber(int n) {
        if(n == 1)return 1;
        PriorityQueue<Long> que =new PriorityQueue<>(n);
        que.add(1l);
        for (int i = 1; i <n ; i++) {
            long tmp = que.poll();
            // 重复元素
            while (!que.isEmpty() && que.peek() == tmp)tmp = que.poll();

            que.add(tmp * 2);
            que.add(tmp * 3);
            que.add(tmp * 5);
        }
        return que.poll().intValue();
    }

    public static void main(String[] args) {
        lc264 sl = new lc264();
        System.out.println(sl.nthUglyNumber(10));
    }
}
