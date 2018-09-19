package ltc;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.List;

public class lt30 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    if(newInterval==null||intervals==null)return intervals;
    List<Interval> rst = new ArrayList<>();
    int insertPos = 0;
    for(Interval interval:intervals) {
        if (interval.end < newInterval.start) {
            rst.add(interval);
            insertPos++;
        } else if (interval.start > newInterval.end) {
            rst.add(interval);
        } else {
            newInterval.start = Math.min(newInterval.start, interval.start);
            newInterval.end = Math.max(newInterval.end, interval.end);
        }
    }
        rst.add(insertPos, newInterval);
        return rst;


    }
}
