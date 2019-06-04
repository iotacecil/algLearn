package leetcode;

public class lc33 {
//    public int search(int[] nums, int target) {
//        int n = nums.length;
//        if(n < 1)return -1;
//        int l = 0,h = n-1;
//        int roidx = minidx(nums);
//
//        if(target<=nums[n-1]){
//            l = roidx;
//        }else if(roidx != l){
//            h = roidx - 1;
//        }
//        while (l+1 < h){
//            int mid = l +(h-l)/2;
//            if(nums[mid] == target){
//                return mid;
//            }
//            if(nums[mid]<target){
//                l = mid;
//            }else{
//                h = mid;
//            }
//
//        }
//
//        if(nums[h]==target)return h;
//        if(nums[l]==target)return l;
//        return -1;
//
//
//    }
//    private int minidx(int[] nums){
//        int l = 0,n = nums.length,h = n-1;
//        while (l+1 < h){
//            int mid = l+(h-l)/2;
//            if(nums[mid] >= nums[h]){
//                l = mid;
//            }else{
//                h = mid;
//            }
//        }
//        if(nums[l]<nums[h])return l;
//        else return h;
//    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n <1)return -1;
        int l = 0;
        int r = n-1;
        // 3 1
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid] == target)return mid;
            System.out.println(l+" "+r+" "+mid);
            // 旋转点在中位数右侧
            if(nums[mid] > nums[l]){
                if(target < nums[mid] && target >= nums[l]){
                    r = mid-1;
                }else{
                    l = mid+1;
                }
            }
            else {
                //5 1 2 3 4 5 6
                if(target >nums[mid] && target<= nums[r]){
                    l = mid+1;
                }
                else r = mid-1;
            }
            System.out.println(l+" "+r+" "+mid);

        }
        if(nums[l]==target)return l;
        else return -1;
    }
    public static void main(String[] args) {
        int[] nums = {3,1};
        int target = 1;
        lc33 sl = new lc33();
        System.out.println(sl.search(nums, target));
    }
}
