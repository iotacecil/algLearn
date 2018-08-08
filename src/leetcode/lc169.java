package leetcode;

import java.util.Random;

//more than ⌊ n/2 ⌋ times. 众数
public class lc169 {
    //random
    public int majorityElement(int[] nums){
        Random random = new Random(System.currentTimeMillis());

        while(true) {
            int i2 = random.nextInt(nums.length);
            int cur = nums[i2];
            int cnt = 0;
            for (int num : nums) {
                if (num == cur && ++cnt > nums.length / 2) return num;
            }
        }

    }
    //bit mask
    //用统计数字的每个bit，出现1>n/2次则为1
    public int bitmask(int[] nums) {
        int n = nums.length;
        int rst = 0;
        for (int i = 0; i < 32 ; i++) {
            int mask = 1<<i;
            int cnt =0;
            for(int num:nums){
                if((num&mask)!=0)++cnt;
            }
            if(cnt>n/2)rst|=mask;


        }
        return rst;
    }
    //moore voting在线算法
    public int moore(int[] nums) {
        //假设就是第一个
        int maj = nums[0];
        int cnt=0;
        for (int num:nums){
            //第一个数就cnt=1
            if(num==maj)++cnt;
            else if(--cnt==0){
                //等于0 从头开始做
                cnt=1;
                maj=num;
            }
        }
        return maj;
    }
    //？？？分治


    }
