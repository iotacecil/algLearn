package leetcode;

import java.util.Arrays;
//[1,2] [2,4][2,3] ->[1,2][2,3],[2,4]
public class lc435 {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals==null||intervals.length<1)return 0;
     // Arrays.sort(intervals,(a,b)->a.end!=b.end?(a.end-b.end):(a.start-b.start));
        // 按start 排序
     Arrays.sort(intervals,(a,b)->a.start==b.start?(a.end-b.end):(a.start-b.start));

        int cnt = 1;
        int reserve = 0;
        int pstart = intervals[0].start;
        int pend = intervals[0].end;
        for (int i = 1; i <intervals.length ; i++) {
            if(pend>intervals[i].start&&pend>intervals[i].end){
                //重叠
                //当前区间在前一个区间中开始且结束早于前一个[1,4][2,3] end取当前区间end
                pend = intervals[i].end;
            }else if(pend<=intervals[i].start){
                //不重叠
                cnt++;
                pstart = pend;
                pend = intervals[i].end;

            }
            }
        return intervals.length-cnt;
    }
}
