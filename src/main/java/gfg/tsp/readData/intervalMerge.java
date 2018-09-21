package gfg.tsp.readData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


class groupInterval{
    int groupId;
    int start;
    int end;
    int dur;
//    int maxDurDif;
    List<String> userIDs;

    public groupInterval(int groupId, int start, int end, int dur, List<String> userIDs) {
        this.groupId = groupId;
        this.start = start;
        this.end = end;
        this.dur = dur;

        this.userIDs = userIDs;
    }

    @Override
    public String toString() {
        return "{" +
                "groupId=" + groupId +
                ", start=" + start +
                ", end=" + end +
                ", dur=" + dur +

                ", userIDs=" + userIDs +
                '}';
    }
}

public class intervalMerge {
    public static List<groupInterval> groups(){
        List<UserTimeInterval> intervals = readUserTime.buildInterval();
        intervals.sort((a,b)->a.start-(b.start));
        List<groupInterval> groups = new ArrayList<>();

        int groupCnt =0;

        while (!intervals.isEmpty()) {

            UserTimeInterval first = intervals.get(0);
            int start = first.start;
            int end = first.end;
            long dur = first.duration;
//            HashMap<UserTimeInterval, List<String>> group = new HashMap<>();
            List<String> users = new ArrayList<>();
            int size = intervals.size();
            List<Integer> removeIdx = new ArrayList<>(5);
            removeIdx.clear();
            for(int i =0;i<size;i++){
                UserTimeInterval interval = intervals.get(i);
                if ((interval.start - start)/Math.min(interval.duration,dur) >.3 ) {
                    break;
                }
                if (Math.abs(interval.duration - dur)/Math.min(interval.duration,dur)>0.25||(interval.end-start)>1.3*dur) continue;
                end = Math.max(end, interval.end);
                users.add(interval.userId);
//                System.out.println("被合并的区间" + interval);
                removeIdx.add(i);
            }

            for(int i =removeIdx.size()-1;i>=0;i--){
                intervals.remove((int)removeIdx.get(i));
            }
            groups.add(new groupInterval(groupCnt++, start, end, (end - start), users));
        }
        return groups;

    }
    public static void main(String[] args) {
        List<groupInterval> groups = intervalMerge.groups();
        System.out.println(groups);

    }
}
