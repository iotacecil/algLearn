package leetcode;

import java.util.ArrayList;
import java.util.List;

public class lc57 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        for(int i =0;i<intervals.size();i++){
            //[1,3] [6,9] [2,5]
            while (i<intervals.size()&&newInterval.start>intervals.get(i).start)

              i++;


                intervals.add(i,newInterval );
//                System.out.println(intervals);
                break;

            //[1,3] [2,5] [6,9]

        }
        List<Interval> rst =new ArrayList<>();

        Interval pre = intervals.get(0);
        rst.add(pre );
        for(int i =1;i<intervals.size();i++){
            Interval curr = intervals.get(i);
            if(curr.start<=pre.end){
                pre.end = Math.max(curr.end,pre.end);

            }
            else{
                rst.add(curr);
                pre = curr;
            }


        }
        return rst;
    }

    public static void main(String[] args) {
        lc57 sl = new lc57();
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,5));
//        intervals.add(new Interval(1,2));
//        intervals.add(new Interval(3,5));
//        intervals.add(new Interval(6,7));
//        intervals.add(new Interval(8,10));
//        intervals.add(new Interval(12,16));
        Interval interval = new Interval(2, 3);
        System.out.println(sl.insert(intervals, interval));
    }
}
