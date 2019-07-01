package niuke.codedance;

import java.util.Scanner;
/*
链接：https://www.nowcoder.com/questionTerminal/7037a3d57bbd4336856b8e16a9cafd71?orderByHotValue=0&mutiTagIds=134_665&page=1&onlyReference=false
来源：牛客网

每一步，它跳到下一个（右边）建筑。假设机器人在第k个建筑，且它现在的能量值是E,
下一步它将跳到第个k+1建筑。它将会得到或者失去正比于与H(k+1)与E之差的能量。
如果 H(k+1) > E 那么机器人就失去 H(k+1) - E 的能量值，否则它将得到 E - H(k+1) 的能量值。



E-(H-E) E高 负数 + E低 正数 -
2E-h

a1=2a0-h

a0 = (a1+h)/2
输入
5
3 4 3 2 4
输出
4
示例2
输入
3
4 4 4
输出
4
示例3
输入
3
1 6 4
输出
3
 */
public class 机器人跳跃2019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] builds = new int[N+1];

        for (int i = 1; i <=N ; i++) {
            builds[i] = sc.nextInt();

        }
        int[] dp = new int[N+1];
        //diff = dp[i]-build[i]
        for(int i = N-1;i>=0;i--){
            int tmp = (dp[i+1]+builds[i+1])%2==0?(dp[i+1]+builds[i+1])/2:(dp[i+1]+builds[i+1])/2+1;
            dp[i] = tmp;
        }
        System.out.println((dp[0]));


    }
}
