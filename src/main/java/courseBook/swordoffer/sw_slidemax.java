package courseBook.swordoffer;

import java.util.ArrayList;

public class sw_slidemax {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> rst = new ArrayList<>();

        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = left + size;
        for (int i = 0; i < Math.min(num.length,size ) ; i++) {
            max = Math.max(num[i], max);
        }
        rst.add(max);
        if(num.length < size){

            return rst;
        }

        return rst;
    }
}
