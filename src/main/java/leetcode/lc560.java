package leetcode;

import java.util.HashMap;
import java.util.Map;

public class lc560 {
    public int subarraySum(int[] nums, int k) {
        int psum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int cnt =0;
        for(int i =0;i<nums.length;i++){
            psum += nums[i];
            cnt += map.getOrDefault(psum - k,0);
            map.put(psum,map.getOrDefault(psum,0)+1);
        }
        return cnt;
    }
}
