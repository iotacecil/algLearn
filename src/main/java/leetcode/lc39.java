package leetcode;

import java.util.ArrayList;
import java.util.List;

public class lc39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> rst = new ArrayList<>();
        dfs(rst,candidates,new ArrayList<>(),target,0);

        return rst;
    }
    //加上start，不能出现322这种重复
    private void dfs(List<List<Integer>> rst,int[] nums,List<Integer> cur,int target,int start){
        if(target<0)return;
        if(target==0){
            rst.add(new ArrayList<>(cur));
        }
        for(int k=start;k<nums.length;k++){
            int i=nums[k];
            cur.add(i);
            target-=i;
            dfs(rst,nums,cur,target,k);
            cur.remove(cur.size()-1);
            target+=i;
        }

    }

    public static void main(String[] args) {
//        int[] candi = {2,3,6,7};
//        int target = 7;
        lc39 sl = new lc39();
//        System.out.println(sl.combinationSum(candi, 7));
        int[] test2 = {2,3,5};
        int target2 = 8;
        System.out.println(sl.combinationSum(test2, target2));

    }
}
