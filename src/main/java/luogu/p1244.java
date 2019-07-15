package luogu;

import java.util.Scanner;

/*
左边一个石墩(A区),河中有k个荷叶(C区)，还有h个石墩(D区)，右边有一个石墩(B区)，
(从左岸石墩A到右岸石墩B)，规则为：
1)石墩上可以承受任意多只青蛙，荷叶只能承受一只青蛙(不论大小)；

(2)青蛙可以：A→B(表示可以从A跳到B，下同)，A→C，A→D，C→B，D→B，D→C，C→D；

(3)当一个石墩上有多只青蛙时，则上面的青蛙只能跳到比它大1号的青蛙上面。

你的任务是对于给出的h，k，计算并输出最多能有多少只青蛙可以根据以上规则顺利过河
 */
public class p1244 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long h = sc.nextLong();
        long k = sc.nextLong();
        System.out.println((k + 1) * (1 << h));
    }
}
