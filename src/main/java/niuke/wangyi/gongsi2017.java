package niuke.wangyi;

import java.util.Scanner;

/*
2
-2 -2
0 -2
-4 -2
15 3

30+ -2，0 ->-4,-2 4*3=12
 */
public class gongsi2017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] tX = new int[n];
        int[] tY = new int[n];
        for (int i = 0; i < n; i++) {
            tX[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            tY[i] = sc.nextInt();
        }
        int[] target = new int[2];
        target[0] = sc.nextInt();
        target[1] = sc.nextInt();
        int walk = sc.nextInt();
        int taxi = sc.nextInt();


        int sum = walk * (Math.abs(target[0]) + Math.abs(target[1]));
        for (int i = 0; i < n; i++) {
            int totaxi = walk * (Math.abs(tX[i]) + Math.abs(tY[i]));
            int togs = taxi * (Math.abs(tX[i] - target[0]) + Math.abs(tY[i] - target[1]));
            sum = Math.min(sum, totaxi + togs);
        }
        System.out.println(sum);

    }
}
