package leetcode;
class Solution6 {
    public int removeElement(int[] nums, int val) {
    int cnt=0;
    for(int i =0;i<nums.length;i++){
        if(nums[i]!=val)nums[cnt++]=nums[i];
    }
    return cnt;
    }
}

public class removeE {
    public static void main(String[] args){
        Solution6 sl = new Solution6();
        int[] nums = new int[]{1,2,2,4,5};
        System.out.println(sl.removeElement(nums,2));
    }
}
