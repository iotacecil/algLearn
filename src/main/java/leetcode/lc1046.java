package leetcode;

import java.util.Arrays;

public class lc1046 {
    public int lastStoneWeight(int[] stones) {

        int n = stones.length;
        int i = n - 2;
        int j = n - 1;
        while (true) {
            Arrays.sort(stones);
            System.out.println(stones);
            if (i < 0 || stones[i] == 0) break;
            if (stones[i] == stones[j]) {
                stones[i] = 0;
                stones[j] = 0;
            } else {
                stones[j] = stones[j] - stones[i];
                stones[i] = 0;

            }
        }
        return stones[j];
    }

}
