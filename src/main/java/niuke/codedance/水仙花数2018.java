package niuke.codedance;

import java.util.Scanner;

public class 水仙花数2018 {
    private static boolean ishs(int n) {
        int g = n % 10;
        int s = n / 10 % 10;
        int b = n / 100;
        if (n == g * g * g + s * s * s + b * b * b) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            boolean flag = false;
            for (int i = m; i <= n; i++) {
                if (ishs(i)) {
                    flag = true;
                    System.out.print(i + " ");
                }
            }

            if (!flag) System.out.println("no");
            else System.out.println();
        }


    }
}
