package niuke.wangyi;

import java.util.Scanner;
//x和y均不大于n, 并且x除以y的余数大于等于k。
//牛牛希望你能帮他计算一共有多少个可能的数对。
//10 2
// 余数>=k 所以y枚举k+1~n
// x从1-n余数是1,2...y-1,0,1,2,.... 循环节长度显然是y
//总共出现了[n/y]个循环节，然后数出每个循环节里面不小于k的余数。
//

public class 数对2019 {
    // if(n>k) x=[k,n-1] y>x&&y<=n  [x+1,n]
    //
    public static void main(String[] args) {
//        System.out.println(2%5);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        long cnt = 0;
//        if(n>k){
        for (int x = k; x <= n - 1; x++) {
            cnt += (n - x);
        }
        //   System.out.println(cnt);
//        }
        // if(n<k)
        //  y>2 x>=y+k
//        int y = k+1;
        // y<x y=3 y+k=5
        for (int y = k + 1; y + k <= n; y++) {
            cnt += (n - y - k + 1);
        }


//        for (int i = k; i <=n ; i++) {
//            for (int j = 1; j <=n ; j++) {
//                if(i%j>=k)cnt++;
//
//            }
//
//        }
        System.out.println(cnt);
    }
    // x%y>=k    x<=n

}
