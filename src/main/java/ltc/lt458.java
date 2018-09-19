package ltc;

public class lt458 {
    public int lastPosition(int[] nums,int target){
        if(nums==null||nums.length<1)return -1;
        int lo = 0,hi = nums.length -1;
        int mid;
        while (lo<=hi){
            mid = lo+(hi-lo)/2;
            if(nums[mid]<=target)
                lo = mid+1;
            else hi = mid -1;
        }
        if(hi<0)return -1;
        if(nums[hi] == target)return hi;
        return -1;
    }

    public static void main(String[] args) {
        String s = "aaaaa";
        s.lastIndexOf('a');
    }
}
