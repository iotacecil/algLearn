package other_oj;

import java.util.Scanner;

public class hdu2031 {
    public static String de2bins(int n,int r){
        String hex = "0123456789ABCDEF";
        StringBuilder sb = new StringBuilder();
        boolean nag = false;
        if(n<0){
            nag = true;
            n = -n;
        }

        while(n != 0){
            sb.append(hex.charAt(n % r));
            n/=r;

        }
        if(nag)sb.append("-");
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            System.out.println(de2bins(sc.nextInt(), sc.nextInt()));

        }
    }
}
