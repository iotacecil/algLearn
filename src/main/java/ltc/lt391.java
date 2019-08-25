package ltc;

import java.util.Arrays;
import java.util.List;

public class lt391 {
    public int countOfAirplanes(List<Interval> airplanes) {
        int n = airplanes.size();
        if (n < 1) return 0;
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = airplanes.get(i).start;
            end[i] = airplanes.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int in = 1;
        int max = 1;
        int time = start[0];
        int i = 1, j = 0;
        while (i < n && j < n) {
            if (start[i] <= end[j]) {
                in++;
                System.out.println(i + "进入");
                max = Math.max(in, max);
                i++;
            } else {
                in--;
                System.out.println(j + "退出");

                j++;
            }
        }
        return max;
    }
}
