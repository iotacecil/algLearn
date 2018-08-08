package leetcode;

import java.util.Arrays;

public class lc34 {
    public int[] searchRange(int[] nums, int target) {
        //12 333333 456
        int l = 0;
        int r = nums.length-1;
        int[] rst = {-1,-1};
        //1 l=0,r=1 ifnot->l==r break;//l==r==n or ==0
        //1 l=0,r=0 ifnot->l>r break;
        while(l<=r){
            //111 l=0
            int mid = l+((r-l)>>2);
            if(nums[mid]>=target) r=mid-1;
            else l=mid+1;
        }
        System.out.println(l+" "+r);

        if(l>=0&&nums[l]==target) rst[0]=l;
        l = 0;
        r = nums.length;
        while(l<=r){
        //111
            int mid = l+((r-l)>>2);
            if(nums[mid]<=target) l =mid+1;

            else l=mid-1;
        }
        if(l<nums.length&&nums[l]==target) rst[1]=l;
        System.out.println(l+" "+r);

        return rst;
    }

    public static void main(String[] args) {
        lc34 sl = new lc34();
        System.out.println(Arrays.toString(sl.searchRange(new int[]{1,1,1,1,1,1,1,1}, 1)));
    }
}
