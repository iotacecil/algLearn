package leetcode;

import java.util.Arrays;

public class lc41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        //  3 4 -1 1-> [0-3]  [1-4]
        //  -1 4 3 1 -> -1 1 3 4
        // nums[i] ==
        int i =0;
        while(i<n){
            if(nums[i]>0 && nums[i]-1<n && i!=nums[i]-1 && nums[nums[i]-1]!=nums[i] ){
                swap(nums,i,nums[i]-1);
            }
            else i++;
        }
        System.out.println(Arrays.toString(nums));
        // [0]=1  0-n-1   1-n
        i =0;
        while(i<n){
            if(i+1!=nums[i])return i+1;
            i++;
        }
        return n;

    }
    private void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1};
        lc41 sl = new lc41();
        System.out.println(sl.firstMissingPositive(arr));
    }
}
