package leetcode;

import java.util.Arrays;

public class lc34 {


    public  int upper_bound(int[] a,int k){
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
    public  int lowerBound(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int lb = -1, ub = nums.length;
        while (lb + 1 < ub) {
            int mid = lb + (ub - lb) / 2;
            if (nums[mid] >= target) {
                ub = mid;
            } else {
                lb = mid;
            }
        }
        return ub;
    }
    public int[] searchRange(int[] a, int k) {
        if(a==null||a.length<1)return new int[]{-1,-1};
        int first = lowerBound(a, k);
        first = first==a.length||a[first]!=k?-1:first;
        if(first==-1)return new int[]{-1,-1};
        int last = upper_bound(a, k);
        last = last==-1||a[last]!=k?-1:last;
        return new int[]{first,last};
    }

    public static void main(String[] args) {
        lc34 sl = new lc34();
        int[] a = {1,2,2,2,2,2,2,2,5};
        int target = 2;
        System.out.println(Arrays.toString(sl.searchRange(a, target)));


    }
}
