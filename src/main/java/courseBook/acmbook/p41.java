package courseBook.acmbook;

import java.util.ArrayList;
import java.util.List;

public class p41 {
    class Interval{
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    /**
     * 每次选结束时间最早的
     * 结束时间越早 之后可选工作越多
     * @param s
     * @param e
     * @return
     */
    public int howmany(int[]s,int[] e){
        List<Interval> intervals = new ArrayList<>();
        for (int i = 0; i <s.length ; i++) {
            intervals.add(new Interval(s[i],e[i]));
        }
        intervals.sort((a,b)->a.end-b.end);
        int cnt = 0;
        int end = 0;
        for (int i = 0; i <s.length ; i++) {
            if(end<intervals.get(i).start){
                System.out.println(i);
                cnt++;
                end = intervals.get(i).end;
            }
        }
        return cnt;
    }
    /**
     * 最多能参加多少工作
     * @param args
     */
    public static void main(String[] args) {
        int[] s = {1,2,4,6,8};
        int[] e = {3,5,7,9,10};
        int n = 5;
        p41 sl = new p41();
        System.out.println(sl.howmany(s, e));
    }
}
