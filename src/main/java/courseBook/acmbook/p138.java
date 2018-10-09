package courseBook.acmbook;

import java.util.Arrays;

public class p138 {
    /**
     * 满足k的最小a的index
     * @param a
     * @param k
     * @return
     */
    public int lower_bound(int[] a ,int k){
        int lb = -1,ub = a.length;
        while (ub-lb>1){
            int mid = (lb+ub)/2;
            if(a[mid]>=k){
                //(lb,mid]
                ub = mid;
            }else{
                //(mid,ub]
                lb = mid;
            }
        }
        return ub;
    }
    public static int upper_bound(int[] a,int k){
        if (a == null || a.length == 0) return -1;
        int lb = -1,ub = a.length;
        while (ub - lb > 1) {
            int mid = (lb+ub)/2;
            if(a[mid]<=k){
                lb = mid;
            }else
                ub = mid;
        }
        return lb;
    }
    public static int upperBound(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int lb = -1, ub = nums.length;
        while (lb + 1 < ub) {
            int mid = lb + (ub - lb) / 2;
            if (nums[mid] > target) {
                ub = mid;
            } else {
                lb = mid;
            }
        }

        return ub - 1;
    }
    public static void main(String[] args) {
        int n = 5;
        int[] a = {2,3,3,5,6};
        int k =4;
        p138 sl = new p138();
        System.out.println(sl.lower_bound(a, k));
        System.out.println(sl.upperBound(a, k));
        System.out.println(Arrays.binarySearch(a, 8));
    }
}
