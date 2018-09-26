package leetcode;

import java.util.Arrays;

public class lc410 {
    private boolean C(int[] nums,long mid,int m){
        int cnt = 0;

        int n = nums.length;
        int i=0;
        while(i<n){
            long tmp = 0;
            cnt++;
            System.out.println(mid+" "+nums[i]+" "+cnt);
            if(cnt>m)return false;
            while(i<n&&tmp+nums[i]<mid){
                tmp+=nums[i];
                i++;
            }
            System.out.println("tmp "+tmp);
        }
        // System.out.println("ok"+mid+" "+cnt);
        return true;
    }
    public int splitArrayMy(int[] nums, int m) {

        long sum = 0;
        for(int i:nums){
            sum+=i;
        }
        if(m==1)return (int)sum;
        else if(nums.length==2&&m==2)return Math.max(nums[0],nums[1]);
        long l = 0,h = sum;
        while(h-l>1){
            System.out.println("next"+h+" "+l);
            long mid = (h+l)/2;
            if(C(nums,mid,m))h = mid;
            else l = mid;
        }
        return (int)l;


    }
    //0~k 划分成m组


    //wa有问题
    public int splitArrayDp(int[] nums,int m){
        int n = nums.length;
        int[] presum = new int[n];
        presum[0] = nums[0];
        for (int i = 1; i <n ; i++) {
            presum[i]=presum[i-1]+nums[i];
        }
        int[][] dp = new int[m+1][n];
        for (int i = 0; i <n ; i++) {
            dp[1][i] = presum[i];
        }
        // 划分的分数
        for (int i = 2; i <=m ; i++) {
            //划分数组的长度
            for (int j = i-1; j <n ; j++) {
                //分割点
                for (int k = 0; k <j ; k++) {
                dp[i][j] = Math.min(dp[i][j],Math.max(dp[i-1][k],presum[j]-presum[k] ));
                }
            }
        }
        return dp[m][n-1];
    }
    int[] presum;
    int n;
    int[][] memo;
    public int splitArray2(int[] nums,int m){
         n = nums.length;
         presum = new int[n];
         memo = new int[n][m+1];
        for(int[] me:memo){
            Arrays.fill(me,Integer.MAX_VALUE );
        }
        presum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            presum[i] = presum[i-1]+nums[i]; }
            return splitArray(nums,n-1,m );
    }
    //0~k 划分成m组
    private int splitArray(int[] nums,int k,int m){
        //整个数组的和
        if(m == 1)return presum[k];
        //大于元素个数
        if(m>k+1)return Integer.MAX_VALUE;
        if(memo[k][m]!=Integer.MAX_VALUE)return memo[k][m];
        int ans = Integer.MAX_VALUE;
        //分割点
        for (int i = 0; i < k; i++) {
            //i+1~k的和
            ans = Math.min(ans,Math.max(splitArray(nums,i ,m-1 ),presum[k]-presum[i]));
        }
        return memo[k][m] = ans;
    }


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
        long l =    max,r = sum;
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
        System.out.println(sl.splitArrayMy(nums, 2));
    }
}
