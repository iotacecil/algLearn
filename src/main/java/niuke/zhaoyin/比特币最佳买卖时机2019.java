package niuke.zhaoyin;

import java.util.Scanner;

public class 比特币最佳买卖时机2019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.nextLine();
        String[] split = next.split(" ");
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < split.length; i++) {
            int num = Integer.parseInt(split[i]);

            max = Math.max(num - min, max);

            min = Math.min(min, num);

        }
        System.out.println(max);
    }
}
