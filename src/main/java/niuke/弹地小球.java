package niuke;

import java.util.Scanner;

public class 弹地小球 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            // 5 + 2.5 +2.5 + 1.
            double H = sc.nextInt();
            int n = sc.nextInt();
            double rst = H;
            n--;
            H /= 2.0;
            while (n > 0) {
                rst += 2 * H;
                H /= 2.0;
                n--;
            }
            System.out.printf("%.2f\n", rst);
        }

    }
}
