package niuke.pdd;

import java.util.Scanner;

public class 买房2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            if (n < 3 || n - k < 1 || k < 2) System.out.println("0 0");
            else {
                int slot = 0;
                //5 3 ->2
                //5 2
                if (k > n / 2) {
                    slot = n - k;
                } else slot = k - 1;
                System.out.println("0 " + slot);
            }
        }
    }
}
