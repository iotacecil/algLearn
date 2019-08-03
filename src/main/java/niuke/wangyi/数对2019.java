package niuke.wangyi;

import java.util.Scanner;
//x和y均不大于n, 并且x除以y的余数大于等于k。
//牛牛希望你能帮他计算一共有多少个可能的数对。
//10 2
// 余数>=k 所以y枚举k+1~n
// x从1-n余数是1,2...y-1,0,1,2,.... 循环节长度显然是y
//总共出现了[n/y]个循环节，然后数出每个循环节里面不小于k的余数。
//x除以y的余数大于等于k。
// 数余数
//

public class 数对2019 {
    // if(n>k) x=[k,n-1] y>x&&y<=n  [x+1,n]
    //
    public static void main(String[] args) {
//        System.out.println(2%5);
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long k = sc.nextLong();

        long cnt = 0;
        if (k == 0) cnt = n * n;
//      当x<y && x>=k的时候，y只能取
//        for (int x = k; x <= n - 1; x++) {
//            cnt += (Math.max(n,x) - x);
//        }
// 当x>y && y>k 的时候，x只能取每个循环节后面>=k的几个
            // y=3 [+k,2y) [+2k,3y) 区间其实是一样的
            // 有[k,y) [y+k,2y) n=5 完整循环节=1
            // 1 【2】 0 1 【2】
            // 最后一个不完整的循环节 [xhj*y+k,n)
            // n%y最后一个区间的mod
            //
        else {
            for (long y = k + 1; y <= n; y++) {
                long xhj = n / y;
                cnt += xhj * (y - k);
                if (n % y >= k) {
                    // 5%3==2
                    cnt += (n % y) - k + 1;
                }
            }
        }
//if(k==0)cnt-=k;


        System.out.println(cnt);
    }
    // x%y>=k    x<=n

}
