package leetcode;

import java.util.*;

public class lc403 {
    Thread s = new Thread();

    public boolean canCross(int[] stones) {
        System.out.println(s.getStackTrace());
        int n = stones.length;
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            map.put(stones[i],new HashSet<>());
        }
        map.get(0).add(1);
        for(int i = 0;i<n;i++){
            for(int step:map.get(stones[i])){
                int nxt = stones[i]+step;
                if(nxt == stones[n-1])return true;
                if(map.containsKey(nxt)){
                    Set<Integer>steps = map.get(nxt);
                    steps.add(step);
                    if(step-1>0)
                        steps.add(step-1);
                    steps.add(step+1);
                }
            }
        }
        return map.get(stones[n-1]).size()>0;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,3,5,6,8,12,17};
        lc403 sl = new lc403();
        System.out.println(sl.canCross(arr));
    }
}
