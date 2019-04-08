package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class lc90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> rst = new ArrayList<>();
        dfs(new ArrayList<>(),rst,nums,0);
        return rst;
    }
    private void dfs(List<Integer> tmp, List<List<Integer>> rst, int[] nums, int idx){
        rst.add(new ArrayList<>(tmp));
        for(int i = idx;i<nums.length;i++){
            if(i!=idx && nums[i] == nums[i-1])continue;
            System.out.println(tmp + " "+idx+" "+nums[i]);
            tmp.add(nums[i]);
            dfs(tmp,rst,nums,i+1);
            tmp.remove(tmp.size()-1);
            Stack<Integer> stk = new Stack<>();
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2};
        lc90 sl = new lc90();
        System.out.println(sl.subsetsWithDup(arr));
    }
}
