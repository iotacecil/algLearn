package other_oj;

import java.util.Scanner;

///允许有的盘子空着不放，问共有多少种不同的分法？（用K表示）5，1，1和1，5，1 是同一种分法
public class poj1664 {

    public static int fuc(int pg, int pz) {
        if (pz == 1 || pg == 1 || pg == 0) return 1;
        //如果盘子多 就是n个苹果分到n个盘子的方法（反正其它都是空的）
        // 3个苹果放到3或者4个盘子是一样的
        if (pg < pz) {
            return fuc(pg, pg);
        } else {
            // 至少一个盘子空着+每个盘子都不空
            return fuc(pg, pz - 1) + fuc(pg - pz, pz);
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            System.out.println(fuc(n, m));
        }
    }
}
