package niuke.zhaoyin;

import java.util.Scanner;

/*
链接：https://www.nowcoder.com/questionTerminal/1177e9bd1b5e4e00bd39ca4ea9e4e216
来源：牛客网

小招喵喜欢在数轴上跑来跑去，假设它现在站在点n处，它只会3种走法，分别是：
1.数轴上向前走一步，即n=n+1
2.数轴上向后走一步,即n=n-1
3.数轴上使劲跳跃到当前点的两倍，即n=2*n
现在小招喵在原点，即n=0，它想去点x处，快帮小招喵算算最快的走法需要多少步？
 */
public class 小招喵跑步2018 {

    private static int minstep(int x) {
        x = Math.abs(x);
        if (x == 0) return 0;
        if (x == 1) return 1;
        else if (x % 2 == 0) {
            return minstep(x / 2) + 1;
        } else {
            return Math.min(minstep(x - 1) + 1, minstep(x + 1) + 1);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        n = Math.abs(n);
        int[] dp = new int[n + 1];

        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2] + 1;
            } else {
                dp[i] = Math.min(dp[i - 1], dp[(i + 1) / 2] + 1) + 1;
            }

        }
        System.out.println(dp[n]);
//        System.out.println(minstep(n));

    }
}
