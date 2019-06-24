package niuke.codedance;

import java.util.Scanner;

public class 数列的和2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            double rst = 0.0 + n;
            double tmp = 0.0 + n;
            for (int i = 1; i < m; i++) {
                tmp = Math.sqrt(tmp);
                rst += tmp;
            }
            System.out.printf("%.2f\n", rst);
        }

    }
}
