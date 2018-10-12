package ltc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
class Event implements Comparable<Event>{
    static final int START = 0;
    static final int END = 1;
    int time,type;

    public Event(int time, int type) {
        this.time = time;
        this.type = type;
    }

    @Override
    public int compareTo(Event o) {
        if(this.time!=o.time){
            return this.time - o.time;
        }
        return this.type-o.type;
    }


    @Override
    public String toString() {
        return "Event{" +
                "time=" + time +
                ", type=" + type +
                '}';
    }
}
public class lt821 {
    //遇到start，count++，遇到end，count--，那么intersection就是找出所有时刻(x, x+1)，其中x时刻count=2，x+1时刻的count=1
    public List<Interval> timeIntersection(List<Interval> seqA, List<Interval> seqB) {
        List<Event> events = new ArrayList<>();
        for(Interval i:seqA){
            events.add(new Event(i.start,Event.START));
            events.add(new Event(i.end,Event.END));
        }
        for(Interval i:seqB){
            events.add(new Event(i.start,Event.START));
            events.add(new Event(i.end,Event.END));
        }
        System.out.println(events);
        Collections.sort(events);
        System.out.println(events);

        int count = 0;
        Integer start = null,end = null;
        List<Interval> res = new ArrayList<>();
        for(Event event : events){
            if(event.type == 0){
                //用户上线
                count++;
                if(count == 2)start = event.time;
            }else {
                //用户下线
                count--;
                if(count == 1)end = event.time;
            }
            if(start != null && end != null){
                res.add(new Interval(start,end));
                start = null;end = null;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        List<Interval> seqA = Arrays.asList(new Interval(1, 2), new Interval(5, 100));
        List<Interval> seqB = Arrays.asList(new Interval(1, 6));
        lt821 sl =new lt821();
        System.out.println(sl.timeIntersection(seqA, seqB));

    }
}
