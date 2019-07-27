package niuke.pdd;

import java.util.Scanner;

public class 模数求和2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int rst = 0;
        for (int i = 0; i < n; i++) {
            rst += sc.nextInt() - 1;

        }
        System.out.println(rst);
    }
}
