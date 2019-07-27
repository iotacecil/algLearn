package niuke.wangyi;

import java.util.Scanner;

/*
,需要照亮的地方用'.'表示, 不需要照亮的障碍物格子用'X'表示。
, 这盏路灯可以照亮pos - 1, pos, pos + 1这三个位置。
case通过率为20.00%

用例:
9
4
..XX
1
X
8
...X.X..
2
X.
7

X..X.X.
9
....X.X..
7
..X....
1
X
9
XX.....X.

对应输出应该为:

1
0
3
1
2
3
3
0
3

你的输出为:

1
0
3
1
1
3
1
0
2
 */
public class 安置路灯2019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String str = sc.next();
            if (str.length() <= 3 && str.indexOf('.') >= 0) {
                System.out.println(1);
                continue;
            } else if (str.length() <= 3 && str.indexOf('.') < 0) {
                System.out.println(0);
                continue;
            }
            int last = -1;
            int cnt = 0;
            for (int i = 0; i < str.length(); i++) {

                if (str.charAt(i) == '.') {
                    if (last == -1) last = i;
                    int dif = i - last + 1;
                    if (dif == 3) {
                        last = -1;
                        cnt++;
                    } else if (dif > 3) {
                        last = i;
                        cnt++;
                    }
                }

            }
            if (last >= 0) cnt++;
            System.out.println(cnt);
        }
    }

}
