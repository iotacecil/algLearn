package leetcode;

import java.util.Arrays;

public class lc2150903 {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int l = 0,r = n-1;
        k--;
        //尝试把r放到哪个位置 从大到小
        while(l<r){
            int idx = quickSelect(nums,l,r);
           System.out.println(r+" "+idx);
            System.out.println(Arrays.toString(nums));
            System.out.println(l+" "+r+" "+k);
            if(idx==k) {
                return nums[idx];
            }else if(idx>k){
                r = idx-1;

            }else {
                 l = idx+1;
            }

        }
        return nums[k];

    }

    private int quickSelect(int[] arr,int left,int right){
        int l = left-1;
        int r = right;
        int pvt = arr[right];
        while(l<r){
            while(++l<r && arr[l]>=pvt);
            while(--r>l && arr[r]<=pvt);
            if(l<r){
                swap(arr,l,r);
            }else{
                swap(arr,right,l);
               // System.out.println(l+" right:"+r);
                break;
            }
        }
        return l;



    }

    private void swap(int[]arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {

        int[] arr = {3,2,3,1,2,4,5,5,6};
        lc2150903 sl = new lc2150903();
        System.out.println(sl.findKthLargest(arr, 4));
    }
}
