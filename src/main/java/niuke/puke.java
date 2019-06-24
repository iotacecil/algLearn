package niuke;

import java.util.Scanner;

/*
https://www.nowcoder.com/questionTerminal/2b101eacfaf641988eae013115015d54?toCommentId=1451496
链接：https://www.nowcoder.com/questionTerminal/2b101eacfaf641988eae013115015d54?toCommentId=1451496
来源：牛客网

牛牛与妞妞闲来无聊，便拿出扑克牌来进行游戏。游戏的规则很简单，两个人随机抽取四张牌，
四张牌的数字和最大的取胜（该扑克牌总张数为52张，没有大小王，A=1，J=11，Q=12，K=13，每种数字有四张牌），
现在两人已经分别亮出了自己的前三张牌，牛牛想要知道自己要赢得游戏的概率有多大。

输入描述:
输入包含两行，第一行输入三个整数a1，b1，c1(1≤a1，b1，c1≤13)，表示牛牛亮出的扑克牌。
第二行输入三个整数a2，b2，c2(1≤a2，b2，c2≤13)，表示妞妞所亮出的扑克牌。


输出描述:
输出一个数字x（保留4位小数），表示牛牛获胜的概率。

3 5 7
2 6 8

//4 4 4  2 3
//4 3 5  1 12

1+2+3...11+/13*13  12*11/2 66/169
0.3995
 */
public class puke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] cnts = new int[14];
        int[] aa = new int[3];
        int[] bb = new int[3];
        int suma = 0;
        int sumb = 0;
        for (int i = 0; i < 3; i++) {
            aa[i] = sc.nextInt();
            suma += aa[i];
            cnts[aa[i]]++;
        }
        for (int i = 0; i < 3; i++) {
            bb[i] = sc.nextInt();
            sumb += bb[i];
            cnts[bb[i]]++;
        }
        int sum = 0;
        int cnt = 0;
        boolean flag = true;
        for (int i = 1; i <= 13; i++) {
            if (cnts[i] >= 4) continue;
            cnts[i]++;
            int j = 1;
            for (j = 1; j <= 13; j++) {
                if (cnts[j] >= 4) continue;
                sum += (4 - cnts[i] + 1) * (4 - cnts[j]);

            }
            j = 1;
            for (j = 1; j <= 13; j++) {
                if (cnts[j] >= 4) continue;
                if (suma + i <= sumb + j) {
                    break;
                }
                cnt += (4 - cnts[i] + 1) * (4 - cnts[j]);

            }

            cnts[i]--;
        }

        System.out.println(cnt);
        System.out.println(sum);
        System.out.printf("%.4f", (0.0 + cnt) / sum);

    }
}
