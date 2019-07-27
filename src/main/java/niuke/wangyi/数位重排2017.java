package niuke.wangyi;

import java.util.Arrays;
import java.util.Scanner;

public class 数位重排2017 {
    private static boolean isMatch(int a, int b) {
        String aa = "" + a;
        String bb = "" + b;
        char[] aaa = aa.toCharArray();
        char[] bbb = bb.toCharArray();
        if (aaa.length != bbb.length) return false;
        Arrays.sort(aaa);
        Arrays.sort(bbb);
        for (int i = 0; i < aaa.length; i++) {
            if (aaa[i] != bbb[i]) return false;

        }
        return true;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int num = sc.nextInt();
            boolean find = false;
            for (int j = 2; j <= 9; j++) {
                if (isMatch(num, num * j)) {
                    System.out.println("Possible");
                    find = true;
                    break;

                }


            }
            if (!find) System.out.println("Impossible");

        }
    }
}
