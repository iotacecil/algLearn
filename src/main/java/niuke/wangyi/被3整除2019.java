package niuke.wangyi;

import java.util.Scanner;

//1    2     0     1      2    0   1   2   0   1
//1 x 12 ok 123 ok 1234 x 5 ok 6 ok 7x 8x 9ok 0ok
//12345678 (1+8)*8/2 =32
//10 110
public class 被3整除2019 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long l = sc.nextInt();
        long r = sc.nextInt();
        long cnt = 0;
        int sum = 0;
        int idx = 1;

        for (int i = 1; i < l; i++) {
            sum = (sum + idx) % 3;
            idx = (idx + 1) % 3;
        }
//        System.out.println(sum);

        for (long i = l; i <= r; i++) {
            sum = (sum + idx) % 3;
            if (sum % 3 == 0) cnt++;
            idx = (idx + 1) % 3;

        }
        System.out.println(cnt);
//        long cnt = 0;
//        long sum = 0;
//        StringBuilder sb = new StringBuilder();
//        int idx = 1;

//        for (int i = 0; i <l ; i++) {
//            sb.append(idx%10);
//            sum =(sum  + idx%10)%3;
//            idx++;
//        }
//
//        while (idx%10!=0){
//            if(idx!=1&&idx!=4&&idx!=7)cnt++;
//            idx=(idx+1)%10;
//            l++;
//        }
//        long num = r-l;
//
//        cnt+=*num/10;
//        long mod = num%10;
//        cnt+=mod/3;
//
//        System.out.println(cnt);


//        while (l<r&&l%3!=0)l++;
//        if(l<r)
//        System.out.println((r-l)/2+1);
//        else{
//            System.out.println(0);
//        }

    }
}
