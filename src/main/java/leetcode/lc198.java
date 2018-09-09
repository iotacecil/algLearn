package leetcode;

import java.util.Arrays;

//二进制串
//rob = max(rob(n-2)+money[i],rob(n-1))
//f(0) = nums[0]
//f(1) = max(num[0], num[1])
//        f(k) = max( f(k-2) + nums[k], f(k-1) )
public class lc198 {

    public int rob(int[] nums) {
        int len = nums.length;
        if(len==0)return 0;
        int[] dp = new int[len];
        for(int i =0;i<len;i++){
            dp[i] = Math.max((i>1?dp[i-2]:0)+nums[i],(i>0?dp[i-1]:0));


        }
        return dp[len-1];
    }
    public int rob2(int[] nums) {
        int dp2 = 0;
        int dp1 = 0;
        for (int money : nums) {//1 2 3 1  1,2, 4,
            int dp = Math.max(dp1 + money, dp2); //dp = 1,2,(1+3,2)
            dp1 = dp2;//两个之前的dp1 = 0  1
            dp2 = dp;//加了的 dp2 = 1 2


        }
        return dp2;
    }
    int rob33(int[] num){
        return rob3(num,num.length);
    }
    int rob3(int num[], int n) {
        int a = 0;
        int b = 0;

        for (int i=0; i<n; i++)
        {
            //
            if (i%2==0)
            {
                a = Math.max(a+num[i], b);
            }
            else
            {
                b = Math.max(a, b+num[i]);
            }
        }

        return Math.max(a, b);
    }

    public static void main(String[] args) {
        Thread.currentThread();
        int[] a=new int[10];
        lc198 sl = new lc198();
        System.out.println(sl.rob33(new int[]{9, 0, 0, 9}));
        System.out.println(Arrays.toString(a));

    }
}
