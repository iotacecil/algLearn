package other_oj;

import java.util.Arrays;
import java.util.Scanner;

//5548K	2719MS
public class poj2456 {
    static int m, n;
    static int[] room;

    private static boolean C(int d) {
        int last = 0;
        for (int i = 1; i < m; i++) {
            int crt = last + 1;
            //找到间隔>d的房间
            while (crt < n && room[crt] - room[last] < d) {
                crt++;
            }
            if (crt == n) return false;
            last = crt;
        }
        return true;
    }

    /**
     * 最大化最小值 最大化两头牛之间的距离
     * 使得任意牛之间的间距都不小于d
     * 1. 贪心： 位置排序 第一头放进room[0]
     *
     * @param room
     * @param m
     * @return
     */
    public static int maxmin(int[] room, int m) {
        Arrays.sort(room);
        // positions x1,...,xN (0 <= xi <= 1,000,000,000).
        int l = 0, h = 1000000 + 1;
        while (h - l > 1) {
            int mid = (h + l) / 2;
            if (C(mid)) l = mid;
            else h = mid;
        }
        return l;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        room = new int[n];
        for (int i = 0; i < n; i++) {
            room[i] = sc.nextInt();
        }
        System.out.println(maxmin(room, m));
    }
}
