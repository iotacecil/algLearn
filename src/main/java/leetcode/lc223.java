package leetcode;

import java.util.*;

/*
-1500000001
0
-1500000000
1
1500000000
0
1500000001
1
 */
public class lc223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        //def computeArea(self, A, B, C, D, E, F, G, H):
        //overlap = max(min(C,G)-max(A,E), 0)*max(min(D,H)-max(B,F), 0)
        // return (A-C)*(B-D) + (E-G)*(F-H) - overlap
        int x = 0;
        if (Math.min(C, G) > Math.max(A, E)) {
            x = Math.min(C, G) - Math.max(A, E);
        }
        ;

        int y = 0;
        if (Math.min(D, H) > Math.max(B, F)) {
            y = Math.min(D, H) - Math.max(B, F);
        }


        return (int) ((D - B) * (C - A) + (G - E) * (H - F) - x * y);

    }

    public static void main(String[] args) {
        lc223 sl = new lc223();


        System.out.println(sl.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));

        //   System.out.println(sl.computeArea(-1500000001, 0, -1500000000, 1, 1500000000, 0, 1500000001, 1));
    }


    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        // 最小堆

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> e : cnt.entrySet()) {


            if (pq.size() >= k) {
                if (e.getValue() > pq.peek().getValue()) {
                    pq.poll();

                } else continue;
            }
            pq.add(e);
        }
//        System.out.println(pq);

        List<Integer> rst = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            rst.add(0, pq.poll().getKey());
        }
        return rst;


    }

}
