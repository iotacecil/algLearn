package niuke.codedance;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 最大点集2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] p = new int[n][2];
        for (int i = 0; i < n; i++) {
            p[i][0] = sc.nextInt();
            p[i][1] = sc.nextInt();
        }
        Arrays.sort(p, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        //  List<int[]> rst = new ArrayList<>();
        // 从上向下扫，比它矮的必须在它左边
        // 为什么可以保证x的从小到大？
        int maxx = -1;
        for (int[] pp : p) {
            if (pp[0] >= maxx) {
                //  rst.add(pp);
                maxx = pp[0];
                System.out.println(pp[0] + " " + pp[1]);
            }
        }


    }

}
