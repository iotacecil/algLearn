package leetcode;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.Map;

public class lc283 {
    //零少的情况
    public static void moveZero(int[] nums){
        int start = 0;
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]!=0){
                nums[start++]=nums[i];
            }
        }

        while(start<nums.length){
            nums[start++]=0;
        }
    }
    //零多的情况
    public static void moveZeroes(int[] nums) {

        int j = 0;
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]!=0){
                nums[j]=nums[i];
                nums[i]=0;
                j++;
                System.out.println(Arrays.toString(nums));
        }


        }
    }

    public static void main(String[] args) {
        int[]a={0,2,0,3};
        moveZeroes(a);
//        moveZero(a);
        System.out.println(Arrays.toString(a));


    }
}
