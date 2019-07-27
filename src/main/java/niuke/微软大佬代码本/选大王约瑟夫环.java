package niuke.微软大佬代码本;

import java.util.Scanner;

public class 选大王约瑟夫环 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int t = 0;
            for (int i = 1; i <= n; i++) {
                t = (t + m) % i;
            }
            System.out.println(t + 1);
        }
    }
}
