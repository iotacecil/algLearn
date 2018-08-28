package leetcode;

import java.util.ArrayList;
import java.util.List;

public class lc78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        back(rst,new ArrayList<>(),nums,0);
        return rst;
    }
    private void back(List<List<Integer>> rst,List<Integer> item,int[] nums,int index){
        rst.add(new ArrayList<>(item));
        for(int i =index;i<nums.length;i++){
            System.out.println(i);

            item.add(nums[i]);
            back(rst,item,nums,i+1);
            System.out.println("last"+item.get(item.size()-1));
            item.remove(item.size()-1);
        }
    }
    public List<List<Integer>> subsetbit(int[] nums){
        List<List<Integer>> rst = new ArrayList<>();
        for(int i=0;i<(1<<nums.length);i++){
            List<Integer> tmp = new ArrayList<>();
            for(int j =0;j<nums.length;j++){
                if((i&(1<<j))!=0){
                    tmp.add(nums[j]);
                }
            }
            rst.add(new ArrayList<>(tmp));
        }
        return rst;
    }

    public static void main(String[] args) {
        lc78 sl  =new lc78();
        sl.subsets(new int[]{1,2,3});
        System.out.println(sl.subsetbit(new int[]{1, 2, 3}));
    }

}
