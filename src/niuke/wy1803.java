package niuke;

import java.util.Scanner;

public class wy1803 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        int cnt;
        if(next==null||next.length()<1){
            cnt=0;
            System.out.println(cnt);
        }
        else if(next.length()<2){
            cnt =1;
            System.out.print(cnt);
        }else {
            cnt=1;


        for (int i = 1; i <next.length() ; i++) {
            if(next.charAt(i-1)!=next.charAt(i)){
                cnt++;
            }
        }
            double i = (double)next.length() / cnt;
            String s=String.format("%.2f",i);
            System.out.println(s);
        }
    }
}
