package niuke.paypal;

import java.util.*;

public class 弹幕 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = sc.nextInt();
            end[i] = sc.nextInt();
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int max = 1;
        int in = 1;
        int i = 1, j = 0;
        int[] best = new int[2];
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        List<int[]> tmp = new ArrayList<>();
        tmp.add(new int[]{start[0], end[0]});
        map.put(1, tmp);
        while (i < n && j < n) {
            if (start[i] < end[j]) {
                in++;
                i++;
                //  System.out.println(max);
                if (max < in) {
                    max = in;
                    ArrayList<int[]> list = new ArrayList<>();
                    list.add(new int[]{start[i - 1], end[j]});
                    map.put(max, list);

                } else if (max == in) {
                    map.get(max).add(new int[]{start[i - 1], end[j]});
                }
            } else {
                in--;
                if (max == in) {
                    map.get(max).add(new int[]{start[i], end[j]});
                }
                j++;
            }

        }

        for (int[] item : map.get(max)) {
            System.out.println(item[0] + " " + item[1]);
        }

    }
}
