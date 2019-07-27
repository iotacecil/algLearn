package niuke.wangyi;

import java.util.Scanner;

/*
只提供6个每袋和8个每袋的包装(包装不可拆分)。
可是小易现在只想购买恰好n个苹果，小易想购买尽量少的袋数方便携带。如果不能购买恰好n个苹果，小易将不会购买。
输入一个整数n，表示小易想购买n(1 ≤ n ≤ 100)个苹果

输出一个整数表示最少需要购买的袋数，如果不能买恰好n个苹果则输出-1

20 = 8+6+6
10 = 4+3+3
 */
public class 买苹果2017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int six = 0;
        while (n - six * 6 >= 0) {
            if ((n - six * 6) % 8 == 0) {
                System.out.println((six + (n - six * 6) / 8));
                return;
            }
            six++;
        }
        System.out.println(-1);
    }
}
