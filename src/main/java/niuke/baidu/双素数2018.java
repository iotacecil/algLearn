package niuke.baidu;

import java.util.Arrays;
import java.util.Scanner;

public class 双素数2018 {
    //5
    public static int rev(int num) {
        int rst = 0;
        while (num > 0) {
            rst = rst * 10 + num % 10;
            num /= 10;
        }
        return rst;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        boolean[] susu = new boolean[1000_001];
        susu[0] = false;
        susu[1] = false;
        Arrays.fill(susu, true);
        for (int i = 2; i <= 1000000; i++) {
            if (susu[i]) {
                for (int j = i * 2; j <= 1000000; j += i) {
                    susu[j] = false;
                }
            }
        }
        int cnt = 0;
        for (int i = 2; i < 1000000; i++) {
            int revv = rev(i);
            if (i != revv && susu[i] && susu[revv]) {

                cnt++;
                if (cnt == k) {
                    System.out.println(i);
                    break;
                }
            }

        }


    }
}
