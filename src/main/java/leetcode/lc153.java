package leetcode;

public class lc153 {
    /**
     * 二分查找 O(logN)找到排序rotate数组的最小值

     * @param nums  [biger] [max][min] [smaller] [3,4,  5, 1,  2]
     * @return
     */
    public int findMin(int[] nums) {
        if(nums.length==1)return nums[0];
        return findMin(nums,0,nums.length-1);
    }
    private int findMin(int[] nums,int low,int hi){
        //只有1个或者2个
        if(low+1>=hi)return Math.min(nums[low],nums[hi]);
        if(nums[low]<nums[hi])return nums[low];
        int mid = low+(hi-low)/2;
        //无缝
        return Math.min(findMin(nums,low,mid-1),findMin(nums,mid ,hi));

    }

    public static void main(String[] args) {
        lc153 sl = new lc153();
        System.out.println(sl.findMin(new int[]{3, 4, 5, 1, 2}));
    }
}
