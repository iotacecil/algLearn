package niuke.wangyi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/*
给定5个正整数, 它们的最小的众倍数是指的能够被其中至少三个数整除的最小正整数。
给定5个不同的正整数, 请计算输出它们的最小众倍数。
 */
public class 最小众倍数2018 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split(" ");
        Arrays.sort(line);
        int max = Integer.parseInt(line[0]) * Integer.parseInt(line[1]) * Integer.parseInt(line[2]);
        int min = Integer.parseInt(line[2]);
        int ans = max;
        boolean find = false;
        for (int i = min; !find && i <= max; i++) {
            int cnt = 0;
            for (int j = 0; j < line.length; j++) {
                if (i % Integer.parseInt(line[j]) == 0) {
                    cnt++;
                }
                if (cnt >= 3) {
                    find = true;
                    ans = i;
                    break;
                }

            }

        }
        System.out.println(ans);
    }
}
