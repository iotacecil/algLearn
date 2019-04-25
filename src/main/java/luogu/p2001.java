package luogu;

import java.util.Arrays;
import java.util.Scanner;

public class p2001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i <n ; i++) {
            coins[i] = sc.nextInt();
        }
        Arrays.sort(coins);
        if(coins[0]!=1) System.out.println("No answer!!!");
        int sum = 2;

        while (sum<=m){

        }
    }
}
