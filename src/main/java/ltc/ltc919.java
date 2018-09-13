package ltc;

import java.util.*;

//需要几个会议室
//intervals = [(0,30),(5,10),(15,20)],
// 返回 2.
public class ltc919 {
    //403ms 54%
    public int minMeetingRoomsPQ(List<Interval> intervals) {
        Collections.sort(intervals,(o1, o2)->o1.start-o2.start);
        PriorityQueue<Interval> heap = new PriorityQueue<>(intervals.size(),(o1, o2)->o1.end-o2.end);
        heap.add(intervals.get(0));
        for (int i = 1; i <intervals.size() ; i++) {
            if(intervals.get(i).start>=heap.peek().end)heap.poll();
            heap.add(intervals.get(i));
        }
        return heap.size();
    }
    /**
     |___| |______|
       |_____|  |____|
     starts:
     | |   |    |
     i
     ends:
          |  |     | |
         end
     res++;
     ---------
        i
         end
     res++; 这个end之前有2个start，前一个会议没有结束
     ---------
            i
         end
     end++; start>end表示有个room的会议已经结束，可以安排到这个room
     ---------
     */
    //251ms 74%
    public int minMeetingRooms2Arr(List<Interval> intervals) {
        int[] starts = new int[intervals.size()];
        int[] ends = new int[intervals.size()];
        for(int i=0;i<intervals.size();i++){
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int cnt =0;
        int end = 0;
        for (int i = 0; i < intervals.size(); i++) {
            if(starts[i]<ends[end])cnt++;
            else end++;
        }
        return cnt;
    }

    //240ms 75%
    public int minMeetingRooms(List<Interval> intervals) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(Interval i:intervals){
            map.put(i.start,map.getOrDefault(i.start,0)+1);
            map.put(i.end,map.getOrDefault(i.end,0)-1);
        }
        int room = 0;
        int max = 0;
        for(int num:map.values()){
            room+=num;
            max = Math.max(max,room);
        }
        return max;
    }
    //WA不能贪心。贪心返回3
    public int minMeetingRoomsWA(List<Interval> intervals) {
        if(intervals == null||intervals.size() == 0)return 0;
        int cnt=1;
        Collections.sort(intervals,(o1, o2)->o1.start-o2.start);
        int end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            if(intervals.get(i).start<end){
                cnt++;
            }
            end = Math.max(end,intervals.get(i).end);
        }
        return cnt;

    }
    public static void main(String[] args) {
        List<Interval> intervals = Arrays.asList(new Interval(0, 30), new Interval(5, 10), new Interval(15, 20));
        ltc919 sl = new ltc919();
        System.out.println(sl.minMeetingRoomsPQ(intervals));
    }
}
