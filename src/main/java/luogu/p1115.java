package luogu;

import java.util.Scanner;

public class p1115 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long sum = 0;
        long rst = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (sum < 0) sum = 0;
            sum += num;
            rst = Math.max(rst, sum);
        }
        System.out.println(rst);
    }
}
