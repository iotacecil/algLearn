package leetcode;

import java.util.Arrays;

public class lc167 {

        public static int[] twoSum(int[] numbers, int target) {
            if(numbers==null||numbers.length<2) {
                return new int[]{-1, -1};
            }
            int left = 0;int right = numbers.length-1;
            while(left<right){
                int sum = numbers[left]+numbers[right];
                if(sum==target){
                    return new int[]{left+1,right+1};
                }
                else if(sum>target) {
                    right--;
                } else {
                    left++;
                }
            }
            return new int[]{-1,-1};

        }


    public static void main(String[] args) {
        int[] a= {1,2,3,4,5};
        System.out.println(Arrays.toString(twoSum(a, 5)));

    }



}
