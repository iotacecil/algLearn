package leetcode;

import java.util.Arrays;

public class lc179 {
    public String largestNumber(int[] nums) {
        if(nums==null||nums.length<1)return "";
        String[] strs = new String[nums.length];
        //变成String数组
        for (int i = 0; i <nums.length ; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs,(a,b)->(b+a).compareTo(a+b));
        if(strs[0].equals("0"))return "0";
        StringBuilder sb = new StringBuilder();
        for(String str:strs){
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        lc179 sl = new lc179();
        System.out.println(sl.largestNumber(new int[]{3, 30, 34, 5, 9}));
    }
}
