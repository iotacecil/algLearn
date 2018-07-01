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

    public static void main(String[] args) {
        lc78 sl  =new lc78();
        sl.subsets(new int[]{1,2,3});
    }

}
