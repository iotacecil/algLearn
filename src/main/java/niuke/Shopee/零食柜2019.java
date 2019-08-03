package niuke.Shopee;

import java.util.Scanner;

public class 零食柜2019 {
    // most太小，分段数m太大。 most太大，分段数m太小。
    public static int canpart(int[] f, int m, long most) {
        long sum = 0;

        for (int i = 0; i < f.length; i++) {

            if (sum + f[i] <= most) {
                sum += f[i];
            } else {
                m--;
                // 分段数太多 most应该大一点
                if (m < 0) return 1;
                sum = f[i];
            }
        }
        // most 可以再小一点
        return 0;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] f = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            f[i] = sc.nextInt();
            sum += f[i];
        }
        //0 1 mid = 0 ok l = 1
        long l = 0;
        long h = sum;
        while (l < h) {
            long mid = (l + h + 1) / 2;
            System.out.println(l + " " + h + " " + mid);
            if (mid == 12) {
                System.out.println(canpart(f, m, mid));
            }
            // most可以小一点
            if (canpart(f, m, mid) == 0) {
                h = mid - 1;
            } else {
                // most可以大一点
                l = mid;
            }
        }
//        long rst = --l;
        System.out.println(h + 1);


    }
}
