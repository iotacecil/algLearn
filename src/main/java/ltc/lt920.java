package ltc;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//[[0,30]，[5,10]，[15,20]]
public class lt920 {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals == null||intervals.size() == 0)return true;
        Collections.sort(intervals,(o1,o2)->o1.start-o2.start);
        int end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            if(intervals.get(i).start<end)return false;
            end = Math.max(end,intervals.get(i).end);
        }
        return true;
    }

    public static void main(String[] args) {
        List<Interval> intervals = Arrays.asList(new Interval(0, 30), new Interval(5, 10), new Interval(15, 20));
        lt920 sl = new lt920();
        System.out.println(sl.canAttendMeetings(intervals));
    }
}
