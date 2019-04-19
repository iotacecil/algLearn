package niuke.wangyi;

import java.util.Scanner;

/*
https://www.nowcoder.com/questionTerminal/32d1c4f18d144b6e9eb1e13481f717c5

x和y均不大于n, 并且x除以y的余数大于等于k
输入
5 2
输出
7
说明
满足条件的数对有(2,3),(2,4),(2,5),(3,4),(3,5),(4,5),(5,3)
1-n

 */
public class shudui {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        int k = sc.nextInt();
        if(k == 0)System.out.println(n*n);
        else {
            long cnt = 0;
            for (int y = k + 1; y <= n; y++) {
                cnt += (n / y) * (y - k);
                if (n % y >= k) {
                    cnt += (n % y) + 1 - k;
                }
            }
            System.out.println(cnt);
        }
    }
}
