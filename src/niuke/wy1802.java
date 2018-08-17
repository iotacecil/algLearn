package niuke;

import java.util.Scanner;

public class wy1802 {
    private static int reverse(int n){
        int flag = 1;
        if(n<0){
            flag = -1;
            n = -n;
        }
        int rst=0;
        while(n>0){
            rst*=10;
            rst+=n%10;
            n/=10;
        }
        return rst*flag;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int reverse = reverse(n);
        System.out.println(n+reverse);

    }
}
