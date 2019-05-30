package leetcode;

import java.util.Arrays;

public class lc630 {
    public int scheduleCourse(int[][] courses) {

        Arrays.sort(courses,(a,b)->a[1]-b[1]!=0?a[1]-b[1]:a[0]-b[0]);
        int start = 0;
        int cnt = 0;
        for(int[] course :courses){
            start+=course[0];
            if(start<=course[1]){
                cnt++;
            }else{
                start-=course[0];
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        lc630 sl = new lc630();
        System.out.println(sl.scheduleCourse(new int[][]{{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}}));
    }
}
