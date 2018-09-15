package leetcode;

import java.util.*;

public class lc40 {
    public List<List<Integer>> combinationSum2Set(int[] candidates, int target) {
        Set<List<Integer>> rst = new HashSet<>();
        Arrays.sort(candidates);
        dfs(rst,candidates,target,new ArrayList<>(),0);
        return new ArrayList<>(rst);
    }
    private void dfs(Set<List<Integer>> rst,int[] candi,int target,List<Integer> tmp,int idx){
        if(target<0)return;
        if (target == 0) {
            rst.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = idx ; i <candi.length; i++) {
            //因为排序了，如果之后元素都大则不用向装这个向后找了
            if(candi[i]>target)break;
            if(i>idx&&candi[i]==candi[i-1])continue;
            tmp.add(candi[i]);
            //可以使用重复元素则idx,不能重复则idx+1
            dfs(rst,candi, target-candi[i], tmp,i+1);
            tmp.remove(tmp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;

    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candi = {10,1,2,7,6,1,5};
        int target = 8;
        lc40 sl = new lc40();
        System.out.println(sl.combinationSum2(candi, target));
    }
}
