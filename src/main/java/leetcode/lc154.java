package leetcode;

public class lc154 {

    public int findMin2(int[] nums){
        int s = -1, e = nums.length-1;
        while (s+1<e){
            int mid = (s+e)/2;
            if(nums[mid]>nums[e]){
              s = mid;
            }else if(nums[mid]<=nums[e]){
                e = mid;
            }

        }
        return Math.min(nums[s],nums[e] );
    }
    /**
     *
     * @param nums 有重复元素 222232 22222
     * @return
     */
    public int findMin(int[] nums) {
        if(nums.length==1)return nums[0];
        return findMin(nums,0,nums.length-1);
    }
    private int findMin(int[] nums,int low,int hi){
        //只有1个或者2个
        if(low+1>=hi)return Math.min(nums[low],nums[hi]);
//        if(nums[low]<nums[hi])return nums[low];
        int mid = low+(hi-low)/2;
        //无缝
        return Math.min(findMin(nums,low,mid-1),findMin(nums,mid ,hi));

    }

    public static void main(String[] args) {
        lc154 sl = new lc154();
        System.out.println(sl.findMin(new int[]{2, 2, 2, 2, 2, 3, 2}));
    }
}
