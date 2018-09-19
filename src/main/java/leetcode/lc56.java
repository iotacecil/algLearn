package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class lc56 {
    public List<Interval> mergeDebug(List<Interval> intervals) {
        int n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        // loop through
        List<Interval> res = new ArrayList<Interval>();
        for (int i = 0, j = 0; i < n; i++) { // j is start of interval.
            if (i == n - 1 || starts[i + 1] > ends[i]) {
                res.add(new Interval(starts[j], ends[i]));
                j = i + 1;
            }
        }
        return res;

    }
    public List<Interval> mergeMyself(List<Interval> intervals) {
        if(intervals==null||intervals.size()<2)return intervals;
        intervals.sort((a,b)->a.start-b.start);
        List<Interval> rst = new ArrayList<>();
        for(Interval interval:intervals){
            if(rst.size()<1){
                System.out.println(interval);
                rst.add(interval);
            }
            else if(rst.get(rst.size()-1).end>=interval.start){
                System.out.println(interval);
                Interval newInter = rst.get(rst.size()-1);
                rst.remove(rst.size()-1);
                newInter.end = Math.max(newInter.end,interval.end);
                rst.add(newInter);
                System.out.println(newInter);
            }else{
                rst.add(interval );
            }

        }
        return rst;

    }

//    public List<Interval> mergeinplace(List<Interval> intervals){
//        intervals.sort((a,b)->b.start-a.start);
//        for (int i = 0; i <intervals.size() ; i++) {
//            if(i!=0&&intervals.get(i-1).start<=intervals.get(i).end){
//                while (i!=0&&intervals[i])
//            }
//
//        }
//    }
    //1 2 8  15
    //3 6 10 18 当start[i+1]>end[i] merge
    public List<Interval> merge2(List<Interval> intervals) {
        if(intervals==null||intervals.size()<1)return intervals;
        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i <n ; i++) {
            start[i] =intervals.get(i).start;
            end[i] = intervals.get(i).end;

        }
        Arrays.sort(start);
        Arrays.sort(end);
        List<Interval> rst = new ArrayList<>();
        for (int i = 0,j=0; i <n ; i++) {
            if(i==n-1||start[i+1]>end[i]){
                rst.add(new Interval(start[j],end[i]));
                j=i+1;
            }

        }
        return rst;
    }
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> rst = new ArrayList<>();
        if(intervals.size()<1)return intervals;

        intervals.sort(Comparator.comparingInt(a -> a.start));
        Interval last = null;


        for(Interval inter : intervals){
//inter.start<=last.end->l
            if(last==null||inter.start>last.end) {
                rst.add(inter);
                last = inter;
            }
            else {
                last.end = Math.max(last.end, inter.end);
            }

        }
        return rst;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(8,16));
        intervals.add(new Interval(15,18));
        lc56 sl = new lc56();

        List<Interval> intervals2 = new ArrayList<>();
        intervals2.add(new Interval(1,4));
        intervals2.add(new Interval(0,2));
        intervals2.add(new Interval(3,5));


//        System.out.println(sl.mergeMyself(intervals));
        System.out.println(sl.mergeDebug(intervals2));

    }
}
