package leetcode;

public class lc410 {
    /** 数组 分成m分 sum最大
     * nums = [7,2,5,10,8]
     m = 2
     * @param nums
     * @param m
     * @return
     */
    public int splitArray(int[] nums, int m) {
        int max = 0;long sum = 0;
        for(int num:nums){
            max = Math.max(num,max );
            sum+=num;
        }
        if(m==1)return (int)sum;
        long l = max,r = sum;
        while (l<=r){
            long mid = (l+r)/2;
            //用这个最小值能不能划分成m组 可以更小一点
            if(valid(mid,nums ,m )){
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }

    return (int)l;
    }
    private boolean valid(long target,int[] nums,int m){
        int cnt =1;
        long total = 0;
        for(int num:nums){
            total += num;
            if(total>target){
                total = num;
                //需要一个新的分组
                cnt++;
                if(cnt> m)return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,2,5,10,8};
        int m = 2;
        lc410 sl = new lc410();
        System.out.println(sl.splitArray(nums, 2));
    }
}
