package niuke.kuaishou;

import java.util.Scanner;

/*
0
1
3
5
7
100000
至少测试用例是对的
 */
public class superfibo {
    public static void main(String[] args) {
        final long mod = 1_000_000_000 + 3;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long n = sc.nextInt();
            long f0 = 1;
            long f1 = 1;
            long f2 = 1;
            long f3 = 1;
            long f4 = 1;

            if (n <= 4) {
                System.out.println(1);
            } else {
                long f5 = (2018 * f4 + 2017 * f3 + 2016 * f2 + 2015 * f1 + 2014 * f0) % mod;

                for (int i = 6; i <= n; i++) {
                    long tmp = f0;
                    f0 = f1;
                    f1 = f2;
                    f2 = f3;
                    f3 = f4;
                    f4 = f5;
                    f5 = (2018 * f4 + 2017 * f3 + 2016 * f2 + 2015 * f1 + 2014 * f0) % mod;
                }
                System.out.println(f5);
            }
        }
    }
}
