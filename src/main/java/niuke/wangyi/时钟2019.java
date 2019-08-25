package niuke.wangyi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//在满足改变最少的数字的前提下，符合条件的字典序最小的时间是多少。


public class 时钟2019 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        while (t-- > 0) {
            String[] time = bf.readLine().split(":");
            int a = Integer.parseInt(time[0]);
            int b = Integer.parseInt(time[1]);
            int c = Integer.parseInt(time[2]);
            StringBuilder sb = new StringBuilder();
            if (a > 23) {
                sb.append(String.format("%02d", a % 10) + ":");
            } else sb.append(time[0] + ":");
            if (b > 59) {
                sb.append(String.format("%02d", b % 10) + ":");

            } else {
                sb.append(time[1] + ":");
            }

            if (c > 59) {
                sb.append(String.format("%02d", c % 10));

            } else {
                sb.append(time[2]);
            }

            System.out.println(sb.toString());
        }

    }
}
