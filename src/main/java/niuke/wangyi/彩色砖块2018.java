package niuke.wangyi;

import java.util.Scanner;

//ac
/*
如果最多存在一对不同颜色的相邻砖块,那么这行砖块就很漂亮的。
请你帮助小易计算有多少种方式将他所有砖块排成漂亮的一行。
(如果两种方式所对应的砖块颜色序列是相同的,那么认为这两种方式是一样的。)
例如: s = "ABAB",那么小易有六种排列的结果:
"AABB","ABAB","ABBA","BAAB","BABA","BBAA"
其中只有"AABB"和"BBAA"满足最多只有一对不同颜色的相邻砖块
 */
public class 彩色砖块2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(help(str));

    }

    private static int help(String str) {
        int n = str.length();
        int cnt = 0;
        int[] ch = new int[26];
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (ch[c - 'A'] == 0) cnt++;
            ch[c - 'A']++;
        }
        if (cnt > 2) return -1;
        else if (cnt == 2) return 2;
        else if (cnt == 1) return 1;
        return -1;
    }
}
