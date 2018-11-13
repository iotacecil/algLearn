package leetcode;

public class lc162 {
    public int findPeakElement(int[] nums) {
        int l = 0,n = nums.length,h = n-1;
        while(l<h){
            System.out.println(l+" "+h);
            int mid = l+(h-l)/2;
            if(mid>0 && nums[mid] - nums[mid - 1] >0){
                l = mid+1;
            }else{
                h = mid;
            }
        }
        return l;
    }
    public static void main(String[] args) {
        int[] nums = {3,2,1,1,1};
        lc162 sl = new lc162();
        System.out.println(sl.findPeakElement(nums));
    }
}
