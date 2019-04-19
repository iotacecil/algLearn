package luogu;

import java.util.Scanner;

public class p2405 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long m = sc.nextLong();
        long n = sc.nextLong();
        int cnt = 0;
        // m 2 n进制
        if (n == 10) {
            while (m != 0) {
                if (m % 10 != 0) cnt++;
                m /= 10;
            }
            System.out.println(cnt);
        } else {
            // 99 ->2
            while (m != 0) {
                if (m % n != 0) cnt++;
                m /= n;
            }
            System.out.println(cnt);
        }

    }
}
