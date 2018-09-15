package leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class lc39 {
    /**
     * 按照长度排序
     * @param candidates 没有重复元素的
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSumLenOrder(int[] candidates, int target) {
        List<List<Integer>> rst = new ArrayList<>();

        Set<Integer> set = new HashSet<>();
        for(int i:candidates)set.add(i);
        int[] nums = new int[set.size()];
        int idx =0;
        for(int i:set){
            nums[idx++] = i;
        }
        Arrays.sort(candidates);

        System.out.println(Arrays.toString(nums));
        //最长用第一个元素target/candi[0]次
        for (int i = 1; i <=target/candidates[0] ; i++) {
            dfs(rst,nums,new ArrayList<>(),target,0,0,i);
        }
        return rst;
    }
    private void dfs(List<List<Integer>> rst,int[] candi,List<Integer> tmp,int target,int d,int idx,int len){

        if(d==len){
            if(target==0)rst.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = idx; i <candi.length ; i++) {
            if(candi[i]>target)break;
            tmp.add(candi[i]);
            dfs(rst,candi,tmp,target-candi[i],d+1,i,len);
            tmp.remove(tmp.size()-1);
        }

    }

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> rst = new ArrayList<>();
//            Set<Integer> set = new HashSet<>();
//            for(int i:candidates)set.add(i);
//            int[] nums = new int[set.size()];
//            int idx =0;
//            for(int i:set){
//                nums[idx++] = i;
//            }
        Arrays.sort(candidates);
        help(rst,candidates,target,new ArrayList<>(),0);
        return rst;
    }
    private void help(List<List<Integer>> rst,int[] candi,int target,List<Integer> tmp,int idx){
        if(target<0)return;
            if (target == 0) {
                rst.add(new ArrayList<>(tmp));
                return;
            }

        for (int i = idx ; i <candi.length; i++) {
            //因为排序了，如果之后元素都大则不用向装这个向后找了
            if(candi[i]>target)break;
            if(i>0&&candi[i]==candi[i-1])continue;
                tmp.add(candi[i]);
                //可以使用重复元素则idx,不能重复则idx+1
                help(rst,candi, target-candi[i], tmp,i);
                tmp.remove(tmp.size()-1);
            }
    }

//    public List<List<Integer>> combinationSumDp(int[] cadi,int t){
//        Arrays.sort(cadi);
//        List<List<List<Integer>>> dp = new ArrayList<>();
//        for (int i = 1; i <=t ; i++) {
//            List<List<Integer>> newList = new ArrayList<>();
//            for (int j = 0; j <cadi.length&&cadi[j]<=i ; j++) {
//
//
//            }
//
//
//        }
//    }



    public static void main(String[] args) {
        //有bug
        int[] nums = {1,1,1};
        int[] nums2 = {48,22,49,24,26,47,33,40,37,39,31,46,36,43,45,34,28,20,29,25,41,32,23};
        lc39 sl = new lc39();
        System.out.println(sl.combinationSum(nums, 2));
    }
}
