package leetcode;

import java.util.Arrays;

public class lc667 {
    public int[] constructArray(int n, int k) {
        int[] arr = new int[n];
        int c = 0;
        int l = 1, h = n;

        while(l <= h)
        {
            if(k > 1)arr[c++]= ((k--%2 != 0)?l++:h--);
            else arr[c++]=l++;
        }

       return arr;
    }

    public static void main(String[] args) {
        lc667 sl = new lc667();

        System.out.println(Arrays.toString(sl.constructArray(5, 3)));
    }

}
