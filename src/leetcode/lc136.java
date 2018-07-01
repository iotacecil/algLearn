package leetcode;

public class lc136 {
    //位运算^

    public static int singleNumber(int[] nums) {
        int fast=0;
        int len =nums.length;
        //[2,2,1]
        int i =0;
        while(i<len-1){
            int last = i;
            fast=i+1;
            while(i<len-1&&fast<len){
//                System.out.println(i+" "+fast);
                if(nums[i]==nums[fast]){
//                    System.out.println(nums[i]);
                    i++;fast++;

                }
                else{
                    fast++;
                }
            }
            if(i==last)break;
        }
        return nums[i];
    }


    public static void main(String[] args) {
        int[] nums = {2,2,1};
        System.out.println(singleNumber(nums));
        System.out.println(12^12);
    }
}
