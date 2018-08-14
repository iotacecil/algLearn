package niuke;

import java.io.BufferedInputStream;
import java.util.Scanner;

//一次操作：对整个序列每个数字都操作
//一次操作中，至少一个数字执行/2
// 一次操作保证全部为整数
//结果输出能操作多少次
public class mn0701 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
//        int[] a = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            int cnt=0;
            if((num&1)==1)continue;
            while (num!=0){
                num/=2;
                cnt++;
            }
            max=Math.max(cnt,max);
        }
        System.out.println(max);

    }
}
