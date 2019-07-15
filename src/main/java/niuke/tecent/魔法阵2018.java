package niuke.tecent;

import java.util.Arrays;
import java.util.Scanner;

public class 魔法阵2018 {
    public static void main(String[] args) {
        // 正方形
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            String xline = sc.next();
            String yline = sc.next();
            int[][] points = new int[4][2];
            int[] dis = new int[6];
            int cnt = 0;
            for (int i = 0; i < 4; i++) {
                points[i][0] = xline.charAt(i) - '0';
                points[i][1] = yline.charAt(i) - '0';
            }
            for (int i = 0; i < 3; i++) {
                for (int j = i + 1; j < 4; j++) {
                    int dis2 = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                    dis[cnt++] = dis2;
                }
            }
            Arrays.sort(dis);
            if (dis[0] > 0 && dis[0] * 2 == dis[5]) {
                System.out.println("YES");

            } else {
                System.out.println("No");
            }
        }
    }
}
