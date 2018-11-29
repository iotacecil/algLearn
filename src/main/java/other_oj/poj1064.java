package other_oj;

import java.util.Scanner;

/**
 *
 */
public class poj1064 {
    static int n, k;
    static double[] lines;

    /**
     * 长度为L的绳子 最多可以切 floor(L/x)段
     *
     * @param x
     * @return
     */
    public static boolean C(double x) {
        int num = 0;
        for (int i = 0; i < n; i++) {
            num += (int) (lines[i] / x);
        }
        return num >= k;
    }

    /**
     * 满足可以切成k段的最大长度
     *
     * @param lines
     * @param k
     * @return
     */
    public static double howlong(double[] lines, int k) {
        //All cables are at least 1 meter and at most 100 kilometers in length.
        double l = 0, h = 100001;
//        while ((h-l)>1e-6){
        //可以达到10^-30的精度
        for (int i = 0; i < 100; i++) {


            double mid = (l + h) / 2;
            if (C(mid)) l = mid;
            else h = mid;
        }
        return Math.floor(h * 100) / 100;

    }
    //5600K	3563MS

    // All lengths in the input file are written with a centimeter precision, with exactly two digits after a decimal point.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        lines = new double[n];
        for (int i = 0; i < n; i++) {
            lines[i] = sc.nextDouble();
        }
        System.out.printf("%.2f\n", howlong(lines, k));
    }
}
