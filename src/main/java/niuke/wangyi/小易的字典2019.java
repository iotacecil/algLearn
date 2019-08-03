package niuke.wangyi;

import java.util.Scanner;

// 超时
public class 小易的字典2019 {


    static int kk;
    static String rst;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] cnt = new int[2];
        cnt[0] = n;
        cnt[1] = m;
        kk = k;

        gene(cnt, "", n + m);
        System.out.println(rst);


    }

    private static void gene(int[] cnt, String tmp, int idx) {

        if (idx == 0) {
            kk--;
//            System.out.println(kk+" "+tmp);

            if (kk == 0)
                rst = tmp;
            return;
        }

        if (cnt[0] > 0) {
//            kk--;
            cnt[0]--;
            gene(cnt, tmp + 'a', idx - 1);
            cnt[0]++;
        }
        if (cnt[1] > 0) {
//            kk--;
            cnt[1]--;
            gene(cnt, tmp + 'z', idx - 1);
            cnt[1]++;
        }


    }
}
