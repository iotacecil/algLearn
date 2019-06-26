package niuke.duxiaoman;
/*

每次可以将字符串中的一个子串xy替换成字符串yyx
，那么至少要替换多少次才能让字符串中不存在子串xy？
最少替换次数对109+7取模后的结果。

xxy
3
xxxxy
// n = 3 +1
x xxy->3->x yyyyxx(4y)->yy xy yyyxx(3y)->yyyyxyy2->yyyyyyxy1->0 +5

x xy->xyyx->yyxyx->yyyyxx 3 n=2 +1
xy->yyx 1

xyy->yyxy->yyyyx
xyx-> yyxx
 */

import java.util.Scanner;

public class 字符串替换2019 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

    }
}
