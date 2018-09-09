package leetcode;

class Solution8 {
    public int searchInsert(int[] nums, int target) {
        int position=0;
        while(position<nums.length&&nums[position]<target){

            position++;

        }

        return position;
    }
}
public class SIP {
    public static void main(String[] args){
        int[] nums= {1,3,5,6};
        int target= 7;
        Solution8 sl = new Solution8();
        System.out.println(sl.searchInsert(nums,target));
    }
}
