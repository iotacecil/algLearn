package niuke.wangyi;

import java.util.Scanner;
/*



G G B B G
0 0 1 2 2
1 2 2 2 2

G B G B G
B G G B G



G B G B G B
        |
   ^
 */

/*
G B G B G B -> GGGBBB +G
0 1 1 2 2 3
G B G B G B -> BBBGGG +B
1 1 2 2 3 3
 */
public class duixing2017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = str.length();
        int[] gcnt = new int[n];
        int[] bcnt = new int[n];
        int gsum = 0;
        int bsum = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'G') {

                if (i > 0) {
                    gcnt[i] = gcnt[i - 1] + 1;

                    bcnt[i] = bcnt[i - 1];
                } else {
                    gcnt[i] = 1;
                }
                bsum += bcnt[i];
            } else {
                if (i > 0) {
                    gcnt[i] = gcnt[i - 1];
                    bcnt[i] = bcnt[i - 1] + 1;
                } else {
                    bcnt[i] = 1;
                }
                gsum += gcnt[i];
            }
        }

        System.out.println(Math.min(gsum, bsum));
    }
}
/*

用例:
BGBGBGBGGGBBGBGBGG
0 1 2 3   66 7 8

对应输出应该为:

33

你的输出为:

10

 */