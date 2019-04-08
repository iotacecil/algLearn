package leetcode;

public class lc209 {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int e = 0;
        int st = 0;
//        if(n<1)return 0;
        int minl = n+1;


        int sum = 0;
        while(e < n){
            sum += nums[e++];
            while (st<=e&&sum>=s) {
                minl = Math.min(minl, e - st);
                sum -= nums[st++];
            }
        }
        return minl==n+1?0:minl;
    }

    public static void main(String[] args) {
        lc209 sl = new lc209();
        System.out.println(sl.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}
