package niuke.tecent;

import java.util.Arrays;
import java.util.Scanner;

public class choupai {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int dif = 0;
        for (int i = n-1; i >=0 ; i-=2) {
            dif += arr[i];
        }
        for (int i = n-2; i >=0 ; i-=2) {
            dif -= arr[i];
        }
        System.out.println(dif);
    }
}
