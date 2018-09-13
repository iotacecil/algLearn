package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//Input: ["23:59","00:00"]
//        Output: 1
class Time implements Comparable<Time>{
    int h;
    int m;

    public Time(int h, int m) {
        this.h = h;
        this.m = m;
    }

    @Override
    public int compareTo(Time o) {
        if(this.h==o.h)return this.m-o.m;
        return this.h - o.h;
    }
    public int getDiff(Time o){
        return (this.h-o.h)*60+(this.m-o.m);
    }

}
//    minutes difference between any two time points
//任意两点之间的最小值
public class lc539 {

    //30% 40ms
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
    //排序
      List<Time> times = new ArrayList<>();
      for(String t:timePoints){
          times.add(new Time(Integer.parseInt(t.split(":")[0]),Integer.parseInt(t.split(":")[1])));
      }
      Collections.sort(times);
      //最小这个00:01->24:01
      Time earList = times.get(0);
      times.add(new Time(earList.h + 24, earList.m));
      int minDif = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int diff = (int)Math.abs(times.get(i).getDiff(times.get(i+1)));
            minDif = Math.min(minDif,diff);
        }
        return minDif;
    }

    //fast way 9ms
    public int findMinDifferenceFast(List<String> timePoints) {
        boolean[] times = new boolean[24*60];
        for(String time:timePoints){
            int hours = Integer.parseInt(time.substring(0,2));
            int minutes = Integer.parseInt(time.substring(3));
            if(times[60*hours+minutes]==true)return 0;
            times[60*hours+minutes]= true;
        }
        int prev = -1;
        int minDiff = Integer.MAX_VALUE;
        int first = -1;
        int cur = -1;
        for (int i = 0; i < 24*60 ; i++) {
            if(times[i]){
                if(prev!=-1){
                    cur = i;
                    minDiff = Math.min(minDiff,cur-prev);
                }
                prev = i;
                if(first == -1)first = i;
            }

        }
        return Math.min(minDiff,24*60+first-cur );
    }

    public static void main(String[] args) {
        String[] strs = {"23:59","00:00"};
        List<String> list = Arrays.asList(strs);
        lc539 sl = new lc539();
        System.out.println(sl.findMinDifferenceFast(list));
    }

}
