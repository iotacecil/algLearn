package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;


class MyCalendar {
    TreeMap<Integer,Integer> calendar;
    public MyCalendar() {
        calendar = new TreeMap<>();
    }
    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start);
        Integer next = calendar.ceilingKey(start);
        if((prev==null||calendar.get(prev)<=start)&&(next==null||end<=next)){
            calendar.put(start,end);
            return true;
        }
        return false;
    }
}


public class lc729 {
    public static void main(String[] args) {
        MyCalendar my = new MyCalendar();
        my.book(10, 20); // returns true
        my.book(15, 25); // returns false
        my.book(20, 30); // returns true
    }

}
