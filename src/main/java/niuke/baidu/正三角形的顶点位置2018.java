package niuke.baidu;

import java.util.Scanner;

//*****!!!
public class 正三角形的顶点位置2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            double x1 = sc.nextDouble();
            double y1 = sc.nextDouble();
            double x2 = sc.nextDouble();
            double y2 = sc.nextDouble();
            double a = Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
            double a32 = a * Math.sqrt(3) / 2;

            if (x1 == x2) {

                System.out.printf("%.2f %.2f ", x1 - a32, (y1 + y2) / 2);
                System.out.printf("%.2f %.2f\n", x1 + a32, (y2 + y1) / 2);
            } else if (y1 == y2) {

                System.out.printf("%.2f %.2f ", (x1 + x2) / 2, y1 - a32);
                System.out.printf("%.2f %.2f\n", (x1 + x2) / 2, y1 + a32);

            } else {

                double midx = (x2 + x1) / 2;
                double midy = (y2 + y1) / 2;
                double k = (y2 - y1) / (x2 - x1);
                double sine = Math.abs(y2 - y1) / a;
                double x = midx - sine * a32;
                double xx = midx + sine * a32;
                // 右上 左下
                double y = midy + sine * a32 / k;
                double yy = midy - sine * a32 / k;
                System.out.printf("%.2f %.2f %.2f %.2f", x, y, xx, yy);


            }

        }
    }
}
