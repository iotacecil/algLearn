package leetcode;

import java.util.ArrayList;
import java.util.List;

public class lc401 {
    public List<String> readBinaryWatch(int num){
        List<String> times = new ArrayList<>();
        for (int h = 0; h < 12 ; h++) {
            for (int m = 0; m < 60 ; m++) {
                if(Integer.bitCount((h<<6) + m) == num){
                    times.add(String.format("%d:%02d",h,m));
                }
            }

        }
        return times;
    }

    public static void main(String[] args) {
        lc401 sl = new lc401();
        System.out.println(sl.readBinaryWatch(0));
        System.out.println(1<<6);

    }
}
