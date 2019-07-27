package niuke.wangyi;

import java.util.Scanner;

public class 迷路的牛牛2019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        int[] cnt = new int[2];
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'L') cnt[0]++;
            else if (str.charAt(i) == 'R') cnt[1]++;
        }
        cnt[0] %= 4;
        cnt[1] %= 4;
        if (cnt[0] == cnt[1]) {
            System.out.println("N");
            return;
        }

        if (cnt[0] > cnt[1]) {
            cnt[0] -= cnt[1];
            switch (cnt[0]) {
                case 1:
                    System.out.println("W");
                    break;
                case 2:
                    System.out.println("S");
                    break;
                case 3:
                    System.out.println("E");
                    break;
                case 0:
                    System.out.println("N");
                    break;
            }
        } else if (cnt[0] < cnt[1]) {
            cnt[1] -= cnt[0];
            switch (cnt[1]) {
                case 1:
                    System.out.println("E");
                    break;
                case 2:
                    System.out.println("S");
                    break;
                case 3:
                    System.out.println("W");
                    break;
                case 0:
                    System.out.println("N");
                    break;
            }
        }
    }
}
