package leetcode;

import java.util.Arrays;

public class plusone {
    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        for(int i = len-1;i>=0;i--){
            if(digits[i]<9){
                //有进位 只执行1次
                digits[i]++;
                return digits;
            }
            //=9
            digits[i]=0;
        }
        //遍历完了还没返回只加1 说明是9999..
        int[] newNumber = new int[len+1];
        newNumber[0]=1;
        return newNumber;

    }

    public static void main(String[] args) {
        int[] digits = {9,8,7,6,4,3};
        System.out.println(Arrays.toString(plusOne(digits)));

    }
}
