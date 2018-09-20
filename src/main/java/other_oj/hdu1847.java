package other_oj;

import java.util.Scanner;

public class hdu1847 {
    /**
     * n 张牌 每次抓只能抓2^x张1，2，4，8，16 最后抓完的人 胜利'
     *
     *
     * 当 n = 0 时，显然为必败点，因为此时你已经无法进行操作了
     当 n = 1 时，因为你一次就可以拿完所有牌，故此时为必胜点
     当 n = 2 时，也是一次就可以拿完，故此时为必胜点
     当 n = 3 时，要么就是剩一张要么剩两张，无论怎么取对方都将面对必胜点，故这一点为必败点。

     n    ：     0    1    2    3    4   5    6 ...
     position：  P    N    N    P    N   N    P ..
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()){
            int n = sc.nextInt();
            if(n%3==0) System.out.println("Cici");
            else System.out.println("Kiki");
        }

    }
}
