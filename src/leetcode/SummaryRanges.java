package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

class Interval {
      int start;
     int end;
      Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

public class SummaryRanges {
    TreeMap<Integer,Interval> treeMap;

    public SummaryRanges() {
        treeMap = new TreeMap<>();

    }

    public void addNum(int val) {
        if(treeMap.containsKey(val))return;
        Integer lowerkey = treeMap.lowerKey(val);
        Integer higherkey = treeMap.higherKey(val);
        if(lowerkey!=null&&higherkey!=null&&
                treeMap.get(lowerkey).end+1==val&&val-1==treeMap.get(higherkey).start){
            treeMap.get(lowerkey).end = treeMap.get(higherkey).end;
            treeMap.remove(higherkey);


        }else if(higherkey!=null&&treeMap.get(higherkey).start-1>=val){
            treeMap.put(val,new Interval(val,higherkey));
            treeMap.remove(higherkey);

        }
        //(1,3) 0
        else if(lowerkey!=null&&val<=treeMap.get(lowerkey).end+1) {
//            treeMap.get()
        }else
        {
            treeMap.put(val,new Interval(val,val));

        }
    }

    public List<Interval> getIntervals() {
        return new ArrayList<>(treeMap.values());
    }
}
