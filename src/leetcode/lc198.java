package leetcode;


import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.TimerTask;

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

    public static void main(String[] args) {
        Thread.currentThread();
        int[] a=new int[10];
        System.out.println(Arrays.toString(a));

    }
}
