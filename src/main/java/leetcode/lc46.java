package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc46 {
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> rst = new ArrayList<>();

//        help(rst,new ArrayList<>(),nums);
        help2(rst,0,nums);
        return rst;
    }
    //每次减少一位2^n 可以简化为n!
    private void help(List<List<Integer>> rst,List<Integer> tmp,int[] nums){
        if(tmp.size()==nums.length){
//            System.out.println(tmp);
            rst.add(tmp);
//            System.out.println(rst);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(tmp.contains(nums[i]))continue;
            tmp.add(nums[i]);
            help(rst,tmp,nums);
            tmp.remove(tmp.size()-1);
        }
    }

    private void help2(List<List<Integer>> rst  ,int s,int[] nums){
        if(s==nums.length) {
            List<int[]> ints = Arrays.asList(nums);
            List<Integer> tmp = new ArrayList<>();
            for(int num:nums){
                tmp.add(num);
            }
            rst.add(tmp);
            System.out.println(rst);
        }
        for(int i =s;i<nums.length;i++)
        {
            swap(nums,s,i);
            //StackOverflowError
//            help2(rst,s++,nums);
            System.out.println("before: s:"+s+" i:"+i);
            help2(rst,s+1,nums);
            System.out.println("after: s:"+s+" i:"+i);
            swap(nums,s,i);

        }

    }

    private void swap(int[] nums,int i ,int j){
        int tmp = nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }

    public static void main(String[] args) {
        lc46 sl = new lc46();
        System.out.println(sl.permute(new int[]{1, 2, 3}));
    }
}
