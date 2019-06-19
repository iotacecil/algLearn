package leetcode;

public class lc33 {
    public int search(int[] nums, int target) {
        int roidx = minidx(nums);

        int n = nums.length;
        if(n < 1)return -1;
        int l = 0,h = n-1;

        if(target<=nums[n-1]){
            l = roidx;
        }else if(roidx != l){
            h = roidx - 1;
        }
        // mid == 3 target = 1
        while (l < h) {
            int mid = l +(h-l)/2;
            // System.out.println(l+" "+h+" "+mid);
            if(nums[mid] == target){

                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }else{
                h = mid;
            }

        }
        return nums[h] == target ? h : -1;


    }
    private int minidx(int[] nums){

        int l = 0,n = nums.length,h = n-1;
        while (l < h) {

            int mid = l+(h-l)/2;
            if (nums[mid] > nums[h]) {
                l = mid + 1;
            }else{
                h = mid;
            }
        }
        return l;
    }


    public static void main(String[] args) {
        int[] nums = {3, 1};
        int target = 1;
        lc33 sl = new lc33();
        System.out.println(sl.search(nums, target));
    }
}
