package niuke.wangyi;


import java.util.Scanner;

// 超时
public class 小易的字典2019 {
//// 组合数公式 组合数模板
//public static BigInteger C(int n, int m)// 应用组合数的互补率简化计算量
//{
//    BigInteger[][] c = new BigInteger[n+1][n+1];
//    c[1][0] = c[1][1] = new BigInteger("1");
//    for (int i = 2; i <=n ; i++) {
//        c[i][0] = new BigInteger("1");;
//        for (int j = 1; j <=i ; j++) {
//            c[i][j] = (c[i-1][j].add(c[i-1][j-1]));
//        }
//
//    }
//    return c[n][m];
//}
//
//@Test
//public  void testC(){
//    System.out.println(C(6, 2));
//    System.out.println(C(5, 2));
//}

    // 排列数公式

//    static int kk;
//    static String rst;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long k = sc.nextLong();
        StringBuilder sb = new StringBuilder();

        // 如果所有组合


        while (k > 0 && m > 0 && n > 0) {
            // a开头组合数C(n+m-1,n-1)  C(3,1)= 3/1 C(2,0)
            long cnt = 1;
//            System.out.println(n+m-1+" "+(n-1));
            for (int i = 0; i < n - 1; i++) {
                cnt *= (n + m - 1 - i);
                cnt /= (i + 1);
                if (cnt > k) break;

            }


            System.out.println(cnt);
            // 如果可以跳过所有a开头先放z
            // 递归成C(n+m-2,m-1)
            if (cnt < k) {
                k -= cnt;
                //
                sb.append("z");
                m--;
            } else {
                // 如果就是在a开头里
                // 继续试试a开头 aazz azaz azza 里找第k个
                // a:cnt:3 aacnt:1 k=2 ->z  az:azacnt:1
                sb.append("a");
                n--;
            }

        }
        //最后k应该只有一种选择（？
        /*
        n(或m)等于0时，循环退出。此时子序列只剩下全是'z'(或全是'a)'这一种情况
        ，即count必为1。此时k若不等于1，则肯定是非法输入。比
         */
        if (k != 1) {
            System.out.println(-1);
            return;
        }
        while (n-- > 0) sb.append("a");
        while (m-- > 0) sb.append("z");
        System.out.println(sb.toString());


//        kk = k;
//
//        gene(cnt, "", n + m);
//        System.out.println(rst);


    }

//    private static void gene(int[] cnt, String tmp, int idx) {
//
//        if (idx == 0) {
//            kk--;
////            System.out.println(kk+" "+tmp);
//
//            if (kk == 0)
//                rst = tmp;
//            return;
//        }
//
//        if (cnt[0] > 0) {
////            kk--;
//            cnt[0]--;
//            gene(cnt, tmp + 'a', idx - 1);
//            cnt[0]++;
//        }
//        if (cnt[1] > 0) {
////            kk--;
//            cnt[1]--;
//            gene(cnt, tmp + 'z', idx - 1);
//            cnt[1]++;
//        }
//
//
//    }
}
