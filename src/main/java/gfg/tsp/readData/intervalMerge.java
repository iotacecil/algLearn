package gfg.tsp.readData;

import java.util.ArrayList;
import java.util.List;

public class intervalMerge {
    public static void main(String[] args) {
        List<UserTimeInterval> intervals = readUserTime.buildInterval();
        intervals.sort((a,b)->b.end.compareTo(a.end));

        List<UserTimeInterval> rst = new ArrayList<>();
        for(UserTimeInterval interval:intervals){
            int stackTopStart = rst.get(rst.size() - 1).start.getMinute();
            int stackTopEnd = rst.get(rst.size() - 1).start.getMinute();
            int tmpEnd = interval.end.getMinute();
            int tmpStart = interval.start.getMinute();
            if(rst.size()<1){
                rst.add(interval);
            }
            //两个人的起始时间不超过20分钟
            else  if(tmpEnd>stackTopStart&&Math.abs(tmpStart-stackTopStart)<20){

            }
        }
    }
}
