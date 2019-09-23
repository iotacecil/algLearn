package leetcode;

public class lc4100905 {
    private boolean can(int[] nums,int m,long max){
        int cut = 1;
        long tmp = 0;
        for(int i = 0;i<nums.length;i++){
            if(tmp + nums[i] <= max){
                tmp += nums[i];
            }else {
                tmp = nums[i];
                cut++;
                if(cut > m )return false;
            }
        }
        // System.out.println(cut);
        return true;
    }

    public int splitArray(int[] nums, int m) {
        long sum = 0;
        int n = nums.length;
        long l = nums[0];
        for(int i = 0;i < n;i++){
            sum += nums[i];
            l = Math.max(l,nums[i]);
        }
        long h = sum+1;
        // System.out.println(" "+l+" "+h);

        while(l < h){
            long mid = l+(h-l)/2;
            // System.out.println(mid+" "+l+" "+h);
            if(can(nums,m,mid)){
                h = mid;
            }else {
                l = mid + 1;
            }
        }
        return (int)h;

    }

    public static void main(String[] args) {

        int[] a = {1,2147483646};

        int b = 2147483646+2;
        System.out.println(b);
    }
}
