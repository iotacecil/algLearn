package leetcode;

import java.util.HashMap;
import java.util.Map;

public class lc494 {
    //key的编码问题
    Map<String, Integer> map;
          public int findTargetSumWays2(int[] nums, int S) {
 		if (nums == null || nums.length == 0) {
 			return 0;
 		}
 		map = new HashMap<>();
 		return helper(nums, 0, S);
 	}

     	private int helper(int[] nums, int index, int sum) {
 		// 避免数字是重复，无法找到截断点
 		String encodeString = index + "" + sum;
 		if (map.containsKey(encodeString)) {
 			return map.get(encodeString);
 		}
 		if (index == nums.length) {
 			if (sum==0) {
 				return 1;
 			} else {
 				return 0;
 			}
 		}
 		int curNum = nums[index];
 		int res = helper(nums, index + 1, sum - curNum)+helper(nums, index + 1, sum + curNum);
 		map.put(encodeString, res);
            System.out.println(map);
            return res;
 	}
//    Map<String,Integer> m_ = new HashMap<>();
    public int findTargetSumWays(int[] nums, int S) {
        // if (nums.length == 0) return 0;
        map = new HashMap<>();
        return dfs(nums, S, 0);
    }
    private int dfs(int[] nums, int S, int pos){
        String key = pos+""+S;
        if(map.containsKey(key)){
            return map.get(key);
        }
        if(pos == nums.length){
            if(S==0)return 1;
            else return 0;
        }
        int res =dfs(nums, S-nums[pos], pos+1)+dfs(nums, S+nums[pos], pos+1 );
        map.put(key,res);
        System.out.println(map);
        return res;
    }

    public static void main(String[] args) {
        lc494 sl = new lc494();
        sl.findTargetSumWays(new int[]{1, 1, 1, 1, 1},3);
        System.out.println("-------------");
        sl.findTargetSumWays2(new int[]{1, 1, 1, 1, 1},3);

    }
}
