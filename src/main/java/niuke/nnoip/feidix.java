package niuke.nnoip;

import java.util.Scanner;

public class feidix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int rst1 = 1;
        int rst2 = 1;
        final int mod = 47;
        for (int i = 0; i <s1.length() ; i++) {
             rst1 = (rst1*( s1.charAt(i) - 'A' + 1))%mod;
        }

        for (int i = 0; i <s2.length() ; i++) {
            rst2 = (rst2* (s2.charAt(i) - 'A' + 1))%mod;
        }

        if(rst1 == rst2) System.out.println("GO");
        else System.out.println("STAY");
    }
}
